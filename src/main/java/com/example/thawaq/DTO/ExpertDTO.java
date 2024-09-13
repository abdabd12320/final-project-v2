package com.example.thawaq.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExpertDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Username cannot be empty")
    @Size(min=4,max = 25, message = "Username must have between 4 to 35 characters")
    private String username;
    @NotEmpty(message = "Password cannot be empty")
    @Pattern(regexp = "^(?=.[A-Z])(?=.[a-z])(?=.\\d)(?=.[\\W_]).{8,}$",
            message = "Password must be strong (at least eight characters: one uppercase letter, one lowercase letter, one number, and one special character)")
    private String password;
    @NotEmpty
    @Pattern(regexp = "^(CLIENT|EXPERT|STORE|ADMIN)$")
    private String role;
    @NotEmpty(message = "First name cannot be empty")
    @Size(min = 2 , max = 15)
    private String firstName;
    @NotEmpty(message = "Last name cannot be empty")
    @Size(min = 2 , max = 15)
    private String lastName;
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    @Size(min = 2 , max = 35)
    private String email;
    @NotEmpty(message = "Phone Number cannot be empty")
    @Pattern(regexp = "^(05|0)[0-9]{10}$" , message = "Phone Number must be 10 numbers and start with 05")
    private String phoneNumber;
    private String country;
    private String city;
    @NotEmpty
    @Size(min = 1, max = 150)
    private String brief;
    @NotEmpty
    @Size(min = 1, max = 30)
    private String instagram;
    @NotEmpty
    @Size(min = 1, max = 30)
    private String x;
    private boolean isActive;
}
