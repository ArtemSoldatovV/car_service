package web.controller;

import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ClientService;

@RestController
@RequestMapping("/")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> createProduct(@RequestBody Client client) {
        Client newProduct = clientService.save(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }
}
