package com.latiny.service.impl;

import com.latiny.domain.UsersDomain;
import com.latiny.mapper.UserDomainMapper;
import com.latiny.model.Users;
import com.latiny.service.UsersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: UserServiceImpl
 * @date 2019/9/30 11:59
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserDomainMapper userDomainMapper;

    @Override
    public List<Users> findAll(int index, int limit) {
        List<UsersDomain> list = userDomainMapper.findAll(index, limit);
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        List<Users> usersList = new ArrayList<>(list.size());
        for (UsersDomain domain : list) {
            Users users = new Users();
            BeanUtils.copyProperties(domain, users);
            usersList.add(users);
        }

        return usersList;
    }

    @Override
    public Users findUserByUsername(String username) {
        UsersDomain domain = userDomainMapper.findUserByUsername(username);
        if (domain == null) {
            return null;
        }
        Users users = new Users();
        BeanUtils.copyProperties(domain, users);
        return users;
    }

    @Override
    public int count() {
        return userDomainMapper.count();
    }
}
