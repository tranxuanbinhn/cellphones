package com.cellphones.dto;

import com.cellphones.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class UserDetailImpl implements UserDetails {

    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private Integer status;
    private String phoneNumber;
    private String fullName;
    private String createBy;
    private String modifedBy;
    private Date createDate;
    private Date modifiedDate;

    public UserDetailImpl(Long id, String username, String password, String email, Integer status, String phoneNumber, String fullName, String createBy, String modifeBy, Date createDate, Date modifiedDate, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.createBy = createBy;
        this.modifedBy = modifeBy;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.authorities = authorities;
    }

    public static UserDetailImpl build(UserEntity user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return new UserDetailImpl(user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getStatus(),
                user.getPhoneNumber(),
                user.getFullName(),
                user.getCreateBy(),
                user.getModifiedBy(),
                user.getCreateDate(),
                user.getModifiedDate(),

                authorities);
    }


    public Integer getStatus() {
        return status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCreateBy() {
        return createBy;
    }

    public String getModifedBy() {
        return modifedBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }


    @Override
    public String getPassword() {
        return password;
    }


    public String getEmail() {
        return email;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
