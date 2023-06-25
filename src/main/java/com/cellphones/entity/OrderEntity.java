package com.cellphones.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity{

    @Column
    private Integer status;

    @Column
    private Float discount;

    @ManyToMany(mappedBy = "orders")
    private List<UserEntity> users;

    @OneToMany(mappedBy = "order")
    private List<OrderDetailEntity> orderDetail;

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }
}
