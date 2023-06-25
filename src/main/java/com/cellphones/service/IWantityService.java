package com.cellphones.service;

import com.cellphones.dto.WantityDTO;
import com.cellphones.entity.WantityEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IWantityService extends IGenericService<WantityDTO>{
    @Override
    WantityDTO save(WantityDTO wantityDTO);

    @Override
    List<WantityDTO> findAll(Pageable page);

    @Override
    long countPage();

    @Override
    void Delete(List<Long> ids);
}
