package com.cellphones.specification;

import org.springframework.data.jpa.domain.Specification;
import com.cellphones.entity.ProductEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecification implements Specification<ProductEntity> {
    private Double minPrice;
    private Double maxPrice;
    private String color;

    public ProductSpecification(Double minPrice, Double maxPrice, String color) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.color = color;
    }
    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (minPrice != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
        }

        if (maxPrice != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
        }

        if (color != null) {
            predicates.add(criteriaBuilder.equal(root.get("color"), color));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
