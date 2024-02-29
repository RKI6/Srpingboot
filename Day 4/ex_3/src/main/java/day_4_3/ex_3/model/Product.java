package day_4_3.ex_3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private int productld ;
    private String productName;
    private double price ;
    private String description ;
    private int quantity ;
    public Product(int productld, String productName, double price, String description, int quantity) {
        this.productld = productld;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }
    public Product() {
    }
    public int getProductld() {
        return productld;
    }
    public void setProductld(int productld) {
        this.productld = productld;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
