package com.cellphones.api.login;

import com.cellphones.account.JwtUltils;
import com.cellphones.account.payload.JwtReponse;
import com.cellphones.account.payload.LoginRequest;
import com.cellphones.account.payload.MessageRepones;
import com.cellphones.config.PasswordEncoderImpl;
import com.cellphones.dto.UserDTO;
import com.cellphones.dto.UserDetailImpl;
import com.cellphones.repository.RoleRepository;
import com.cellphones.repository.UserRepository;
import com.cellphones.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoderImpl passwordEncoder;

    @Autowired
    private JwtUltils jwtUltils;

    @Autowired
    private IUserService userService;

    @PostMapping("/signin")
    public ResponseEntity<JwtReponse> Login(@Valid @RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(loginRequest.getUser(), loginRequest.getPassword());
        Authentication authentication =null;

        try {
            authentication= authenticationManager.authenticate(usernamePassword);
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }
        catch (AuthenticationException e)
        {
            e.getMessage();
            e.printStackTrace();
        }
        String jwt = jwtUltils.generateJwtToken(authentication);
        UserDetailImpl userDetail = (UserDetailImpl) authentication.getPrincipal();

        List<String> roles = userDetail.getAuthorities().stream().map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(
                new JwtReponse(
                        jwt,
                        userDetail.getId(),
                        userDetail.getUsername(),
                        userDetail.getEmail(),
                        userDetail.getStatus(),
                        userDetail.getPhoneNumber(),
                        userDetail.getFullName(),
                        userDetail.getCreateBy(),
                        userDetail.getModifedBy(),
                        userDetail.getCreateDate(),
                        userDetail.getModifiedDate(),
                        roles
                )
        );
    }

    @PostMapping(value="/signup")
    public ResponseEntity<?> Signup(@RequestBody UserDTO userDTO) {
        if (userService.existsByUsername(userDTO.getUsername())) {
            return ResponseEntity.badRequest().body("Error!!! User name is already");
        }
        if (userService.existsByEmail(userDTO.getEmail())) {
            return ResponseEntity.badRequest().body("Error!!! Email is already use");
        }
        else if (userService.existsByNumberphone(userDTO.getPhoneNumber())) {
            return ResponseEntity.badRequest().body("Error!!! Phone number is already use");
        }
        UserDTO newUserDTO1 = userService.save(userDTO);
        return ResponseEntity.ok(new MessageRepones("Register successly"));
    }

}
