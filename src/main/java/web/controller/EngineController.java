package web.controller;

import entity.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.EngineService;

@RestController
@RequestMapping("/")
public class EngineController {
    @Autowired
    private EngineService engineService;

    @PostMapping
    public ResponseEntity<Engine> createProduct(@RequestBody Engine engine) {
        Engine newProduct = engineService.save(engine);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }
}
