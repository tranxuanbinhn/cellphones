package com.cellphones.service;

import com.cellphones.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface  IGenericService<T> {
    T save(T t);

    List<T> findAll(Pageable page);
    long countPage();
    void Delete(List<Long> ids);
}
