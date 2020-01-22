package com.latiny.service;

import com.latiny.model.Users;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: UserService
 * @date 2019/9/30 11:58
 */
public interface UsersService {

    List<Users> findAll(int limit, int index);

    Users findUserByUsername(String username);

    int count();
}
