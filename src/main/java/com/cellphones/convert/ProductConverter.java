package com.cellphones.convert;

import com.cellphones.dto.ProductDTO;
import com.cellphones.entity.ProductEntity;
import com.cellphones.service.IProductService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProductConverter {



    public static ProductDTO toProductDTO(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductName(productEntity.getProductName());
        productDTO.setNumberStock(productEntity.getNumberStock());
        productDTO.setDescription(productEntity.getDescription());
        productDTO.setImage(productEntity.getImage());
        productDTO.setViewCount(productEntity.getViewCount());
        productDTO.setColor(productEntity.getColor());
        productDTO.setPrice(productEntity.getPrice());
        productDTO.setCreateDate(productEntity.getCreateDate());
        productDTO.setId(productEntity.getId());
        productDTO.setCreateBy(productEntity.getCreateBy());
        productDTO.setCategoryCodeDTO(productEntity.getCategory().getCategoryCode());
        productDTO.setBrandCodeDTO(productEntity.getBrand().getCodeBrand());
        productDTO.setTimeWantityDTO(productEntity.getWantity().getTimeWantity());
        productDTO.setWantity(productEntity.getWantity().getWantity());

        if(productEntity.getModifiedBy()!= null)
        {
            productDTO.setModifiedBy(productEntity.getModifiedBy());
        }

        if (productEntity.getModifiedDate() != null) {
            productDTO.setModifiedDate(productEntity.getModifiedDate());

        }

        return productDTO;
    }

    public static ProductDTO toProductDTO(ProductDTO oldProduct, ProductDTO newProduct) {


        newProduct.setProductName(oldProduct.getProductName());
        newProduct.setNumberStock(oldProduct.getNumberStock());
        newProduct.setDescription(oldProduct.getDescription());
        newProduct.setImage(oldProduct.getImage());
        newProduct.setViewCount(oldProduct.getViewCount());
        newProduct.setColor(oldProduct.getColor());
        newProduct.setPrice(oldProduct.getPrice());
        newProduct.setId(oldProduct.getId());

        newProduct.setCategoryCodeDTO(oldProduct.getCategoryCodeDTO());
        newProduct.setBrandCodeDTO(oldProduct.getBrandCodeDTO());
        newProduct.setTimeWantityDTO(oldProduct.getTimeWantityDTO());
        newProduct.setWantity(oldProduct.getWantity());

        newProduct.setCreateBy(newProduct.getCreateBy());


        return newProduct;
    }

    public static ProductEntity toProductEntity(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName(productDTO.getProductName());
        productEntity.setNumberStock(productDTO.getNumberStock());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setImage(productDTO.getImage());
        productEntity.setViewCount(productDTO.getViewCount());
        productEntity.setColor(productDTO.getColor());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setId(productDTO.getId());
        productEntity.setCreateBy(productDTO.getCreateBy());
        productEntity.setCreateDate(productDTO.getCreateDate());

        if(productEntity.getModifiedBy()!= null)
        {
            productDTO.setModifiedBy(productEntity.getModifiedBy());
        }

        if (productEntity.getModifiedDate() != null) {
            productDTO.setModifiedDate(productEntity.getModifiedDate());

        }

        return productEntity;


    }
}
