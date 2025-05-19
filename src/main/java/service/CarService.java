package service;

import entity.Car;
import entity.DTO.CarDTO;
import org.example.car_service.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private MappingUtils mappingUtils;

    public Optional<CarDTO> findById(Long id) {
        return carRepository.findById(id)
                .map(mappingUtils::mapToCarDTO);
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public List<CarDTO> findAll() {
        return carRepository.findAll().stream()
                .map(mappingUtils::mapToCarDTO)
                .collect(Collectors.toList());
    }

    public Car update(Long id, Car carDetails) {
        Optional<Car> optionalProduct = carRepository.findById(id);

        Car car = optionalProduct.get();
        car.setEngine(carDetails.getEngine());
        car.setFuel(carDetails.getFuel());
        return carRepository.save(car);

    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}
