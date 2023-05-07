package com.library.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RENTALS")
@Setter(AccessLevel.PRIVATE)
public class Rentals {
    private Long idRentals;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private Readers readers;
    private List<Copy> copyList = new ArrayList<>();

    @Id
    @GeneratedValue
    @NonNull
    @Column(name = "ID_RENTAL",unique = true)
    public Long getIdRentals() {
        return idRentals;
    }

    @Column(name = "RENTAL_DATE")
    public LocalDate getRentalDate() {
        return rentalDate;
    }

    @Column(name = "RETURN_DATE")
    public LocalDate getReturnDate() {
        return returnDate;
    }

    public List<Copy> getCopyList() {
        return copyList;
    }

    @ManyToOne
    @JoinColumn(name = "ID_READERS")
    public Readers getReaders() {
        return readers;
    }
}
