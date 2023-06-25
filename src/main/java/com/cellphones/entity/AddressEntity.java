package com.cellphones.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "address")
@Entity
public class AddressEntity extends BaseEntity{

    @Column
    private int type;

    @Column
    private String province;

    @Column String district;

    @Column
    private String commune;

    @Column
    private String street;

    @OneToMany(mappedBy = "address")
    private List<OrderDetailEntity> orderDetails;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<OrderDetailEntity> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailEntity> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
