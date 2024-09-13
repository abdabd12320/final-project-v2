package com.example.thawaq.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @MapsId
    @JsonIgnore
    private User user;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private Set<Favorite> favorites;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private Set<Rating> ratings;

}
