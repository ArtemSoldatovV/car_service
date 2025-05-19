package service;

import entity.Car_dealership_services;
import entity.DTO.Car_dealership_servicesDTO;

import org.example.car_service.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.Car_dealership_servicesRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Car_dealership_servicesService {
    @Autowired
    private Car_dealership_servicesRepository serviceRepository;
    @Autowired
    private MappingUtils mappingUtils;

    public Optional<Car_dealership_servicesDTO> findById(Long id) {
        return serviceRepository.findById(id)
                .map(mappingUtils::mapToServiceDTO);
    }

    public Car_dealership_services save(Car_dealership_services service) {
        return serviceRepository.save(service);
    }

    public List<Car_dealership_servicesDTO> findAll() {
        return serviceRepository.findAll().stream()
                .map(mappingUtils::mapToServiceDTO)
                .collect(Collectors.toList());
    }

    public Car_dealership_services update(Long id, Car_dealership_services serviceDetails) {
        Optional<Car_dealership_services> optionalProduct = serviceRepository.findById(id);

        Car_dealership_services service = optionalProduct.get();
        service.setService_id(serviceDetails.getService_id());
        service.setPrice(serviceDetails.getPrice());
        service.setData_day(serviceDetails.getData_day());
        return serviceRepository.save(service);

    }

    public void delete(Long id) {
        serviceRepository.deleteById(id);
    }
}
