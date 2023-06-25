package com.cellphones.dto;

public class OrderDTO extends AbstractDTO {


    private Integer status;
    private Float discount;

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
