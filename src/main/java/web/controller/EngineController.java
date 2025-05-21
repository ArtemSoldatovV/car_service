package web.controller;

import entity.Engine;
import entity.DTO.EngineDTO;
import entity.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.EngineService;

import java.util.List;

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

    @GetMapping("/{сlientId}")
    public ResponseEntity<EngineDTO> getProductById(@PathVariable Long engineId) {
        return engineService.findById(engineId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EngineDTO>> getAllProducts() {
        List<EngineDTO> products = engineService.findAll();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{Engineid}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        engineService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{Engineid}")
    public ResponseEntity<Engine> updateOrder(@PathVariable Long id, @RequestBody Engine engine) {
        Engine updatedProduct = engineService.update(id, engine);
        return ResponseEntity.ok(updatedProduct);
    }
}
