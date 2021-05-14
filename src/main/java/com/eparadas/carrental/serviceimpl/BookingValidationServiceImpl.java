package com.eparadas.carrental.serviceimpl;

import com.eparadas.carrental.domain.Booking;
import com.eparadas.carrental.domain.User;
import com.eparadas.carrental.service.BookingService;
import com.eparadas.carrental.service.BookingValidationService;
import com.eparadas.carrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingValidationServiceImpl implements BookingValidationService {

    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService;

    @Override
    public String validateBooking(Booking booking) {

        String message = "";


        LocalDate todaysdate = LocalDate.now();
        LocalDate from = booking.getRentFrom();
        LocalDate to = booking.getRentTo();

        if(todaysdate.isAfter(from)){
            message = message + " *\"Rent From\" date has already passed";
        }
        if(todaysdate.isAfter(to)){
            message = message + " *\"Rent to\" date has already passed";
        }
        if(to.isBefore(from)){
            message = message + " *Not valid rent dates";
        }

        List<Booking> bookings = bookingService.findAllByVehicleId(booking.getVehicleId());

        for(Booking x: bookings){
            if(from.isAfter(x.getRentFrom()) && from.isBefore(x.getRentTo())){
                message = message + " *The vehicule is alredy rented for that date";
                break;
            }

            if(to.isAfter(x.getRentFrom()) && to.isBefore(x.getRentTo())){
                message = message + " *The vehicule is alredy rented for that date";
                break;
            }

        }

        return message;
    }
}
