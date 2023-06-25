package com.cellphones.api.user;

import com.cellphones.api.output.Output;
import com.cellphones.dto.ProductDTO;
import com.cellphones.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class UserProductAPI {

    @Autowired
    private IProductService productService;

    @GetMapping()
    public Output<ProductDTO> showsProduct(@RequestParam("page")int page,
                                           @RequestParam("limit") int limit)
    {
        Output output = new Output();
        output.setPage(page);
        Pageable pageable = PageRequest.of(page-1,limit);
        output.setListResult(productService.findAll(pageable));
        output.setTotalPage((int) Math.ceil(productService.countPage()/limit));
        return output;
    }
    @GetMapping("/filter")
    public List<ProductDTO> showProductsByFilter(@RequestParam("minPrice") double minPrice,
                                                 @RequestParam("maxPrice") double maxPrice
                                                 )
    {
        String color = null;
        String sortBy = "price";
        String sortOrder = "asc";
        Sort sort = null;
        if (sortBy != null) {
            sort = Sort.by(Sort.Direction.fromString(sortOrder), sortBy);
        }

        return productService.filterProduct(minPrice,maxPrice,color,sort);
    }
    @GetMapping("/detail/{id}")
    public ProductDTO showDetialProduct(@PathVariable Long id)
    {
        return productService.findProductById(id);
    }
}
