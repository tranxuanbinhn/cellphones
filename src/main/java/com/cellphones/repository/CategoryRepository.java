package com.cellphones.repository;

import com.cellphones.entity.CategoryEntity;
import com.cellphones.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    CategoryEntity findOneByCategoryCode(String code);
    CategoryEntity findOneById(long id);
}
