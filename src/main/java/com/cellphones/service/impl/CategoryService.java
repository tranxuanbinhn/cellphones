package com.cellphones.service.impl;

import com.cellphones.convert.CategoryConverter;
import com.cellphones.dto.CategoryDTO;
import com.cellphones.entity.CategoryEntity;
import com.cellphones.repository.CategoryRepository;
import com.cellphones.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = new CategoryEntity();
        if (categoryDTO.getId() == null) {

            categoryEntity = CategoryConverter.toCategoryEntity(categoryDTO);
        } else if (categoryDTO.getId() != null) {
            CategoryDTO oldCategory = CategoryConverter.toCategoryDTO(categoryRepository.findOneById(categoryDTO.getId()));
            CategoryDTO newCategory = new CategoryDTO();
            newCategory = CategoryConverter.toCategoryDTO(categoryDTO,oldCategory);
            categoryEntity = CategoryConverter.toCategoryEntity(newCategory);

        }
        return CategoryConverter.toCategoryDTO(categoryRepository.save(categoryEntity));
    }


    @Override
    public List<CategoryDTO> findAll(Pageable page)
    {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll(page).getContent();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (CategoryEntity category :categoryEntities) {

        categoryDTOS.add(CategoryConverter.toCategoryDTO(category));
        }
        return categoryDTOS;
    }

    @Override
    public long countPage() {
        return categoryRepository.count();
    }

    @Override
    public void Delete(List<Long> ids) {
        categoryRepository.deleteAllById(ids);
    }
}
