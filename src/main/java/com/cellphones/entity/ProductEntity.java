package com.cellphones.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity{

    @Column(name = "name")
    private String productName;

    @Column(name = "numberstock")
    private Long numberStock;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "viewcount")
    private Long viewCount;

    @Column(name = "color")
    private String color;

    @Column(name = "size")
    private Float size;

    @Column
    private BigDecimal price;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToMany(mappedBy = "products")
    private List<CartEntity> carts;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brand;

    @ManyToOne
    @JoinColumn(name = "wantity_id")
    private WantityEntity wantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderdetail_id", referencedColumnName = "id")
    private OrderDetailEntity orderdetail;

    public List<CartEntity> getCarts() {
        return carts;
    }

    public void setCarts(List<CartEntity> carts) {
        this.carts = carts;
    }

    @OneToMany(mappedBy = "product")
    private List<ReviewEntity> review;

    public List<ReviewEntity> getReview() {
        return review;
    }

    public void setReview(List<ReviewEntity> review) {
        this.review = review;
    }

    public OrderDetailEntity getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(OrderDetailEntity orderdetail) {
        this.orderdetail = orderdetail;
    }





    public void setReview(ArrayList<ReviewEntity> review) {
        this.review = review;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }

    public WantityEntity getWantity() {
        return wantity;
    }

    public void setWantity(WantityEntity wantity) {
        this.wantity = wantity;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getNumberStock() {
        return numberStock;
    }

    public void setNumberStock(Long numberStock) {
        this.numberStock = numberStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
