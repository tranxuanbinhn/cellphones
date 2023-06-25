package com.cellphones.service;

import com.cellphones.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService extends IGenericService<UserDTO> {
    UserDTO save(UserDTO userDTO);

    UserDTO findUserById(Long id);

    List<UserDTO> findAll(Pageable page);

    long countPage();

    void Delete(List<Long> ids);

    boolean existsByUsername(String usename);

    boolean existsByNumberphone(String numberphone);

    boolean existsByEmail(String email);


}
