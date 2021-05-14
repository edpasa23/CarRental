package com.eparadas.carrental.serviceimpl;


import com.eparadas.carrental.domain.Vehicle;
import com.eparadas.carrental.repository.VehicleRepository;
import com.eparadas.carrental.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> listAll() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    @Transactional
    public void register(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    @Transactional
    public void delete(Vehicle vehicle) {
        vehicleRepository.delete(vehicle);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Vehicle> findVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAllByRentPriceOrderByAsc() {
        List<Vehicle> vehicles = vehicleRepository.findAllByOrderByRentPriceAsc();
        return vehicles;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAllByRentPriceOrderByDesc() {
        List<Vehicle> vehicles = vehicleRepository.findAllByOrderByRentPriceDesc();
        return vehicles;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAllByBrandOrderByAsc(){
        List<Vehicle> vehicles = vehicleRepository.findAllByOrderByBrandAsc();
        return vehicles;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAllByBrandOrderByDesc(){
        List<Vehicle> vehicles = vehicleRepository.findAllByOrderByBrandDesc();
        return vehicles;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAllByModelOrderByAsc(){
        List<Vehicle> vehicles = vehicleRepository.findAllByOrderByModelAsc();
        return vehicles;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAllByModelOrderByDesc(){
        List<Vehicle> vehicles = vehicleRepository.findAllByOrderByModelDesc();
        return vehicles;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAllByTypeOrderByAsc(){
        List<Vehicle> vehicles = vehicleRepository.findAllByOrderByVehicleTypeAsc();
        return vehicles;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAllByTypeOrderByDesc() {
        List<Vehicle> vehicles = vehicleRepository.findAllByOrderByVehicleTypeDesc();
        return vehicles;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAllByColourOrderByAsc(){
        List<Vehicle> vehicles = vehicleRepository.findAllByOrderByColourAsc();
        return vehicles;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAllByColourOrderByDesc(){
        List<Vehicle> vehicles = vehicleRepository.findAllByOrderByColourDesc();
        return vehicles;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAllByTransmissionOrderByAsc(){
        List<Vehicle> vehicles = vehicleRepository.findAllByOrderByTransmissionAsc();
        return vehicles;
    }
    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAllByTransmissionOrderByDesc(){
        List<Vehicle> vehicles = vehicleRepository.findAllByOrderByTransmissionDesc();
        return vehicles;
    }

}
