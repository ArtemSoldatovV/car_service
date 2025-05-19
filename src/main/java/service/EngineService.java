package service;

import entity.Engine;
import entity.DTO.EngineDTO;

import org.example.car_service.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EngineRepository;
import repository.EngineRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EngineService {

    @Autowired
    private EngineRepository engineRepository;
    @Autowired
    private MappingUtils mappingUtils;

    public Optional<EngineDTO> findById(Long id) {
        return engineRepository.findById(id)
                .map(mappingUtils::mapToEngineDTO);
    }

    public Engine save(Engine engine) {
        return engineRepository.save(engine);
    }

    public List<EngineDTO> findAll() {
        return engineRepository.findAll().stream()
                .map(mappingUtils::mapToEngineDTO)
                .collect(Collectors.toList());
    }

    public Engine update(Long id, Engine engineDetails) {
        Optional<Engine> optionalProduct = engineRepository.findById(id);

        Engine engine = optionalProduct.get();
        engine.setModel(engineDetails.getModel());
        engine.setPrice(engineDetails.getPrice());
        return engineRepository.save(engine);

    }

    public void delete(Long id) {
        engineRepository.deleteById(id);
    }
    
}
