package com.example.thawaq.DTO;

import jakarta.persistence.Column;
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
public class AddressDTO {

    private Integer branch_id;

    @NotEmpty(message = "city should not be empty")
    @Size(max = 25,message = "city should be less than 26")
    private String city;
    @NotEmpty(message = "street should not be empty")
    @Size(max = 50,message = "street should be less than 51")
    private String street;
}
