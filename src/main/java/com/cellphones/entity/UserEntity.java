 package com.cellphones.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class
UserEntity extends BaseEntity{

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private Integer status;

    @Column
    private String email;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "fullname")
    private String fullName;

    @ManyToMany(mappedBy = "users")
    private List<ReviewEntity> reviews;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private CartEntity cart;

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_id")
            ,inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> roles;

    @ManyToMany
    @JoinTable(name = "user_order", joinColumns = @JoinColumn(name = "user_id")
            ,inverseJoinColumns = @JoinColumn(name="order_id"))

    private List<OrderEntity> orders;

    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewEntity> reviews) {
        this.reviews = reviews;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
