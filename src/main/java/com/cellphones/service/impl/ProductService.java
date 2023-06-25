package com.cellphones.service.impl;

import com.cellphones.convert.ProductConverter;
import com.cellphones.dto.ProductDTO;
import com.cellphones.entity.BrandEntity;
import com.cellphones.entity.CategoryEntity;
import com.cellphones.entity.ProductEntity;
import com.cellphones.entity.WantityEntity;
import com.cellphones.repository.BrandRepository;
import com.cellphones.repository.CategoryRepository;
import com.cellphones.repository.ProductRepository;
import com.cellphones.repository.WantityRepository;
import com.cellphones.service.IProductService;
import com.cellphones.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService implements IProductService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private WantityRepository wantityRepository;

    private ProductConverter productConverter = new ProductConverter();
    @Autowired
    private ProductRepository productRepository;

    @Override
    public CategoryEntity findCategoryEntity(String code) {
        return categoryRepository.findOneByCategoryCode(code);
    }

    @Override
    public BrandEntity findBrandEntity(String code) {
        BrandEntity brandEntity =new BrandEntity();
        try{
             brandEntity = brandRepository.findOneByCodeBrand(code);
            return brandEntity;
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        return brandEntity;
    }

    @Override
    public ProductDTO findProductById(Long id) {
        ProductEntity product = productRepository.findOneById(id);
        return ProductConverter.toProductDTO(product);
    }

    @Override
    public WantityEntity findWantityEntity(Integer id) {
        WantityEntity wantityEntity = new WantityEntity();
        try{
            wantityEntity = wantityRepository.findOneByTimeWantity(id);
            return wantityEntity;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    return wantityEntity;
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();


        if (productDTO.getId() == null) {

            productEntity = ProductConverter.toProductEntity(productDTO);
        } else if (productDTO.getId() != null) {
            ProductDTO oldProduct = findOneById(productDTO.getId());
            ProductDTO newProduct = productDTO;
            newProduct = ProductConverter.toProductDTO(newProduct,oldProduct);
            productEntity = ProductConverter.toProductEntity(newProduct);

        }
        CategoryEntity category = findCategoryEntity(productDTO.getCategoryCodeDTO());
        productEntity.setCategory(category);
        productEntity.setBrand(findBrandEntity(productDTO.getBrandCodeDTO()));
        productEntity.setWantity(findWantityEntity(productDTO.getTimeWantityDTO()));
        return ProductConverter.toProductDTO(productRepository.save(productEntity));
    }

    @Override
    public List<ProductDTO> filterByPrice(Pageable page, double minPrice, double maxPrice) {
        List<ProductEntity> productEntityList = productRepository.findByPriceBetween(minPrice,maxPrice,page);
        ArrayList<ProductDTO> productDTOS = new ArrayList<>();
        for (ProductEntity product:productEntityList) {
            productDTOS.add(ProductConverter.toProductDTO(product));
        }
        return productDTOS;
    }
    public List<ProductDTO> filterProduct(Double minPrice, Double maxPrice, String color, Sort sort)
    {

        Specification<ProductEntity> specification = new ProductSpecification(minPrice,maxPrice,color);
        List<ProductEntity> productEntityList = productRepository.findAll(specification,sort);
        ArrayList<ProductDTO> productDTOS = new ArrayList<>();
        for (ProductEntity product:productEntityList) {
            productDTOS.add(ProductConverter.toProductDTO(product));
        }
        return productDTOS;

    }



    public ProductDTO findOneById(Long id) {
        ProductEntity product = productRepository.findOneById(id);
        return ProductConverter.toProductDTO(product);

    }

    @Override
    public List<ProductDTO> findAll(Pageable page) {
        List<ProductEntity> listEntities = productRepository.findAll(page).getContent();
        List<ProductDTO> listDto = new ArrayList<>();
        for (ProductEntity product : listEntities) {
            listDto.add(ProductConverter.toProductDTO(product));
        }
        return listDto;
    }

    @Override
    public long countPage() {
        return productRepository.count();
    }

    @Override
    public void Delete(List<Long> ids) {
        productRepository.deleteAllById(ids);
    }
}
