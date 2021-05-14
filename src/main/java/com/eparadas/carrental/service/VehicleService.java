package com.eparadas.carrental.service;
import com.eparadas.carrental.domain.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    public List<Vehicle> listAll();

    public void save(Vehicle vehicle);

    public void register(Vehicle vehicle);

    public void delete(Vehicle vehicle);

    public Optional<Vehicle> findVehicleById(Long vehicleId);

    public List<Vehicle> findAllByRentPriceOrderByAsc();

    public List<Vehicle> findAllByRentPriceOrderByDesc();

    public List<Vehicle> findAllByBrandOrderByAsc();

    public List<Vehicle> findAllByBrandOrderByDesc();

    public List<Vehicle> findAllByModelOrderByAsc();

    public List<Vehicle> findAllByModelOrderByDesc();

    public List<Vehicle> findAllByTypeOrderByAsc();

    public List<Vehicle> findAllByTypeOrderByDesc();

    public List<Vehicle> findAllByColourOrderByAsc();

    public List<Vehicle> findAllByColourOrderByDesc();

    public List<Vehicle> findAllByTransmissionOrderByAsc();

    public List<Vehicle> findAllByTransmissionOrderByDesc();

}
