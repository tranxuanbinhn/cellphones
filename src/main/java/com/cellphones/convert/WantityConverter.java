package com.cellphones.convert;

import com.cellphones.dto.BrandDTO;
import com.cellphones.dto.WantityDTO;
import com.cellphones.entity.BrandEntity;
import com.cellphones.entity.WantityEntity;

public class WantityConverter {
    public static WantityDTO toWantityDTO(WantityEntity wantityEntity) {
        WantityDTO wantityDTO = new WantityDTO();
        wantityDTO.setTimeWantity(wantityEntity.getTimeWantity());
        wantityDTO.setWantity(wantityDTO.getWantity());
        wantityDTO.setId(wantityEntity.getId());
        wantityDTO.setCreateDate(wantityEntity.getCreateDate());
        wantityDTO.setCreateBy(wantityEntity.getCreateBy());
        if(wantityEntity.getModifiedBy()!=null)
        {
            wantityDTO.setModifiedBy(wantityEntity.getModifiedBy());
        }
        if(wantityEntity.getModifiedDate()!=null)
        {
            wantityDTO.setModifiedDate(wantityEntity.getModifiedDate());
        }

        return wantityDTO;
    }

    public static WantityDTO toWantityDTO(WantityDTO oldwantity, WantityDTO newWantity) {

        newWantity.setTimeWantity(oldwantity.getTimeWantity());
        newWantity.setWantity(oldwantity.getWantity());
        newWantity.setId(oldwantity.getId());
        newWantity.setCreateDate(oldwantity.getCreateDate());
        newWantity.setCreateBy(oldwantity.getCreateBy());
        if(oldwantity.getModifiedBy()!=null)
        {
            newWantity.setModifiedBy(oldwantity.getModifiedBy());
        }
        if(oldwantity.getModifiedDate()!=null)
        {
            newWantity.setModifiedDate(oldwantity.getModifiedDate());
        }

        return newWantity;

    }

    public static WantityEntity toWantityEntity(WantityDTO wantityDTO) {
        WantityEntity wantityEntity = new WantityEntity();
        wantityEntity.setTimeWantity(wantityDTO.getTimeWantity());
        wantityEntity.setWantity(wantityDTO.getWantity());
        wantityEntity.setId(wantityDTO.getId());
        wantityEntity.setCreateDate(wantityDTO.getCreateDate());
        wantityEntity.setCreateBy(wantityDTO.getCreateBy());
        if(wantityDTO.getModifiedBy()!=null)
        {
            wantityEntity.setModifiedBy(wantityDTO.getModifiedBy());
        }
        if(wantityDTO.getModifiedDate()!=null)
        {
            wantityEntity.setModifiedDate(wantityDTO.getModifiedDate());
        }

        return wantityEntity;
    }
}
