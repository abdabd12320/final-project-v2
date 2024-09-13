package com.example.thawaq.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Service rating cannot be null")
    @Column(columnDefinition = "DOUBLE not null")
    private double service;


    @NotNull(message = "Cleaning rating cannot be null")
    @Column(columnDefinition = "DOUBLE not null")
    private double cleaning;


    @NotNull(message = "Quality rating cannot be null")
    @Column(columnDefinition = "DOUBLE not null")
    private double quality;


    @NotNull(message = "Cost rating cannot be null")
    @Column(columnDefinition = "DOUBLE not null")
    private double cost;


    @Size(min = 4, max = 500)
    @NotEmpty(message = "Comment cannot be empty")
    @Column(columnDefinition = "varchar(500)")
    private String comment;


    @Size(min = 4, max = 50)
    @NotEmpty(message = "Title cannot be empty")
    @Column(columnDefinition = "varchar(50)")
    private String title;

    @NotNull(message = "Average rating cannot be null")
    @Column(columnDefinition = "DOUBLE not null")
    private double averageRating;

    @ManyToOne
    @JsonIgnore
    private Client client;

    @ManyToOne
    @JsonIgnore
    private Expert expert;

    @ManyToOne
    @JsonIgnore
    private Store store;












}
