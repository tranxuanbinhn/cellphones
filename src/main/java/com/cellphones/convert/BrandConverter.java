package com.cellphones.convert;

import com.cellphones.dto.BrandDTO;
import com.cellphones.entity.BrandEntity;

public class BrandConverter     {
    public static BrandDTO toBrandDTO(BrandEntity brandEntity) {
        BrandDTO  brandDTO = new BrandDTO();
        brandDTO.setNameBrand(brandEntity.getNameBrand());
        brandDTO.setCodeBrand(brandEntity.getCodeBrand());
        brandDTO.setId(brandEntity.getId());
        brandDTO.setCreateDate(brandEntity.getCreateDate());
        brandDTO.setCreateBy(brandEntity.getCreateBy());
        if(brandEntity.getModifiedBy()!=null)
        {
            brandDTO.setModifiedBy(brandEntity.getModifiedBy());
        }
        if(brandEntity.getModifiedDate()!=null)
        {
            brandDTO.setModifiedDate(brandEntity.getModifiedDate());
        }

        return brandDTO;
    }

    public static BrandDTO toBrandDTO(BrandDTO oldBrand, BrandDTO newBrand) {

        newBrand.setNameBrand(oldBrand.getNameBrand());
        newBrand.setCodeBrand(oldBrand.getCodeBrand());
        newBrand.setId(oldBrand.getId());
        newBrand.setCreateDate(oldBrand.getCreateDate());
        newBrand.setCreateBy(oldBrand.getCreateBy());
        if(oldBrand.getModifiedBy()!=null)
        {
            newBrand.setModifiedBy(oldBrand.getModifiedBy());
        }
        if(oldBrand.getModifiedDate()!=null)
        {
            newBrand.setModifiedDate(oldBrand.getModifiedDate());
        }

        return newBrand;

    }

    public static BrandEntity toBrandEntity(BrandDTO brandDTO) {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setNameBrand(brandDTO.getNameBrand());
        brandEntity.setCodeBrand(brandDTO.getCodeBrand());
        brandEntity.setId(brandDTO.getId());
        brandEntity.setCreateDate(brandDTO.getCreateDate());
        brandEntity.setCreateBy(brandDTO.getCreateBy());
        if(brandDTO.getModifiedBy()!=null)
        {
            brandEntity.setModifiedBy(brandDTO.getModifiedBy());
        }
        if(brandDTO.getModifiedDate()!=null)
        {
            brandEntity.setModifiedDate(brandDTO.getModifiedDate());
        }

        return brandEntity;
    }
}
