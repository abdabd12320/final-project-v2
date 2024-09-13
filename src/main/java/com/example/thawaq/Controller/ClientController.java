package com.example.thawaq.Controller;

import com.example.thawaq.Service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/client")
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/get-all")
    public ResponseEntity getAllClients() {
        return ResponseEntity.status(200).body(clientService.getAllClients());
    }

    @GetMapping("/get-id/{clientId}")
    public ResponseEntity getClientById(@PathVariable Integer clientId) {
        return ResponseEntity.status(200).body(clientService.getClientById(clientId));
    }


}
