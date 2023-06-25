package com.cellphones.service;

import com.cellphones.dto.BrandDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBrandService extends IGenericService<BrandDTO> {
    @Override
    BrandDTO save(BrandDTO brandDTO);

    @Override
    List<BrandDTO> findAll(Pageable page);

    @Override
    long countPage();

    @Override
    void Delete(List<Long> ids);
}
