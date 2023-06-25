package com.cellphones.service;

import com.cellphones.dto.CartDTO;
import com.cellphones.dto.ProductDTO;

public interface ICartService {
    CartDTO addNewCart(ProductDTO newCart);
}
