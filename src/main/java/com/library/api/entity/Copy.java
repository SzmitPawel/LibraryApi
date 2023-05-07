package com.library.api.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COPY")
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class Copy {
    private Long idCopy;
    private Boolean status;

    private List<Rentals> rentalsList = new ArrayList<>();

    @Id
    @GeneratedValue
    @NonNull
    @Column(name = "ID_COPY",unique = true)
    public Long getIdCopy() {
        return idCopy;
    }

    @Column(name = "STATUS")
    public Boolean getStatus() {
        return status;
    }

    @OneToMany(targetEntity = Rentals.class,
               mappedBy = "copy",
               fetch = FetchType.LAZY)
    public List<Rentals> getRentalsList() {
        return rentalsList;
    }
}
