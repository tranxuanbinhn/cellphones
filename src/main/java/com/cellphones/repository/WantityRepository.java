package com.cellphones.repository;

import com.cellphones.entity.WantityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WantityRepository extends JpaRepository<WantityEntity,Long> {
    WantityEntity findOneByTimeWantity(Integer id);
    WantityEntity findOneById(Long id);
}
