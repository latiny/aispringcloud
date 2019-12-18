package com.latiny.security.config;

import com.latiny.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @author Latiny
 * @version 1.0
 * @description: SpringSecurityConfig
 * @date 2019/12/9 17:54
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;
    /**
     * 根据一个url请求，获得访问它所需要的roles权限
     */
    @Autowired
    private MyFilterInvocationSecurityMetadataSource myFilterInvocationSecurityMetadataSource;
    /**
     * 接收一个用户的信息和访问一个url所需要的权限，判断该用户是否可以访问
     */
    @Autowired
    private MyAccessDecisionManager myAccessDecisionManager;
    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;
    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;
    @Autowired
    private MyAuthenticationProvider myAuthenticationProvider;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(myFilterInvocationSecurityMetadataSource);
                        o.setAccessDecisionManager(myAccessDecisionManager);
                        return o;
                    }
                })
                .anyRequest().authenticated()
                .antMatchers("/**").fullyAuthenticated()
                .antMatchers("/layui/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .and().formLogin().loginPage("/login").permitAll()
                .failureHandler(myAuthenticationFailureHandler)
                .successHandler(myAuthenticationSuccessHandler)
                .and().logout().permitAll()
                .and().csrf().disable().exceptionHandling().accessDeniedHandler(myAccessDeniedHandler);
        http.authenticationProvider(myAuthenticationProvider);
//        http.csrf().disable();
//        http.authorizeRequests()
//                .antMatchers("/js/**","/layui/**","/images/*","/fonts/**","/**/*.png ","/**/*.jpg").permitAll()
//                .antMatchers("/", "/login","/signin").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin().loginPage("/login").defaultSuccessUrl("/index")
//                .successHandler(myAuthenticationSuccessHandler)
//                .failureHandler(myAuthenticationFailureHandler).permitAll()
//                .and().logout().logoutSuccessUrl("login?logout").permitAll();
        //.and().addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
        //http.authenticationProvider();
    }

    /**
     * 在这里配置哪些页面不需要认证
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/layui/**");
//        web.ignoring().antMatchers("/js/**");
    }
}
