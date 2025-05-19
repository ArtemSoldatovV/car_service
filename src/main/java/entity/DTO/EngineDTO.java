package entity.DTO;

public class EngineDTO {
    private Long engine_id;
    private String model;
    private int price;

    public Long getEngine_id() {
        return engine_id;
    }

    public void setEngine_id(Long engine_id) {
        this.engine_id = engine_id;
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
