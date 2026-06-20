package bookstore.pojos;

import java.util.Scanner;

public abstract class GamingAccessory extends Product {
    private String brand;
    private double price;

    public GamingAccessory() {
    }

    public GamingAccessory(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void initialize(Scanner input) {
        System.out.println("Enter Brand:");
        this.brand = getInput(input, "Unknown Brand");

        System.out.println("Enter Price:");
        this.price = getInput(input, 0.0);
    }

    @Override
    public void edit(Scanner input) {
        System.out.println("Edit Brand [" + brand + "]:");
        this.brand = getInput(input, brand);

        System.out.println("Edit Price [" + price + "]:");
        this.price = getInput(input, price);
    }

    @Override
    public String toString() {
        return "GamingAccessory{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                "} " + super.toString();
    }
}