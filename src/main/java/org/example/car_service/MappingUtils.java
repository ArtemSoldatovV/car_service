package org.example.car_service;

import entity.*;
import entity.DTO.*;

public class MappingUtils {
    public CarDTO mapToCarDTO(Car car){
        CarDTO carDTO = new CarDTO();
        carDTO.setNumber_car(car.getNumber_car());
        carDTO.setEngine(car.getEngine());
        carDTO.setFuel(car.getFuel());
        return carDTO;
    }
    public Car mapToCar(CarDTO carDTO){
        Car car = new Car();
        car.setNumber_car(carDTO.getNumber_car());
        car.setEngine(carDTO.getEngine());
        car.setFuel(carDTO.getFuel());
        return car;
    }

    public ClientDTO mapToClientDTO(Client client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setClient_id(client.getClient_id());
        clientDTO.setName(client.getName());
        clientDTO.setPatronymic(client.getPatronymic());
        clientDTO.setSurname(client.getSurname());
        return clientDTO;
    }
    public Client mapToClient(ClientDTO clientDTO){
        Client client = new Client();
        client.setClient_id(clientDTO.getClient_id());
        client.setName(clientDTO.getName());
        client.setPatronymic(clientDTO.getPatronymic());
        client.setSurname(clientDTO.getSurname());
        return client;
    }

    public EngineDTO mapToEngineDTO(Engine engine){
        EngineDTO engineDTO = new EngineDTO();
        engineDTO.setEngine_id(engine.getEngine_id());
        engineDTO.setModel(engine.getModel());
        engineDTO.setPrice(engine.getPrice());
        return engineDTO;
    }
    public Engine mapToEngine(EngineDTO engineDTO){
        Engine engine = new Engine();
        engine.setEngine_id(engineDTO.getEngine_id());
        engine.setModel(engineDTO.getModel());
        engine.setPrice(engineDTO.getPrice());
        return engine;
    }

    public FuelDTO mapToFuelDTO(Fuel fuel){
        FuelDTO fuelDTO = new FuelDTO();
        fuelDTO.setFuel_id(fuel.getFuel_id());
        fuelDTO.setName(fuel.getName());
        fuelDTO.setPrice(fuel.getPrice());
        return fuelDTO;
    }
    public Fuel mapToFuel(FuelDTO fuelDTO){
        Fuel fuel = new Fuel();
        fuel.setFuel_id(fuelDTO.getFuel_id());
        fuel.setName(fuelDTO.getName());
        fuel.setPrice(fuelDTO.getPrice());
        return fuel;
    }

    public OrderDTO mapToOrderDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrder_id(order.getOrder_id());
        orderDTO.setClient_id(order.getClient_id());
        orderDTO.setCar_id(order.getCar_id());
        orderDTO.setService_id(order.getService_id());
        orderDTO.setTotal_cost(order.getTotal_cost());
        orderDTO.setGeneral_time_required(order.getGeneral_time_required());
        return orderDTO;
    }
    public Order mapToOrder(OrderDTO orderDTO){
        Order order = new Order();
        order.setOrder_id(orderDTO.getOrder_id());
        order.setClient_id(orderDTO.getClient_id());
        order.setCar_id(orderDTO.getCar_id());
        order.setService_id(orderDTO.getService_id());
        order.setTotal_cost(orderDTO.getTotal_cost());
        order.setGeneral_time_required(orderDTO.getGeneral_time_required());
        return order;
    }

    public Car_dealership_servicesDTO mapToServiceDTO(Car_dealership_services service){
        Car_dealership_servicesDTO serviceDTO = new Car_dealership_servicesDTO();
        serviceDTO.setName(service.getName());
        serviceDTO.setService_id(service.getService_id());
        serviceDTO.setPrice(service.getPrice());
        serviceDTO.setData_day(service.getData_day());
        return serviceDTO;
    }
    public Car_dealership_services mapToService(Car_dealership_servicesDTO serviceDTO){
        Car_dealership_services service = new Car_dealership_services();
        service.setName(serviceDTO.getName());
        service.setService_id(serviceDTO.getService_id());
        service.setPrice(serviceDTO.getPrice());
        service.setData_day(serviceDTO.getData_day());
        return service;
    }
}
