package web.controller;

import entity.Car;
import entity.DTO.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CarService;

import java.util.List;

@RestController
@RequestMapping("/")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<Car> createProduct(@RequestBody Car car) {
        Car newProduct = carService.save(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping("/{carId}")
    public ResponseEntity<CarDTO> getProductById(@PathVariable Long carId) {
        return carService.findById(carId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllProducts() {
        List<CarDTO> products = carService.findAll();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{Carid}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{Carid}")
    public ResponseEntity<Car> updateOrder(@PathVariable Long id, @RequestBody Car car) {
        Car updatedProduct = carService.update(id, car);
        return ResponseEntity.ok(updatedProduct);
    }
}
