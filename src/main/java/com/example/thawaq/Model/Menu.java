package com.example.thawaq.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = " name can not be null")
    @Column(columnDefinition = "varchar(50) not null")
    private String name;
    @Positive(message = "price can not be null")
    @Column(columnDefinition = "decimal(10,2) not null")
    private double price;
    @Column(columnDefinition = "varchar(400) not null")
    private String description;
    @NotEmpty(message = " menu image can not be null")
    @Column(columnDefinition = "varchar(1000) not null")
    private  String menuImage;

    @ManyToOne
    @JsonIgnore
    private  Category category;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "menu")
    private Set<Favorite> favorites;

    @ManyToOne
    private Branch branch;
}
