package com.eparadas.carrental.web;

import com.eparadas.carrental.domain.Booking;
import com.eparadas.carrental.domain.User;
import com.eparadas.carrental.domain.Vehicle;
import com.eparadas.carrental.service.BookingService;
import com.eparadas.carrental.service.BookingValidationService;
import com.eparadas.carrental.service.UserService;
import com.eparadas.carrental.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String saveBooking(@Valid Booking booking, BindingResult result, Errors error) {

        String err = bookingValidationService.validateBooking(booking);

        if (!err.isEmpty()) {
            ObjectError validationError = new ObjectError("globalError", err);
            result.addError(validationError);
        }
        if (error.hasErrors()) {
            System.out.println(error.toString());
            return "add-booking";
        }

        User user = new User(booking.getUsername());
        int price=0;

        booking.setUserId(userService.findUserByUsername(user.getUsername()).getUserId());

        Vehicle vehicle = new Vehicle(booking.getVehicleId());
        Optional<Vehicle> aux = vehicleService.findVehicleById(vehicle.getVehicleId());

        if(aux.isPresent()){
            price = (aux.get()).getRentPrice();
        }

        LocalDate m = booking.getRentTo();
        int i = m.compareTo(booking.getRentFrom());
        booking.setPrice(price*i);

        bookingService.save(booking);
        return "correct-booking";
    }

    @GetMapping("/bookedList")
    public String bookedList(Model model){
        List<Booking> bookingList = bookingService.findAll();
        model.addAttribute("bookingList",bookingList);
        return "booked-list";
    }

}
