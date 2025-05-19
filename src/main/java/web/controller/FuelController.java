package web.controller;

import entity.Fuel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.FuelService;

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
}
