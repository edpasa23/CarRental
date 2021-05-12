package com.eparadas.carrental.web;


import com.eparadas.carrental.domain.Booking;
import com.eparadas.carrental.domain.User;
import com.eparadas.carrental.domain.Vehicle;
import com.eparadas.carrental.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerCarRental {

    @Autowired
    private UserService userService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingValidationService bookingValidationService;

    @Autowired
    private UserValidationService userValidationService;

    //********USER METHODS*****************

    @GetMapping("createAccount")
    public String createAccount(User user){
        return "create-account";
    }

    //Registro (valida y asigna rol de USER)
    @PostMapping("/signUp")
    public String signUp(@Valid User user, BindingResult result, Errors error) {
        String err = userValidationService.validateUser(user);
        if (!err.isEmpty()) {
            ObjectError validationError = new ObjectError("globalError", err);
            result.addError(validationError);
        }
        if (error.hasErrors()) {
            return "create-account";
        }
        userService.register(user);
        return "correct-registration";
    }


    //***************ADMIN METHODS***********

    @GetMapping("/usersList")
    public String viewUsers(Model model){
        List<User> clientsList = userService.listAll();
        model.addAttribute("userList",clientsList);
        return "user-list";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(User user){
        userService.delete(user);
        return "redirect:/usersList";
    }

    @GetMapping("/addUser")
    public String addUser(User user){
        return "add-modify-user";
    }

    @PostMapping("/signUpByAdmin")
    public String signUpByAdmin(@Valid User user, BindingResult result, Errors error) {
        String err = userValidationService.validateUser(user);
        if (!err.isEmpty()) {
            ObjectError validationError = new ObjectError("globalError", err);
            result.addError(validationError);
        }
        if (error.hasErrors()) {
            return "create-account-by-admin";
        }
        userService.register(user);
        return "redirect:/user-list";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid User user, BindingResult result, Errors error) {
        String err = userValidationService.validateUser(user);
        if (!err.isEmpty()) {
            ObjectError validationError = new ObjectError("globalError", err);
            result.addError(validationError);
        }
        if (error.hasErrors()) {
            System.out.println(error.toString());
            return "add-modify-user";
        }
        userService.save(user);
        return "redirect:/usersList";
    }

    @GetMapping("/editUser")
    public String editUser(User user,Model model){
        user = userService.findUserById(user);
        model.addAttribute("user", user);
        return "add-modify-user";
    }

    //***************ADMIN METHODS CARS***********

    @GetMapping("/deleteCar")
    public String deleteCar(Vehicle vehicle){
        vehicleService.delete(vehicle);
        return "redirect:/carsList";
    }

    @GetMapping("/editCar")
    public String editCar(Vehicle vehicle,Model model){
        vehicle = vehicleService.findVehicleById(vehicle);
        model.addAttribute("vehicle",vehicle);
        return "edit-car";
    }


    @PostMapping("/registerCar")
    public String registerCar(@Valid Vehicle vehicle, BindingResult result, Errors error) {

        if (error.hasErrors()) {
            return "add-car";
        }
        vehicleService.register(vehicle);
        return "redirect:/cars-list";
    }

    @GetMapping("/addCar")
    public String addCar(Vehicle vehicle){
        return "add-car";
    }

    @PostMapping("/saveCar")
    public String saveCar(@Valid Vehicle vehicle, BindingResult result, Errors error) {

        if (error.hasErrors()) {
            System.out.println(error.toString());
            return "edit-car";
        }
        vehicleService.save(vehicle);
        return "redirect:/carsList";
    }

    //////////////////CARS METHODS**********

    @GetMapping("/carsList")
    public String viewCars(Model model){
        List<Vehicle> carsList = vehicleService.listAll();
        model.addAttribute("carsList",carsList);
        return "cars-list";
    }

    @GetMapping("/orderPriceOrderAsc")
    public String findPriceAsc(Model model){
        List<Vehicle> vehicles = vehicleService.findAllByRentPriceOrderByAsc();
        model.addAttribute("carsList",vehicles);
        return "cars-list";
    }



    @GetMapping("/orderPriceOrderDesc")
    public String findPriceDesc(Model model){
        List<Vehicle> vehicles = vehicleService.findAllByRentPriceOrderByDesc();
        model.addAttribute("carsList",vehicles);
        return "cars-list";
    }

    @GetMapping("/orderBrandOrderAsc")
    public String findBrandAsc(Model model){
        List<Vehicle> vehicles = vehicleService.findAllByBrandOrderByAsc();
        model.addAttribute("carsList",vehicles);
        return "cars-list";
    }

    @GetMapping("/orderBrandOrderDesc")
    public String findBrandDesc(Model model){
        List<Vehicle> vehicles = vehicleService.findAllByBrandOrderByDesc();
        model.addAttribute("carsList",vehicles);
        return "cars-list";
    }

    @GetMapping("/orderModelOrderAsc")
    public String findModelAsc(Model model){
        List<Vehicle> vehicles = vehicleService.findAllByModelOrderByAsc();
        model.addAttribute("carsList",vehicles);
        return "cars-list";
    }

    @GetMapping("/orderModelOrderDesc")
    public String findModelDesc(Model model){
        List<Vehicle> vehicles = vehicleService.findAllByModelOrderByDesc();
        model.addAttribute("carsList",vehicles);
        return "cars-list";
    }

    @GetMapping("/orderTypeOrderAsc")
    public String findTypeAsc(Model model){
        List<Vehicle> vehicles = vehicleService.findAllByTypeOrderByAsc();
        model.addAttribute("carsList",vehicles);
        return "cars-list";
    }

    @GetMapping("/orderTypeOrderDesc")
    public String findTypeDesc(Model model){
        List<Vehicle> vehicles = vehicleService.findAllByTypeOrderByDesc();
        model.addAttribute("carsList",vehicles);
        return "cars-list";
    }

    @GetMapping("/orderColourOrderAsc")
    public String findColourAsc(Model model){
        List<Vehicle> vehicles = vehicleService.findAllByColourOrderByAsc();
        model.addAttribute("carsList",vehicles);
        return "cars-list";
    }

    @GetMapping("/orderColourOrderDesc")
    public String findColourDesc(Model model){
        List<Vehicle> vehicles = vehicleService.findAllByColourOrderByDesc();
        model.addAttribute("carsList",vehicles);
        return "cars-list";
    }

    @GetMapping("/orderTransmissionOrderAsc")
    public String findTransmissionAsc(Model model){
        List<Vehicle> vehicles = vehicleService.findAllByTransmissionOrderByAsc();
        model.addAttribute("carsList",vehicles);
        return "cars-list";
    }

    @GetMapping("/orderTransmissionOrderDesc")
    public String findTransmissionDesc(Model model){
        List<Vehicle> vehicles = vehicleService.findAllByTransmissionOrderByDesc();
        model.addAttribute("carsList",vehicles);
        return "cars-list";
    }

    @GetMapping("/filterByMidSize")
    public String filterByMidSize(Model model){
        List<Vehicle> aux = vehicleService.listAll();
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle x:aux){
            if(x.getVehicleType().equals("Mid-size")){
                vehicles.add(x);
            }
        }
        model.addAttribute("carsList",vehicles);
        return "cars-list";
    }

    @GetMapping("/filterByMidLuxury")
    public String filterByMidLuxury(Model model){
        List<Vehicle> aux = vehicleService.listAll();
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle x:aux){
            if(x.getVehicleType().equals("Mid-size luxury ")){
                vehicles.add(x);
            }
        }
        model.addAttribute("carsList",vehicles);
        return "cars-list";
    }

    @GetMapping("/filterByLuxuryCompact")
    public String filterByLuxuryCompact(Model model){
        List<Vehicle> aux = vehicleService.listAll();
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle x:aux){
            if(x.getVehicleType().equals("Luxury compact")){
                vehicles.add(x);
            }
        }
        model.addAttribute("carsList",vehicles);
        return "cars-list";
    }

    @GetMapping("/filterByFullSize")
    public String filterByFullSize(Model model){
        List<Vehicle> aux = vehicleService.listAll();
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle x:aux){
            if(x.getVehicleType().equals("Full Size")){
                vehicles.add(x);
            }
        }
        model.addAttribute("carsList",vehicles);
        return "cars-list";
    }

    @GetMapping("/filterBySport")
    public String filterBySport(Model model){
        List<Vehicle> aux = vehicleService.listAll();
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle x:aux){
            if(x.getVehicleType().equals("Sport")){
                vehicles.add(x);
            }
        }
        model.addAttribute("carsList",vehicles);
        return "cars-list";
    }

    @GetMapping("/filterByCrossSUV")
    public String filterByCrossSUV(Model model){
        List<Vehicle> aux = vehicleService.listAll();
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle x:aux){
            if(x.getVehicleType().equals("Crossover SUV")){
                vehicles.add(x);
            }
        }
        model.addAttribute("carsList",vehicles);
        return "cars-list";
    }

    //***************BOOKING METHODS CARS***********

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
        booking.setUserId(userService.findUserByUsername(user).getUserId());

        Vehicle vehicle = new Vehicle(booking.getVehicleId());
        int price = vehicleService.findVehicleById(vehicle).getRentPrice();

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