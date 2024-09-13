package com.example.thawaq.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

public class Request {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Description cannot be empty")
    @Size(min= 30, max = 600)
    @Column(columnDefinition = "varchar(500) not null")
    private String description;

    @Enumerated(EnumType.STRING)
    private Request.Status status= Request.Status.PENDING;
    public enum Status{
        APPROVED,
        PENDING,
        Waiting,
        Done,
        REJECTED}

    @NotNull(message = "Price cannot be null")
    @Column(columnDefinition = "DOUBLE not null")
    private double price;

    @CreationTimestamp
    @Column(updatable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime requestDate;

    @CreationTimestamp
    @Column(updatable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(columnDefinition = "timestamp not null default current_timestamp on update current_timestamp")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JsonIgnore
    private Expert expert;
    @ManyToOne
    @JsonIgnore
    private Store store;














}
