package com.leader.platzimarket.domain;

public class DomainProduct {
    private int id;
    private  String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean isActive;
    private DomainCategory category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public DomainCategory getCategory() {
        return category;
    }

    public void setCategory(DomainCategory category) {
        this.category = category;
    }
}
