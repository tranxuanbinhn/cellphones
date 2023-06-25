package com.cellphones.repository;

import com.cellphones.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    RoleEntity findRoleEntityByName(String name);
}
