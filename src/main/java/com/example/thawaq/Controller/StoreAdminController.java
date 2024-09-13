package com.example.thawaq.Controller;

import com.example.thawaq.Model.StoreAdmin;
import com.example.thawaq.Service.StoreAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store-admin")
public class StoreAdminController {
    private final StoreAdminService storeAdminService;

    @GetMapping("/get-all")
    public ResponseEntity getAll() {
        return ResponseEntity.status(200).body(storeAdminService.getAllStoreAdmins());
    }
    @GetMapping("/get-id/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(storeAdminService.getStoreAdminById(id));
    }
}
