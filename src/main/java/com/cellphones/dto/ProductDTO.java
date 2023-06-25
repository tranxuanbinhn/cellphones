package com.cellphones.dto;

import java.math.BigDecimal;
import java.util.List;

public class ProductDTO extends AbstractDTO {

    private String productName;
    private Long numberStock;
    private String description;
    private String image;
    private Long viewCount;
    private String color;
    private Float size;
    private BigDecimal price;
    private String categoryCodeDTO;
    private String brandCodeDTO;
    private int timeWantityDTO;
    private int wantity;

    public int getWantity() {
        return wantity;
    }

    public void setWantity(int wantity) {
        this.wantity = wantity;
    }

    public int getTimeWantityDTO() {
        return timeWantityDTO;
    }

    public void setTimeWantityDTO(int timeWantityDTO) {
        this.timeWantityDTO = timeWantityDTO;
    }

    private List<ReviewDTO> reviewDTOS;

    public String getCategoryCodeDTO() {
        return categoryCodeDTO;
    }

    public void setCategoryCodeDTO(String categoryCodeDTO) {
        this.categoryCodeDTO = categoryCodeDTO;
    }

    public String getBrandCodeDTO() {
        return brandCodeDTO;
    }

    public void setBrandCodeDTO(String brandCodeDTO) {
        this.brandCodeDTO = brandCodeDTO;
    }

    public List<ReviewDTO> getReviewDTOS() {
        return reviewDTOS;
    }

    public void setReviewDTOS(List<ReviewDTO> reviewDTOS) {
        this.reviewDTOS = reviewDTOS;
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
