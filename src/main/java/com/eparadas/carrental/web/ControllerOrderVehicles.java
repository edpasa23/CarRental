package com.eparadas.carrental.web;

import com.eparadas.carrental.domain.Vehicle;
import com.eparadas.carrental.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ControllerOrderVehicles {

    @Autowired
    private VehicleService vehicleService;

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

}
