package com.cellphones.service.impl;

import com.cellphones.convert.WantityConverter;
import com.cellphones.dto.WantityDTO;
import com.cellphones.entity.WantityEntity;
import com.cellphones.repository.WantityRepository;
import com.cellphones.service.IWantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class WantitiyService implements IWantityService {
    @Autowired
    private WantityRepository wantityRepository;
    @Override
    public WantityDTO save(WantityDTO wantityDTO) {
        WantityEntity wantityEntity = new WantityEntity();
        if(wantityDTO.getId() == null)
        {
            wantityEntity = WantityConverter.toWantityEntity(wantityDTO);
        }
        else if(wantityDTO.getId() != null)
        {
            WantityDTO oldWantity = WantityConverter.toWantityDTO(wantityRepository.findOneById(wantityDTO.getId()));
            wantityEntity = WantityConverter.toWantityEntity(WantityConverter.toWantityDTO(wantityDTO,oldWantity));

        }
        return WantityConverter.toWantityDTO(wantityRepository.save(wantityEntity));
    }

    @Override
    public List<WantityDTO> findAll(Pageable page) {
        List<WantityDTO> list = new ArrayList<>();
        for (WantityEntity wantityEntity :wantityRepository.findAll(page)) {
            list.add(WantityConverter.toWantityDTO(wantityEntity));
        }
        return list;
    }

    @Override
    public long countPage() {
        return wantityRepository.count();
    }

    @Override
    public void Delete(List<Long> ids) {
        wantityRepository.deleteAllById(ids);
    }
}
