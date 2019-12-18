package com.latiny.service.impl;

import com.latiny.domain.UserDomain;
import com.latiny.mapper.UserDomainMapper;
import com.latiny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: UserServiceImpl
 * @date 2019/9/30 11:59
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDomainMapper userDomainMapper;

    @Override
    public List<UserDomain> findAll() {
        return userDomainMapper.findAll();
    }

    @Override
    public UserDomain findUserByUsername(String username) {
        return userDomainMapper.findUserByUsername(username);
    }
}
