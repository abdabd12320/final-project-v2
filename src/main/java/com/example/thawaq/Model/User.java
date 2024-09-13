package com.example.thawaq.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Username cannot be empty")
    @Size(min=4,max = 25, message = "Username must have between 4 to 35 characters")
    @Column(columnDefinition = "VARCHAR(35) NOT NULL UNIQUE")
    private String username;
    @NotEmpty(message = "Password cannot be empty")
//    @Pattern(regexp = "^(?=.[A-Z])(?=.[a-z])(?=.\\d)(?=.[\\W_]).{8,}$",
//            message = "Password must be strong (at least eight characters: one uppercase letter, one lowercase letter, one number, and one special character)")
    @Column(columnDefinition = "VARCHAR(35) NOT NULL")
    private String password;
    @NotEmpty
    @Pattern(regexp = "^(CLIENT|EXPERT|STORE|ADMIN)$")
    @Column(columnDefinition = "varchar(15) not null")
    private String role;
    @NotEmpty(message = "First name cannot be empty")
    @Column(columnDefinition = "VARCHAR(15) NOT NULL")
    @Size(min = 2 , max = 15)
    private String firstName;
    @NotEmpty(message = "Last name cannot be empty")
    @Column(columnDefinition = "VARCHAR(15) NOT NULL")
    @Size(min = 2 , max = 15)
    private String lastName;
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    @Column(columnDefinition = "VARCHAR(35) NOT NULL UNIQUE")
    @Size(min = 2 , max = 35)
    private String email;
    @NotEmpty(message = "Phone Number cannot be empty")
    @Column(columnDefinition = "VARCHAR(10) NOT NULL UNIQUE")
    @Pattern(regexp = "^(05)(\\d){8}$" , message = "Phone Number must be 10 numbers and start with 05")
    private String phoneNumber;
    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String country;
    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String city;
    @OneToOne(cascade = CascadeType.ALL , mappedBy = "user")
    @PrimaryKeyJoinColumn
    private Client client;
    @OneToOne(cascade = CascadeType.ALL , mappedBy = "user")
    @PrimaryKeyJoinColumn
    private StoreAdmin StoreAdmin;
    @OneToOne(cascade = CascadeType.ALL , mappedBy = "user")
    @PrimaryKeyJoinColumn
    private Expert expert;
}
