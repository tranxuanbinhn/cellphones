package com.cellphones.filtermodel;

public class FilterModel {
    private FilterPrice filterPrice;
    private String categoryName;

    public FilterPrice getFilterPrice() {
        return filterPrice;
    }

    public void setFilterPrice(FilterPrice filterPrice) {
        this.filterPrice = filterPrice;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public FilterModel(FilterPrice filterPrice) {
        this.filterPrice = filterPrice;
    }
}
