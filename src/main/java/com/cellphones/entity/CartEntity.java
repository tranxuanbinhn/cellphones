package com.cellphones.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cart")
public class CartEntity  extends  BaseEntity{
    @ManyToMany
    @JoinTable(name = "cart_Product", joinColumns = @JoinColumn(name = "cart_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductEntity> products;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
