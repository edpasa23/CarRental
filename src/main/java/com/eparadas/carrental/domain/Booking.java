package com.eparadas.carrental.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;


@Data
@Table(name = "booking")
@Entity
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_id")
    private Long rentId;

    @NotEmpty
    @Column(name = "rent_from")
    private String rentFrom;

    @NotEmpty
    @Column(name = "rent_to")
    private String rentTo;

    @NotEmpty
    @Column(name = "price")
    private String price;

}
