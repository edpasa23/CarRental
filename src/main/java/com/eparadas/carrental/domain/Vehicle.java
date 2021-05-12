package com.eparadas.carrental.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Data
@Table(name = "vehicle")
@Entity
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    public Vehicle(Long id){
        this.vehicleId = id;
    }

    public Vehicle() {
    }

    public Vehicle(Long vehicleId, @NotEmpty String brand, @NotEmpty String model, @NotEmpty String colour, @NotEmpty String vehicleType, @NotEmpty String transmission, @NotNull int rentPrice) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.vehicleType = vehicleType;
        this.transmission = transmission;
        this.rentPrice = rentPrice;
    }

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
    @Column(name = "colour")
    private String colour;

    @NotEmpty
    @Column(name = "vehicle_type")
    private String vehicleType;

    @NotEmpty
    @Column(name = "transmission")
    private String transmission;

    @NotNull
    @Column(name = "rent_price")
    private int rentPrice;


/*    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Set<Booking> booking;*/

}
