package com.eparadas.carrental.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;


@Data
@Table(name = "booking")
@Entity
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_id")
    private Long rentId;

    @NotNull
    @Column(name = "vehicle_id")
    private Long vehicleId;

    @Column(name = "user_id")
    private Long userId;

    @NotNull
    @Column(name = "rent_from")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentFrom;

    @NotNull
    @Column(name = "rent_to")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentTo;

    @Column(name = "price")
    private int price;

}
