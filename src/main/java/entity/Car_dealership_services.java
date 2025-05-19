package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Service")
public class Car_dealership_services {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Service_id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;
    @Column(name = "data_day")
    private LocalDate data_day;

    public Long getService_id() {
        return Service_id;
    }

    public void setService_id(Long id) {
        this.Service_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getData_day() {
        return data_day;
    }

    public void setData_day(LocalDate data_day) {
        this.data_day = data_day;
    }
}