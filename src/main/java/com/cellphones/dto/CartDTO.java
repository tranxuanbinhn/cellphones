package com.cellphones.dto;

import java.util.List;

public class CartDTO extends AbstractDTO{

    private List<ProductDTO> products;
    private UserDTO userDTO;

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
