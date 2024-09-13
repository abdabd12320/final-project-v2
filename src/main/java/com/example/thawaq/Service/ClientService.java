package com.example.thawaq.Service;

import com.example.thawaq.Model.Client;
import com.example.thawaq.Repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    public Client getClientById(Integer id) {
        return clientRepository.findClientById(id);
    }
}
