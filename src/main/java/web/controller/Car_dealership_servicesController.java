package web.controller;

import entity.Car_dealership_services;
import entity.DTO.Car_dealership_servicesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.Car_dealership_servicesService;

import java.util.List;

@RestController
@RequestMapping("/")
public class Car_dealership_servicesController {
    @Autowired
    private Car_dealership_servicesService carDealershipServicesService;

    @PostMapping
    public ResponseEntity<Car_dealership_services> createProduct(@RequestBody Car_dealership_services car_dealership_services) {
        Car_dealership_services newProduct = carDealershipServicesService.save(car_dealership_services);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping("/{car_dealership_servicesId}")
    public ResponseEntity<Car_dealership_servicesDTO> getProductById(@PathVariable Long car_dealership_servicesId) {
        return carDealershipServicesService.findById(car_dealership_servicesId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Car_dealership_servicesDTO>> getAllProducts() {
        List<Car_dealership_servicesDTO> products = carDealershipServicesService.findAll();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{Car_dealership_servicesid}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        carDealershipServicesService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{Car_dealership_servicesid}")
    public ResponseEntity<Car_dealership_services> updateOrder(@PathVariable Long id, @RequestBody Car_dealership_services car_dealership_services) {
        Car_dealership_services updatedProduct = carDealershipServicesService.update(id, car_dealership_services);
        return ResponseEntity.ok(updatedProduct);
    }
}
