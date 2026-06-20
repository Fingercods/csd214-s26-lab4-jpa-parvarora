package bookstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
@DiscriminatorValue("GamingKeyboard")
public class GamingKeyboardEntity extends GamingAccessoryEntity {

    @Column(name = "switch_type")
    private String switchType;

    public GamingKeyboardEntity() {
    }

    public GamingKeyboardEntity(String brand, double price, String switchType) {
        super(brand, price);
        this.switchType = switchType;
    }

    public String getSwitchType() {
        return switchType;
    }

    public void setSwitchType(String switchType) {
        this.switchType = switchType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GamingKeyboardEntity that)) return false;
        return Objects.equals(getProductId(), that.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId());
    }

    @Override
    public String toString() {
        return "GamingKeyboardEntity{" +
                "id=" + getId() +
                ", productId='" + getProductId() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", price=" + getPrice() +
                ", switchType='" + switchType + '\'' +
                '}';
    }
}