package com.eparadas.carrental.serviceimpl;

import com.eparadas.carrental.domain.Booking;
import com.eparadas.carrental.domain.Vehicle;
import com.eparadas.carrental.repository.BookingRepository;
import com.eparadas.carrental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAll(){
        return (List<Booking>) bookingRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Booking reservation){
        bookingRepository.save(reservation);
    }

    @Override
    @Transactional
    public void delete(Booking reservation){
        bookingRepository.delete(reservation);
    }

    @Override
    @Transactional(readOnly = true)
    public Booking findReservation(Booking booking){
        return bookingRepository.findById(booking.getRentId()).orElse(null);
    }

    @Override
    public List<Booking> findAllByVehicleId(Long vehicleId) {
        List<Booking> bookingList = bookingRepository.findAllByVehicleId(vehicleId);
        return bookingList;
    }

    @Override
    public List<Booking> findAllByUserId(Long userId) {
        List<Booking> bookingList = bookingRepository.findAllByUserId(userId);
        return bookingList;
    }


}
