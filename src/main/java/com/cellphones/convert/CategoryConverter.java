package com.cellphones.convert;

import com.cellphones.dto.CategoryDTO;
import com.cellphones.dto.UserDTO;
import com.cellphones.entity.CategoryEntity;
import com.cellphones.entity.UserEntity;

public class CategoryConverter {
    public static CategoryDTO toCategoryDTO(CategoryEntity categoryEntity) {
        CategoryDTO  categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryCode(categoryEntity.getCategoryCode());
        categoryDTO.setCategoryName(categoryEntity.getCategoryName());
        categoryDTO.setId(categoryEntity.getId());
        categoryDTO.setCreateDate(categoryEntity.getCreateDate());
        categoryDTO.setCreateBy(categoryEntity.getCreateBy());
        if(categoryEntity.getModifiedBy()!=null)
        {
            categoryDTO.setModifiedBy(categoryEntity.getModifiedBy());
        }
        if(categoryEntity.getModifiedDate()!=null)
        {
            categoryDTO.setModifiedDate(categoryEntity.getModifiedDate());
        }

        return categoryDTO;
    }

    public static CategoryDTO toCategoryDTO(CategoryDTO oldCategory, CategoryDTO newCategory) {

        newCategory.setCategoryCode(oldCategory.getCategoryCode());
        newCategory.setCategoryName(oldCategory.getCategoryName());
        newCategory.setId(oldCategory.getId());
        newCategory.setCreateDate(oldCategory.getCreateDate());
        newCategory.setCreateBy(oldCategory.getCreateBy());
        if(oldCategory.getModifiedBy()!=null)
        {
            newCategory.setModifiedBy(oldCategory.getModifiedBy());
        }
        if(oldCategory.getModifiedDate()!=null)
        {
            newCategory.setModifiedDate(oldCategory.getModifiedDate());
        }

        return newCategory;

    }

    public static CategoryEntity toCategoryEntity(CategoryDTO categoryDTO) {
    CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryCode(categoryDTO.getCategoryCode());
        categoryEntity.setCategoryName(categoryDTO.getCategoryName());
        categoryEntity.setId(categoryDTO.getId());
        categoryEntity.setCreateDate(categoryDTO.getCreateDate());
        categoryEntity.setCreateBy(categoryDTO.getCreateBy());
        if(categoryDTO.getModifiedBy()!=null)
        {
            categoryEntity.setModifiedBy(categoryDTO.getModifiedBy());
        }
        if(categoryDTO.getModifiedDate()!=null)
        {
            categoryEntity.setModifiedDate(categoryDTO.getModifiedDate());
        }

        return categoryEntity;

    }
}
