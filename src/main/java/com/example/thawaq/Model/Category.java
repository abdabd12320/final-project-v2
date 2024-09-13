package com.example.thawaq.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "category name can not be null")
    @Column(columnDefinition = "varchar(50) not null")
    private String name;
    @Column(columnDefinition = "varchar(400) not null")
    private String description;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    private Set<Menu> menus;
}
