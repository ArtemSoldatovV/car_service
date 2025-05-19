package entity.DTO;

public class FuelDTO {
    private Long fuel_id;
    private String name;
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
