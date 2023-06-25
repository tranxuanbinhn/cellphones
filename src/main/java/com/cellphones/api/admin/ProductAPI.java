package com.cellphones.api.admin;

import com.cellphones.api.output.Output;
import com.cellphones.dto.ProductDTO;
import com.cellphones.service.IProductService;
import com.cellphones.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ProductAPI {
    @Autowired
    private IProductService productService;

    @GetMapping(value = "/api-product")
    public Output<ProductDTO> ShowsProduct(@RequestParam("page")int page,
                                           @RequestParam("limit") int limit)
    {
        Output output = new Output();
        output.setPage(page);
        Pageable pageable = PageRequest.of(page-1,limit);
        output.setListResult(productService.findAll(pageable));
        output.setTotalPage((int) Math.ceil(productService.countPage()/limit));
        return output;
    }
    @PostMapping(value = "/api-product")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO)
    {

        return productService.save(productDTO);
    }

    @PutMapping(value = "/api-product/{id}")
    public ProductDTO updateProduct(@PathVariable("id") long id,
                                    @RequestBody ProductDTO productDTO)
    {
        productDTO.setId(id);
        return productService.save(productDTO);
    }

    @DeleteMapping(value = "/api-product")
    public void DeleteProduct(@RequestBody List<Long> ids)
    {
        productService.Delete(ids);
    }

}
