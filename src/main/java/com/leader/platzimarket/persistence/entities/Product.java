package com.leader.platzimarket.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "id_categoria")
    private Integer categoryId;

    @Column(name = "codigo_barras")
    private String qrCode;

    @Column(name = "precio_venta")
    private Double soldPrice;

    @Column(name = "cantidad_stock")
    private Integer stock;

    @Column(name = "estado")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_categoria",insertable = false,updatable = false)
    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(Double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
