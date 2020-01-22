package com.latiny.security;

import com.latiny.domain.RoleDomain;
import com.latiny.domain.UserDomain;
import com.latiny.entity.SysUser;
import com.latiny.entity.Users;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: MyUserDetails
 * @date 2019/12/9 17:57
 */
public class MyUserDetails implements UserDetails {

    private Users user = null;
    private List<RoleDomain> roles;

    public MyUserDetails() {

    }

    public MyUserDetails(Users user) {
        this.user = user;
    }

    public MyUserDetails(Users user, List<RoleDomain> roles) {
        this(user);
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleDomain role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getPassword();
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

    public void setRoles(List<RoleDomain> roles) {
        this.roles = roles;
    }

    public List<RoleDomain> getRoles() {
        return roles;
    }

    public Users getUser() {
        return user;
    }
}
