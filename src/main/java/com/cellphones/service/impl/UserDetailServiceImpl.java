package com.cellphones.service.impl;

import com.cellphones.dto.UserDetailImpl;
import com.cellphones.entity.UserEntity;
import com.cellphones.repository.UserRepository;
import com.cellphones.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity= userRepository.findByUsername(username);
        return UserDetailImpl.build(userEntity);
    }
}
