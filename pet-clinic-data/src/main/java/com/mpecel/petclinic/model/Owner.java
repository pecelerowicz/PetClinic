package com.mpecel.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city,
                 String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner") // czyli w bazie danych nie bedzie kolumny pet_id w tabeli owners? A bedzie owner_id w tabeli pets? // owner może mieć wiele zwierząt, więc chyba i tak by się nie dało napisać pet_id (bo jest wiele)? To chyba nie jest problem
    private Set<Pet> pets = new HashSet<>();

}
