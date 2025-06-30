package com.example.posttracking.service;

import com.example.posttracking.model.Client;

import java.util.List;

public interface ClientService {
    Client save(Client client);
    List<Client> findAll();
}
