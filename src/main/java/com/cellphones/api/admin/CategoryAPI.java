package com.cellphones.api.admin;

import com.cellphones.api.output.Output;
import com.cellphones.dto.CategoryDTO;
import com.cellphones.dto.UserDTO;
import com.cellphones.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class CategoryAPI {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/api-category")
    public Output<CategoryDTO> getCategory(@RequestParam("page") int page,
                              @RequestParam("limit") int limit)
    {
        Output<CategoryDTO> categoryDTOOutput = new Output<>();
        Pageable pageable = PageRequest.of(page-1,limit);
        categoryDTOOutput.setListResult(categoryService.findAll(pageable));
        categoryDTOOutput.setTotalPage((int) Math.ceil(categoryService.countPage()/limit));
        categoryDTOOutput.setPage(page);

        return categoryDTOOutput;
    }
    @PostMapping(value = "/api-category")
    public CategoryDTO createCaregory(@RequestBody CategoryDTO categoryDTO)
    {
        return categoryService.save(categoryDTO);
    }
    @PutMapping(value = "/api-category/{id}")
    public CategoryDTO updateCaregory(@RequestBody CategoryDTO categoryDTO, @PathVariable("id") long id)
    {
        categoryDTO.setId(id);
        return categoryService.save(categoryDTO);
    }
    @DeleteMapping(value = "/api-category")
    public void deleteCaregory(@RequestBody List<Long> ids)
    {
       categoryService.Delete(ids);
    }
}
