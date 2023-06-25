package com.cellphones.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brand")
public class BrandEntity extends BaseEntity{
    @Column(name = "namebrand")
    private String nameBrand;

    @Column(name = "code")
    private String codeBrand;

    @OneToMany(mappedBy = "brand")
    private List<ProductEntity> product;

    public List<ProductEntity> getProduct() {
        return product;
    }

    public void setProduct(List<ProductEntity> product) {
        this.product = product;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public String getCodeBrand() {
        return codeBrand;
    }

    public void setCodeBrand(String codeBrand) {
        this.codeBrand = codeBrand;
    }
}
