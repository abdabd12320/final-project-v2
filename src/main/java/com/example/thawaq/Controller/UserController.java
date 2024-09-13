package com.example.thawaq.Controller;

import com.example.thawaq.Api.ApiResponse;
import com.example.thawaq.DTO.ClientDTO;
import com.example.thawaq.DTO.ExpertDTO;
import com.example.thawaq.DTO.StoreAdminDTO;
import com.example.thawaq.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/get-all")
    public ResponseEntity getAll() {
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @GetMapping("/get-id/{userId}")
    public ResponseEntity getUserById(@PathVariable Integer userId) {
        return ResponseEntity.status(200).body(userService.getUserById(userId));
    }

    @PostMapping("/register-client")
    public ResponseEntity registerClient(@RequestBody ClientDTO clientDTO) {
        userService.clientRegister(clientDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Client registered successfully"));
    }

    @PostMapping("/register-expert")
    public ResponseEntity registerExpert(@RequestBody ExpertDTO expertDTO) {
        userService.expertRegister(expertDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Expert registered successfully"));
    }

    @PostMapping("/register-store")
    public ResponseEntity registerAdmin(@RequestBody StoreAdminDTO storeAdminDTO) {
        userService.storeAdminRegister(storeAdminDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Store Admin registered successfully"));
    }

    @PutMapping("/update-client")
    public ResponseEntity updateClient(@RequestBody ClientDTO clientDTO) {
        userService.clientUpdate(clientDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Client updated successfully"));
    }

    @PutMapping("/update-expert")
    public ResponseEntity updateExpert(@RequestBody ExpertDTO expertDTO) {
        userService.expertUpdate(expertDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Expert updated successfully"));
    }

    @PutMapping("/update-store")
    public ResponseEntity updateAdmin(@RequestBody StoreAdminDTO storeAdminDTO) {
        userService.storeAdminUpdate(storeAdminDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Store Admin updated successfully"));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity delete(@PathVariable Integer userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted successfully"));
    }
}
