package com.cellphones.service.impl;

import com.cellphones.convert.BrandConverter;
import com.cellphones.dto.BrandDTO;
import com.cellphones.entity.BrandEntity;
import com.cellphones.repository.BrandRepository;
import com.cellphones.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private BrandRepository brandRepository;
    @Override
    public BrandDTO save(BrandDTO brandDTO) {

        BrandEntity brandEntity= new BrandEntity();
        if(brandDTO.getId()==null)
        {
            brandEntity = BrandConverter.toBrandEntity(brandDTO);
        }
        else if(brandDTO.getId() != null)
        {
            BrandDTO oldBrand = BrandConverter.toBrandDTO(brandRepository.findOneById(brandDTO.getId()));
            brandEntity = BrandConverter.toBrandEntity(BrandConverter.toBrandDTO(brandDTO,oldBrand));
        }
        return BrandConverter.toBrandDTO(brandRepository.save(brandEntity));
    }

    @Override
    public List<BrandDTO> findAll(Pageable page) {
        List<BrandDTO> brandDTOS = new ArrayList<>();
        for (BrandEntity brandEntity :brandRepository.findAll(page).getContent()) {
           brandDTOS.add(BrandConverter.toBrandDTO(brandEntity));
        } ;
        return brandDTOS;
    }

    @Override
    public long countPage() {
        return brandRepository.count();
    }

    @Override
    public void Delete(List<Long> ids) {
        for (long id:ids) {
            brandRepository.deleteById(id);
        }
    }
}
