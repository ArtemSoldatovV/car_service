package service;

import entity.DTO.OrderDTO;
import entity.Order;
import org.example.car_service.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MappingUtils mappingUtils;

    public Optional<OrderDTO> findById(Long id) {
        return orderRepository.findById(id)
                .map(mappingUtils::mapToOrderDTO);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public List<OrderDTO> findAll() {
        return orderRepository.findAll().stream()
                .map(mappingUtils::mapToOrderDTO)
                .collect(Collectors.toList());
    }

    public Order update(Long id, Order orderDetails) {
        Optional<Order> optionalProduct = orderRepository.findById(id);

        Order order = optionalProduct.get();
        order.setClient_id(orderDetails.getClient_id());
        order.setCar_id(orderDetails.getCar_id());
        order.setService_id(orderDetails.getService_id());
        order.setTotal_cost(orderDetails.getTotal_cost());
        order.setGeneral_time_required(orderDetails.getGeneral_time_required());
        return orderRepository.save(order);

    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
