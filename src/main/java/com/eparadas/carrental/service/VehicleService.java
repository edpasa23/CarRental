package com.eparadas.carrental.service;
import com.eparadas.carrental.domain.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    List<Vehicle> listAll();

    void save(Vehicle vehicle);

    void register(Vehicle vehicle);

    void delete(Vehicle vehicle);

    Optional<Vehicle> findVehicleById(Long vehicleId);

    List<Vehicle> findAllByRentPriceOrderByAsc();

    List<Vehicle> findAllByRentPriceOrderByDesc();

    List<Vehicle> findAllByBrandOrderByAsc();

    List<Vehicle> findAllByBrandOrderByDesc();

    List<Vehicle> findAllByModelOrderByAsc();

    List<Vehicle> findAllByModelOrderByDesc();

    List<Vehicle> findAllByTypeOrderByAsc();

    List<Vehicle> findAllByTypeOrderByDesc();

    List<Vehicle> findAllByColourOrderByAsc();

    List<Vehicle> findAllByColourOrderByDesc();

    List<Vehicle> findAllByTransmissionOrderByAsc();

    List<Vehicle> findAllByTransmissionOrderByDesc();

}
