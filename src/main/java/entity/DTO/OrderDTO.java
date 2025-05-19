package entity.DTO;

import entity.Car;
import entity.Client;
import entity.Car_dealership_services;

import java.time.LocalDate;
import java.util.Set;

public class OrderDTO {
    private Long order_id;
    private int total_cost;
    private LocalDate general_time_required;
    private Set<Car> car_id;
    private Client client_id;
    private Set<Car_dealership_services> service_id;

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public int getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(int total_cost) {
        this.total_cost = total_cost;
    }

    public LocalDate getGeneral_time_required() {
        return general_time_required;
    }

    public void setGeneral_time_required(LocalDate general_time_required) {
        this.general_time_required = general_time_required;
    }

    public Set<Car> getCar_id() {
        return car_id;
    }

    public void setCar_id(Set<Car> car_id) {
        this.car_id = car_id;
    }

    public Client getClient_id() {
        return client_id;
    }

    public void setClient_id(Client client_id) {
        this.client_id = client_id;
    }

    public Set<Car_dealership_services> getService_id() {
        return service_id;
    }

    public void setService_id(Set<Car_dealership_services> service_id) {
        this.service_id = service_id;
    }
}
