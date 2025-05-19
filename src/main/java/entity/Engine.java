package entity;

import jakarta.persistence.*;

//Двигатель
@Entity
@Table(name="Engine")
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long engine_id;
    @Column(name = "model")
    private String model;
    @Column(name = "price")
    private int price;

    public Long getEngine_id() {
        return engine_id;
    }

    public void setEngine_id(Long id) {
        this.engine_id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
