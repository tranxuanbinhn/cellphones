package com.cellphones.api.user;

import com.cellphones.api.output.Output;
import com.cellphones.dto.CartDTO;
import com.cellphones.dto.ProductDTO;
import com.cellphones.service.ICartService;
import com.cellphones.service.impl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class UserCartAPI {

    @Autowired
    private ICartService iCartService;

    @PostMapping
    public CartDTO addNewCart(@RequestBody ProductDTO productDTO)
    {

    return iCartService.addNewCart(productDTO);
    }
}
