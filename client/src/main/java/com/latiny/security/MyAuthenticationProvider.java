package com.latiny.security;

import com.latiny.exception.MyBadCredentialsException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String inputPassword = (String) authentication.getCredentials();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(inputPassword)) {
            throw new MyBadCredentialsException(101, "用户名与密码无效");
        }
        MyUserDetails userDetails = (MyUserDetails) userDetailsService.loadUserByUsername(username);
        String dbPassword = userDetails.getUser().getPassword();
        if (!passwordEncoder.matches(inputPassword, dbPassword)) {
            throw new MyBadCredentialsException(102, "用户或密码错误");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, inputPassword, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
