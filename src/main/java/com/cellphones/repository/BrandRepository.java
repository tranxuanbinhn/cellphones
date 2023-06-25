package com.cellphones.repository;

import com.cellphones.dto.BrandDTO;
import com.cellphones.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity,Long> {

    BrandEntity findOneByCodeBrand(String Code);
    BrandEntity findOneById(Long id);

}
