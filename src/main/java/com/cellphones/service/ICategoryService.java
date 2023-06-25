package com.cellphones.service;

import com.cellphones.dto.CategoryDTO;
import com.cellphones.entity.CategoryEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService extends IGenericService<CategoryDTO> {
    @Override
    CategoryDTO save(CategoryDTO categoryDTO);


    @Override
    List<CategoryDTO> findAll(Pageable page);
    @Override
     long countPage();

    @Override
    void Delete(List<Long> ids);
}
