package com.library.api.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "READERS")
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class Readers {
    private Long idReader;
    private String readerName;
    private String readerSurname;
    private LocalDate dateCreateAccount;
    private List<Rentals> rentalsList = new ArrayList<>();

    @Id
    @GeneratedValue
    @NonNull
    @Column(name = "ID_READER", unique = true)
    public Long getIdReader() {
        return idReader;
    }

    @Column(name = "READER_NAME")
    public String getReaderName() {
        return readerName;
    }

    @Column(name = "READER_SURNAME")
    public String getReaderSurname() {
        return readerSurname;
    }

    @Column(name = "READER_DATE_CREATE_ACCOUNT")
    public LocalDate getDateCreateAccount() {
        return dateCreateAccount;
    }

    @OneToMany(targetEntity = Rentals.class,
               mappedBy = "readers",
               fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    public List<Rentals> getRentalsList() {
        return rentalsList;
    }
}