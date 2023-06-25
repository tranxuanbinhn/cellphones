package com.cellphones.api.admin;

import com.cellphones.api.output.Output;
import com.cellphones.dto.BrandDTO;
import com.cellphones.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class BrandAPI {
    @Autowired
    private IBrandService brandService;

    @GetMapping(value = "/api-brand")
    public Output<BrandDTO> ShowView(@RequestParam("page") int page,
                                     @RequestParam("limit") int limit)
    {
        Output<BrandDTO> brandDTOOutput = new Output<>();
        brandDTOOutput.setPage(page);
        Pageable pageable = PageRequest.of(page-1,limit);
        brandDTOOutput.setListResult(brandService.findAll(pageable));
        brandDTOOutput.setTotalPage((int) Math.ceil(brandService.countPage()/limit));
        return brandDTOOutput;
    }

    @PostMapping(value = "/api-brand")
    public BrandDTO createBrand (@RequestBody BrandDTO brandDTO)
    {
        return brandService.save(brandDTO);
    }
    @PutMapping(value = "/api-brand/{id}")
    public BrandDTO updateBrand (@PathVariable("id") long id,
                                 @RequestBody BrandDTO brandDTO)
    {
    brandDTO.setId(id);
    return brandService.save(brandDTO);
    }
    @DeleteMapping(value = "/api-brand")
    public void deleteBrand(@RequestBody List<Long> ids)
    {
        brandService.Delete(ids);
    }
}
