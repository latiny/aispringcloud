package com.latiny.security;

import com.latiny.domain.UserDomain;
import com.latiny.entity.Users;
import com.latiny.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: MyUserDetailsService
 * @date 2019/12/9 18:03
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountFeign accountFeign;

    public List<UserDomain> getAllUser() {
        return accountFeign.findAll();
    }

    public Users getByUsername(String username) {

        return accountFeign.findUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在：" + username);
        }
        return new MyUserDetails(user, accountFeign.findRolesByUserName(username));
    }
}
