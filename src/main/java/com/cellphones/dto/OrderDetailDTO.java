package com.cellphones.dto;

import java.math.BigDecimal;


public class OrderDetailDTO extends AbstractDTO {


    private BigDecimal unitPrice;
    private Integer quantity;

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
