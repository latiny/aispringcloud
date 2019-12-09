package com.latiny.entity;

import java.util.Date;

/**
 * @author Latiny
 * @version 1.0
 * @description: User
 * @date 2019/12/9 9:30
 */
public class User {

    private Long id;
    private String userName;
    private String password;
    private String nickName;
    private String gender;
    private String telephone;
    private Date registerDate;
    private String address;

    public User() {
    }

    public User(Long id, String userName, String password, String nickName, String gender, String telephone, Date registerDate, String address) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
        this.gender = gender;
        this.telephone = telephone;
        this.registerDate = registerDate;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
