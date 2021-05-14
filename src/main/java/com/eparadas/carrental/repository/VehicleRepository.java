package com.eparadas.carrental.repository;

import com.eparadas.carrental.domain.User;
import com.eparadas.carrental.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

    List<Vehicle> findAllByOrderByRentPriceAsc();

    List<Vehicle> findAllByOrderByRentPriceDesc();

    List<Vehicle> findAllByOrderByBrandAsc();

    List<Vehicle> findAllByOrderByBrandDesc();

    List<Vehicle> findAllByOrderByModelAsc();

    List<Vehicle> findAllByOrderByModelDesc();

    List<Vehicle> findAllByOrderByVehicleTypeAsc();

    List<Vehicle> findAllByOrderByVehicleTypeDesc();

    List<Vehicle> findAllByOrderByColourAsc();

    List<Vehicle> findAllByOrderByColourDesc();

    List<Vehicle> findAllByOrderByTransmissionAsc();

    List<Vehicle> findAllByOrderByTransmissionDesc();

}
