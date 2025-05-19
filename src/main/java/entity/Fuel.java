package entity;

import jakarta.persistence.*;

//топливо
@Entity
@Table(name="Fuel")
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fuel_id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;

    public Long getFuel_id() {
        return fuel_id;
    }

    public void setFuel_id(Long fuel_id) {
        this.fuel_id = fuel_id;
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
}
