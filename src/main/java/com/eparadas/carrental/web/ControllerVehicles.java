package com.eparadas.carrental.web;

import com.eparadas.carrental.domain.Vehicle;
import com.eparadas.carrental.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ControllerVehicles {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/deleteCar")
    public String deleteCar(Vehicle vehicle){
        vehicleService.delete(vehicle);
        return "redirect:/carsList";
    }

    @GetMapping("/editCar")
    public String editCar(Vehicle vehicle, Model model){
        Optional<Vehicle> aux = vehicleService.findVehicleById(vehicle.getVehicleId());

        if(aux.isPresent()){
            vehicle = aux.get();
        }
        model.addAttribute("vehicle",vehicle);
        return "edit-car";
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



    @GetMapping("/carsList")
    public String viewCars(Model model){
        List<Vehicle> carsList = vehicleService.listAll();
        model.addAttribute("carsList",carsList);
        return "cars-list";
    }

}
