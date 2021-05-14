package com.eparadas.carrental.web;

import com.eparadas.carrental.domain.Vehicle;
import com.eparadas.carrental.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerFilterVehicles {

    @Autowired
    private VehicleService vehicleService;

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
}
