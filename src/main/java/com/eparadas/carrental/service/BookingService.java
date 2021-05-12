package com.eparadas.carrental.service;

import com.eparadas.carrental.domain.Booking;

import java.util.List;

public interface BookingService {

    public List<Booking> findAll();

    public void save(Booking reservation);

    public void delete(Booking reservation);

    public Booking findReservation(Booking booking);

    public List<Booking> findAllByVehicleId(Booking booking);

}
