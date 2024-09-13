package com.example.thawaq.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should not be empty")
    @Size(max = 50,message = "name should be less than 51")
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String name;

    @NotEmpty(message = "type of activity should not be empty")
    @Pattern(regexp = "BOTH|CAFE|RESTAURANT",message = "type of activity must be BOTH,CAFE or RESTAURANT")
    @Column(columnDefinition = "VARCHAR(10) NOT NULL")
    private String typeOfActivity;

    @NotEmpty(message = "phone number should not be empty")
    @Pattern(regexp = "^(05)(\\d){8}$",message = "phone number should start with 05")
    @Column(columnDefinition = "VARCHAR(10) NOT NULL")
    private String phoneNumber;

    @NotEmpty(message = "commercial register should not be empty")
    @Size(max = 10,message = "name should be less than 11")
    @Column(columnDefinition = "VARCHAR(10) NOT NULL")
    private String commercialRegister;

    @NotEmpty(message = "restaurant image should not be empty")
    @Size(max = 1000,message = "name should be less than 1001")
    @Column(columnDefinition = "VARCHAR(1000) NOT NULL")
    private String restaurantImage;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "store")
    private Set<Branch> branches;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "store")
    private Set<Rating> ratings;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "store")
    private Set<Request> requests;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "store")
    private Set<StoreAdmin> storeAdmins;
}
