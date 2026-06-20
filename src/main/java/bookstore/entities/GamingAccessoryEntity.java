package bookstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public abstract class GamingAccessoryEntity extends ProductEntity {

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private double price;

    public GamingAccessoryEntity() {
    }

    public GamingAccessoryEntity(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}