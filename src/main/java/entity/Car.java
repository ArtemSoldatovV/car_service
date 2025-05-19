package entity;

//@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//@ManyToOne
//@JoinColumn(name = "customer_id", nullable = false)
//@ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "order_product",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id"))
//@Column(name = "creation_date", nullable = false)

import jakarta.persistence.*;

@Entity
@Table(name="Car")
public class Car {
    @Id
    private Long number_car;
    @ManyToOne
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @ManyToOne
    @JoinColumn(name = "fuel_id")
    private Fuel fuel;

    public Long getNumber_car() {
        return number_car;
    }

    public void setNumber_car(Long number_car) {
        this.number_car = number_car;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }
}
