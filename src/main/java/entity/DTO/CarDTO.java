package entity.DTO;

import entity.Engine;
import entity.Fuel;

public class CarDTO {
    private Long number_car;
    private Engine engine;
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
