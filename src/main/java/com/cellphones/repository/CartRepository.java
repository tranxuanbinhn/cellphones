package com.cellphones.repository;

import com.cellphones.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity,Long > {

    CartEntity findCartEntitiesByUserId(Long id);

}
