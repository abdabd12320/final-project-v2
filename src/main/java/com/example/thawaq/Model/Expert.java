package com.example.thawaq.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
public class Expert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "VARCHAR(150) NOT NULL")
    @Size(min = 1, max = 150)
    private String brief;
    @NotEmpty
    @Column(columnDefinition = "VARCHAR(30) NOT NULL UNIQUE")
    @Size(min = 1, max = 30)
    private String instagram;
    @NotEmpty
    @Column(columnDefinition = "VARCHAR(30) NOT NULL UNIQUE")
    @Size(min = 1, max = 30)
    private String x;
    private boolean isActive;
    @OneToOne
    @MapsId
    @JsonIgnore
    private User user;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "expert")
    private Set<Rating> ratings;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "expert")
    private Set<Request> requests;

}
