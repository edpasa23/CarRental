package com.eparadas.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "returned_cars")
@AllArgsConstructor
@NoArgsConstructor
public class ReturnedCars implements Serializable {

    private static final long serialVersionUID = 1L;

    public ReturnedCars(Long rentId){
        this.rentId = rentId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_id")
    private Long returnId;

    @NotNull
    @Column(name = "return_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;

    @Id
    @Column(name = "rent_id")
    private Long rentId;

    @Column(name = "penaltyFee")
    private int penaltyFee;


}
