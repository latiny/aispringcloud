package com.latiny.security;

import com.latiny.entity.Role;
import com.latiny.entity.SysUser;
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

    private String username;
    private String password;
    private List<Role> roles;

    public MyUserDetails() {

    }

    public MyUserDetails(SysUser user) {
        this.username = user.getUserName();
        this.password = user.getPassword();
    }

    public MyUserDetails(SysUser user, List<Role> roles) {
        this.username = user.getUserName();
        this.password = user.getPassword();
        this.roles = roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Role> getRoles(){
        return roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
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
