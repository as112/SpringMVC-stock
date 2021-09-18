package com.example.stock.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY)      // одна категория - множество продуктов
    @JoinColumn(name = "category_id")       // название столбца в таблице product
    private Category category;

    private String description;
    private double price;
    private int balance;

    @OneToMany(mappedBy ="product", cascade = CascadeType.ALL)
    private List<Purshase> purshase = new ArrayList<>();

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Purshase> getPurshase() {
        return purshase;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setPurshase(List<Purshase> purshase) {
        this.purshase = purshase;
    }

    public Product() {
    }

    public Product(Category category, String description, double price, int balance) {
        this.category = category;
        this.description = description;
        this.price = price;
        this.balance = balance;
    }
}
