package com.cellphones.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "wantity")
public class WantityEntity extends BaseEntity{
    private Integer timeWantity;
    private Integer wantity;

    @OneToMany(mappedBy = "wantity")
    private List<ProductEntity> product;

    public List<ProductEntity> getProduct() {
        return product;
    }

    public void setProduct(List<ProductEntity> product) {
        this.product = product;
    }

    public Integer getTimeWantity() {
        return timeWantity;
    }

    public void setTimeWantity(Integer timeWantity) {
        this.timeWantity = timeWantity;
    }

    public Integer getWantity() {
        return wantity;
    }

    public void setWantity(Integer wantity) {
        this.wantity = wantity;
    }
}
