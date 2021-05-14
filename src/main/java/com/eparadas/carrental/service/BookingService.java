package com.eparadas.carrental.service;

import com.eparadas.carrental.domain.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> findAll();

    void save(Booking reservation);

    void delete(Booking reservation);

    Booking findReservation(Booking booking);

    List<Booking> findAllByVehicleId(Long vehicleId);

    List<Booking> findAllByUserId(Long userId);

    List<Booking> findAllByRentId(Long rentId);

    Booking findByRentId(Long rentId);

}
