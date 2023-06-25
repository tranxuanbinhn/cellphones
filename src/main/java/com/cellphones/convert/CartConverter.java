package com.cellphones.convert;

import com.cellphones.dto.CartDTO;
import com.cellphones.dto.ProductDTO;
import com.cellphones.dto.WantityDTO;
import com.cellphones.entity.CartEntity;
import com.cellphones.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public class CartConverter {
    public static CartDTO toCartDTO(CartEntity cart) {
        CartDTO cartDTO = new CartDTO();
        /*Set list product*/

        cartDTO.setId(cart.getId());
        List<ProductEntity> listProductEntity =cart.getProducts();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (ProductEntity productEntity:listProductEntity) {
            productDTOList.add(ProductConverter.toProductDTO(productEntity));
        }
        cartDTO.setProducts(productDTOList);

        /*Set User entity*/

        cartDTO.setUserDTO(UserConverter.toUserDTO(cart.getUser()));

        cartDTO.setCreateDate(cart.getCreateDate());
        cartDTO.setCreateBy(cart.getCreateBy());
        if(cart.getModifiedBy()!=null)
        {
            cartDTO.setModifiedBy(cart.getModifiedBy());
        }
        if(cart.getModifiedDate()!=null)
        {
            cartDTO.setModifiedDate(cart.getModifiedDate());
        }

        return cartDTO;
    }

    public static CartDTO toCartDTO(CartDTO oldcart, CartDTO newcart) {

        newcart.setId(oldcart.getId());
        newcart.setCreateBy(oldcart.getCreateBy());
        newcart.setCreateDate(oldcart.getCreateDate());

        if(oldcart.getModifiedBy()!= null)
        {
            newcart.setModifiedBy(oldcart.getModifiedBy());
        }
        if(oldcart.getModifiedDate()!= null)
        {
            newcart.setModifiedDate(oldcart.getModifiedDate());
        }
        return newcart;
           }

    public static CartEntity toCartEntity(CartDTO cartDTO) {
        CartEntity cartEntity = new CartEntity();
        cartEntity.setId(cartDTO.getId());
        cartEntity.setCreateBy(cartDTO.getCreateBy());
        cartEntity.setCreateDate(cartDTO.getCreateDate());

        if(cartDTO.getModifiedBy()!= null)
        {
            cartEntity.setModifiedBy(cartDTO.getModifiedBy());
        }
        if(cartDTO.getModifiedDate()!= null)
        {
            cartEntity.setModifiedDate(cartDTO.getModifiedDate());
        }
        return cartEntity;
    }
}
