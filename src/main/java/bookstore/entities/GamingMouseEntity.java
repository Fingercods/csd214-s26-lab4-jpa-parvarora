package bookstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
@DiscriminatorValue("GamingMouse")
public class GamingMouseEntity extends GamingAccessoryEntity {

    @Column(name = "dpi")
    private int dpi;

    public GamingMouseEntity() {
    }

    public GamingMouseEntity(String brand, double price, int dpi) {
        super(brand, price);
        this.dpi = dpi;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GamingMouseEntity that)) return false;
        return Objects.equals(getProductId(), that.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId());
    }

    @Override
    public String toString() {
        return "GamingMouseEntity{" +
                "id=" + getId() +
                ", productId='" + getProductId() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", price=" + getPrice() +
                ", dpi=" + dpi +
                '}';
    }
}