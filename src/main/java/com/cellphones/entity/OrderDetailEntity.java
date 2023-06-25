package com.cellphones.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orderdetail")
public class OrderDetailEntity extends BaseEntity{

    @Column(name = "unitprice")
    private BigDecimal unitPrice;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "customer")
    private String customer;

    @Column(name = "phonenumber")
    private String phoneNumber;


    @Column(name = "email")
    private String email;

    @Column(name = "methodpayment")
    private String methodPayment;

    @OneToOne(mappedBy = "orderdetail")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "id_address")
    private AddressEntity address;

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getMethodPayment() {
        return methodPayment;
    }

    public void setMethodPayment(String methodPayment) {
        this.methodPayment = methodPayment;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
