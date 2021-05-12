package com.eparadas.carrental.repository;

import com.eparadas.carrental.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    public List<Booking> findAllByVehicleId(Long id);

}
