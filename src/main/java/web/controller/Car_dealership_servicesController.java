package web.controller;

import entity.Car_dealership_services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.Car_dealership_servicesService;

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
}
