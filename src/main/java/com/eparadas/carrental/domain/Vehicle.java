package com.eparadas.carrental.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Data
@Table(name = "vehicle")
@Entity
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long vehicleId;

    @NotEmpty
    @Column(name = "brand")
    private String brand;

    @NotEmpty
    @Column(name = "model")
    private String model;

    @NotEmpty
    @Column(name = "no_of_seats")
    private String noOfSeats;

    @NotEmpty
    @Column(name = "colour")
    private String colour;

    @NotEmpty
    @Column(name = "vehicle_type")
    private String vehicleType;

    @NotEmpty
    @Column(name = "transmission")
    private String transmission;

    @NotEmpty
    @Column(name = "rent_price")
    private String rentPrice;

    @NotEmpty
    @Column(name = "availability")
    private Boolean availability;

/*    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Set<Booking> booking;*/

}
