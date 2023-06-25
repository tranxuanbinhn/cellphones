package com.cellphones.service.impl;

import com.cellphones.account.UserIsLogin;
import com.cellphones.convert.CartConverter;
import com.cellphones.convert.ProductConverter;
import com.cellphones.dto.CartDTO;
import com.cellphones.dto.ProductDTO;
import com.cellphones.dto.UserDetailImpl;
import com.cellphones.entity.CartEntity;
import com.cellphones.entity.UserEntity;
import com.cellphones.repository.CartRepository;
import com.cellphones.repository.ProductRepository;
import com.cellphones.repository.UserRepository;
import com.cellphones.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import com.cellphones.entity.ProductEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements ICartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;


    @Override
    public CartDTO addNewCart(ProductDTO productDTO) {

        ProductEntity  productEntity = productRepository.findOneById(productDTO.getId());
        UserEntity userEntity = userRepository.findByUsername(UserIsLogin.getLoggedInUserDetails());
        if(userEntity.getId()==null)
        {
            return null;
        }
        CartEntity cartEntity = findCartExist(userEntity.getId());
        List<ProductEntity> list = new ArrayList<>();
        if(cartEntity == null)
            cartEntity = new CartEntity();
        else
        {
            list = cartEntity.getProducts();

        }

        ArrayList<ProductEntity> arrayList = new ArrayList<>(list);
        arrayList.add(productEntity);
        cartEntity.setProducts(arrayList);

        cartEntity.setUser(userEntity);

        return CartConverter.toCartDTO(cartRepository.save(cartEntity));    }
    private CartEntity findCartExist(Long id)
    {

        CartEntity cart = cartRepository.findCartEntitiesByUserId(id);
        if(cart == null)
        {
        return  null;
        }
        return cart;


    }
}
