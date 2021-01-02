package ma.todart.entities;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//Data @AllArgsConstructor  @NoArgsConstructor @ToString @Getter @Setter
public class Product implements Serializable {
    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String descripton;
    private double currentPrice;
    private boolean promotion;
    private boolean selected;
    private boolean available;
    private String photoName;

    @ManyToOne
    private Category category;


    public Product() {
    }


    public Product(long id, String name, String descripton, double currentPrice, boolean promotion, boolean selected, boolean available, String photoName, Category category) {
        this.id = id;
        this.name = name;
        this.descripton = descripton;
        this.currentPrice = currentPrice;
        this.promotion = promotion;
        this.selected = selected;
        this.available = available;
        this.photoName = photoName;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}