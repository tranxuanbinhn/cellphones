package com.cellphones.repository;

import com.cellphones.entity.CategoryEntity;
import com.cellphones.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cellphones.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long>, JpaSpecificationExecutor<ProductEntity> {
    ProductEntity findOneById(long id);
    List<ProductEntity> findByPriceBetween(double minPrice, double maxPrice, Pageable pageable);

}
