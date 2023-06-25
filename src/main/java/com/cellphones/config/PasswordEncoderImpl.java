package com.cellphones.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderImpl {
    public BCryptPasswordEncoder encoder()
    {
        return new BCryptPasswordEncoder();
    }
}
