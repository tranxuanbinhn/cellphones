package com.cellphones.account.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

public class JwtReponse {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Integer status;
    private String phoneNumber;
    private String fullName;
    private String createBy;
    private String modifedBy;
    private Date createDate;
    private Date modifiedDate;
    private List<String> roles;
    private String accessToken;
    private String typeToken = "Bearer";

    public JwtReponse( String token,Long id, String username, String email, Integer status, String phoneNumber, String fullName, String createBy, String modifedBy, Date createDate, Date modifiedDate, List<String> roles) {
        this.accessToken = token;
        this.id = id;
        this.username = username;

        this.email = email;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.createBy = createBy;
        this.modifedBy = modifedBy;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.roles = roles;

    }

    public String getTypeToken() {
        return typeToken;
    }


    public void setTypeToken(String typeToken) {
        this.typeToken = typeToken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifedBy() {
        return modifedBy;
    }

    public void setModifedBy(String modifedBy) {
        this.modifedBy = modifedBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String token) {
        this.accessToken = token;
    }
}
