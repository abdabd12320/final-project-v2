package com.example.thawaq.Controller;

import com.example.thawaq.Api.ApiResponse;
import com.example.thawaq.DTO.AddressDTO;
import com.example.thawaq.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;


    @GetMapping("/get")
    public ResponseEntity getAddresses()
    {
        return ResponseEntity.status(200).body(addressService.getAddresses());
    }
    @PostMapping("/add/{storeAdminID}/{storeID}") //v2
    public ResponseEntity addAddress(@PathVariable Integer storeAdminID,@PathVariable Integer storeID,@Valid @RequestBody AddressDTO addressDTO)
    { //v2
        addressService.addAddress(storeAdminID,storeID,addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("address added"));
    }
    @PutMapping("/update/{storeAdminID}/{storeID}") //v2
    public ResponseEntity updateAddress(@PathVariable Integer storeAdminID,@PathVariable Integer storeID,@Valid@RequestBody AddressDTO addressDTO)
    { //v2
        addressService.updateAddress(storeAdminID,storeID,addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("address updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id)
    {
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("address deleted"));
    }
}
