package com.eparadas.carrental.repository;

import com.eparadas.carrental.domain.User;
import com.eparadas.carrental.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

    public List<Vehicle> findAllByOrderByRentPriceAsc();

    public List<Vehicle> findAllByOrderByRentPriceDesc();

    public List<Vehicle> findAllByOrderByBrandAsc();

    public List<Vehicle> findAllByOrderByBrandDesc();

    public List<Vehicle> findAllByOrderByModelAsc();

    public List<Vehicle> findAllByOrderByModelDesc();

    public List<Vehicle> findAllByOrderByVehicleTypeAsc();

    public List<Vehicle> findAllByOrderByVehicleTypeDesc();

    public List<Vehicle> findAllByOrderByColourAsc();

    public List<Vehicle> findAllByOrderByColourDesc();

    public List<Vehicle> findAllByOrderByTransmissionAsc();

    public List<Vehicle> findAllByOrderByTransmissionDesc();

}
