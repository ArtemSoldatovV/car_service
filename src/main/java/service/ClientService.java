package service;

import entity.Car;
import entity.Client;
import entity.DTO.CarDTO;
import entity.DTO.ClientDTO;
import org.example.car_service.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private MappingUtils mappingUtils;

    public Optional<ClientDTO> findById(Long id) {
        return clientRepository.findById(id)
                .map(mappingUtils::mapToClientDTO);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public List<ClientDTO> findAll() {
        return clientRepository.findAll().stream()
                .map(mappingUtils::mapToClientDTO)
                .collect(Collectors.toList());
    }

    public Client update(Long id, Client clientDetails) {
        Optional<Client> optionalProduct = clientRepository.findById(id);

        Client client = optionalProduct.get();
        client.setName(clientDetails.getName());
        client.setPatronymic(clientDetails.getPatronymic());
        client.setSurname(clientDetails.getSurname());
        return clientRepository.save(client);

    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

}
