package web.controller;

import entity.Client;
import entity.DTO.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ClientService;

import java.util.List;

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

    @GetMapping("/{сlientId}")
    public ResponseEntity<ClientDTO> getProductById(@PathVariable Long clientId) {
        return clientService.findById(clientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllProducts() {
        List<ClientDTO> products = clientService.findAll();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{Clientid}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{Clientid}")
    public ResponseEntity<Client> updateOrder(@PathVariable Long id, @RequestBody Client client) {
        Client updatedProduct = clientService.update(id, client);
        return ResponseEntity.ok(updatedProduct);
    }
}
