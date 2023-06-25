package com.cellphones.repository;

import com.cellphones.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findOneById(long id);
    Page<UserEntity> findAll(Pageable page);
    UserEntity findByUsername(String username);
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String numberphone);
}
