package com.cellphones.service;

import com.cellphones.dto.ProductDTO;
import com.cellphones.entity.BrandEntity;
import com.cellphones.entity.CategoryEntity;
import com.cellphones.entity.WantityEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IProductService extends IGenericService<ProductDTO>{
    CategoryEntity findCategoryEntity(String code);
    BrandEntity findBrandEntity(String code);
    WantityEntity findWantityEntity(Integer id);

    @Override
    ProductDTO save(ProductDTO productDTO);
    List<ProductDTO> filterProduct(Double minPrice, Double maxPrice, String color, Sort sort);
    List<ProductDTO> filterByPrice(Pageable page, double minPrice, double maxPrice);
    @Override
    List<ProductDTO> findAll(Pageable page);
    ProductDTO findProductById(Long id);
    @Override
    long countPage();

    @Override
    void Delete(List<Long> ids);
}
