package bookstore.pojos;

import bookstore.entities.GamingKeyboardEntity;

import java.util.Scanner;

public class GamingKeyboard extends GamingAccessory {

    private String switchType;

    public GamingKeyboard() {
    }

    public GamingKeyboard(String brand, double price, String switchType) {
        super(brand, price);
        this.switchType = switchType;
    }

    public GamingKeyboardEntity toEntity() {
        GamingKeyboardEntity entity = new GamingKeyboardEntity();

        entity.setId(this.getDbId());
        entity.setProductId(this.getProductId());
        entity.setBrand(this.getBrand());
        entity.setPrice(this.getPrice());
        entity.setSwitchType(this.getSwitchType());

        return entity;
    }

    public static GamingKeyboard fromEntity(GamingKeyboardEntity entity) {
        GamingKeyboard keyboard = new GamingKeyboard(
                entity.getBrand(),
                entity.getPrice(),
                entity.getSwitchType()
        );

        keyboard.setDbId(entity.getId());
        keyboard.setProductId(entity.getProductId());

        return keyboard;
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);

        System.out.println("Enter Switch Type:");
        this.switchType = getInput(input, "Mechanical");
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);

        System.out.println("Edit Switch Type [" + switchType + "]:");
        this.switchType = getInput(input, switchType);
    }

    @Override
    public void sellItem() {
        System.out.println("Selling Gaming Keyboard: " + getBrand());
    }

    public String getSwitchType() {
        return switchType;
    }

    public void setSwitchType(String switchType) {
        this.switchType = switchType;
    }

    @Override
    public String toString() {
        return "GamingKeyboard{" +
                "switchType='" + switchType + '\'' +
                "} " + super.toString();
    }
}