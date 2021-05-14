package com.eparadas.carrental.web;

import com.eparadas.carrental.domain.Booking;
import com.eparadas.carrental.domain.User;
import com.eparadas.carrental.domain.Vehicle;
import com.eparadas.carrental.service.BookingService;
import com.eparadas.carrental.service.BookingValidationService;
import com.eparadas.carrental.service.UserService;
import com.eparadas.carrental.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class ControllerBooking {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingValidationService bookingValidationService;

    @Autowired
    private UserService userService;

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/addBooking")
    public String addBooking(Booking booking){
        return "add-booking";
    }

    @GetMapping("/deleteBooking")
    public String deleteBooking(Booking booking){
        bookingService.delete(booking);
        return "redirect:/bookedList";
    }

    @PostMapping("/saveBooking")
    public String saveBooking(@Valid Booking booking, BindingResult result, Errors error, Model model) {

        String err = bookingValidationService.validateBooking(booking);

        if (!err.isEmpty()) {
            ObjectError validationError = new ObjectError("globalError", err);
            result.addError(validationError);
        }
        if (error.hasErrors()) {
            System.out.println(error.toString());
            return "add-booking";
        }

        int price=0;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            booking.setUserId(userService.findUserByUsername(currentUserName).getUserId());
        }

        Vehicle vehicle = new Vehicle(booking.getVehicleId());
        Optional<Vehicle> aux = vehicleService.findVehicleById(vehicle.getVehicleId());

        if(aux.isPresent()){
            price = (aux.get()).getRentPrice();
        }

        LocalDate m = booking.getRentTo();
        int i = m.compareTo(booking.getRentFrom());
        booking.setPrice(price*i);

        bookingService.save(booking);

        model.addAttribute("rentId",booking.getRentId());

        return "correct-booking";
    }

    @GetMapping("/bookedList")
    public String bookedList(Model model){
        List<Booking> bookingList = bookingService.findAll();
        model.addAttribute("bookingList",bookingList);
        return "booked-list";
    }

    @GetMapping("/bookedByUser")
    public String bookedByUser(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long id = null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            id = (userService.findUserByUsername(currentUserName)).getUserId();
        }
        List<Booking> bookingList = bookingService.findAllByUserId(id);
        model.addAttribute("bookingList",bookingList);
        return "booked-by-list";


    }


}
