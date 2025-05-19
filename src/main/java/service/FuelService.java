package service;

import entity.Fuel;
import entity.DTO.FuelDTO;
import org.example.car_service.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FuelRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuelService {
    @Autowired
    private FuelRepository fuelRepository;
    @Autowired
    private MappingUtils mappingUtils;

    public Optional<FuelDTO> findById(Long id) {
        return fuelRepository.findById(id)
                .map(mappingUtils::mapToFuelDTO);
    }

    public Fuel save(Fuel fuel) {
        return fuelRepository.save(fuel);
    }

    public List<FuelDTO> findAll() {
        return fuelRepository.findAll().stream()
                .map(mappingUtils::mapToFuelDTO)
                .collect(Collectors.toList());
    }

    public Fuel update(Long id, Fuel fuelDetails) {
        Optional<Fuel> optionalProduct = fuelRepository.findById(id);

        Fuel fuel = optionalProduct.get();
        fuel.setName(fuelDetails.getName());
        fuel.setPrice(fuelDetails.getPrice());
        return fuelRepository.save(fuel);

    }

    public void delete(Long id) {
        fuelRepository.deleteById(id);
    }
    
}
