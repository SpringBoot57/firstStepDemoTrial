package com.example.posttracking.controller;

import com.example.posttracking.model.Client;
import com.example.posttracking.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.save(client));
    }

    @GetMapping
    public ResponseEntity<List<Client>> all() {
        return ResponseEntity.ok(clientService.findAll());
    }
}
