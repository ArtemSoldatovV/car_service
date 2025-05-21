package web.controller;

import entity.Fuel;
import entity.DTO.FuelDTO;
import entity.Fuel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.FuelService;

import java.util.List;

@RestController
@RequestMapping("/")
public class FuelController {
    @Autowired
    private FuelService fuelService;

    @PostMapping
    public ResponseEntity<Fuel> createProduct(@RequestBody Fuel fuel) {
        Fuel newProduct = fuelService.save(fuel);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping("/{сlientId}")
    public ResponseEntity<FuelDTO> getProductById(@PathVariable Long fuelId) {
        return fuelService.findById(fuelId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<FuelDTO>> getAllProducts() {
        List<FuelDTO> products = fuelService.findAll();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{Fuelid}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        fuelService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{Fuelid}")
    public ResponseEntity<Fuel> updateOrder(@PathVariable Long id, @RequestBody Fuel fuel) {
        Fuel updatedProduct = fuelService.update(id, fuel);
        return ResponseEntity.ok(updatedProduct);
    }
}
