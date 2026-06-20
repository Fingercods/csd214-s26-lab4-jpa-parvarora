package bookstore.pojos;

import bookstore.entities.GamingMouseEntity;

import java.util.Scanner;

public class GamingMouse extends GamingAccessory {

    private int dpi;

    public GamingMouse() {
    }

    public GamingMouse(String brand, double price, int dpi) {
        super(brand, price);
        this.dpi = dpi;
    }

    public GamingMouseEntity toEntity() {
        GamingMouseEntity entity = new GamingMouseEntity();

        entity.setId(this.getDbId());
        entity.setProductId(this.getProductId());
        entity.setBrand(this.getBrand());
        entity.setPrice(this.getPrice());
        entity.setDpi(this.getDpi());

        return entity;
    }

    public static GamingMouse fromEntity(GamingMouseEntity entity) {
        GamingMouse mouse = new GamingMouse(
                entity.getBrand(),
                entity.getPrice(),
                entity.getDpi()
        );

        mouse.setDbId(entity.getId());
        mouse.setProductId(entity.getProductId());

        return mouse;
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);

        System.out.println("Enter DPI:");
        this.dpi = getInput(input, 0);
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);

        System.out.println("Edit DPI [" + dpi + "]:");
        this.dpi = getInput(input, dpi);
    }

    @Override
    public void sellItem() {
        System.out.println("Selling Gaming Mouse: " + getBrand());
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    @Override
    public String toString() {
        return "GamingMouse{" +
                "dpi=" + dpi +
                "} " + super.toString();
    }
}