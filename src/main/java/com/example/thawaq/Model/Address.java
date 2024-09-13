package com.example.thawaq.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    private Integer id; //v2


    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String city;
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String street;

    @OneToOne
    @JsonIgnore
    @MapsId
    private Branch branch;
}
