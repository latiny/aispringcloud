package com.latiny.security;

import com.alibaba.fastjson.JSONObject;
import com.latiny.constant.SecurityConstant;
import com.latiny.domain.ResourceDomain;
import com.latiny.domain.RoleDomain;
import com.latiny.domain.RoleResourceDomain;
import com.latiny.feign.AccountFeign;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: MyFilterInvocationSecurityMetadataSource
 * @date 2019/12/9 22:01
 */
@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    AccountFeign accountFeign;
    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(MyFilterInvocationSecurityMetadataSource.class);

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        Collection<ConfigAttribute> result = new HashSet<>();
        FilterInvocation filterInvocation = (FilterInvocation) object;
        List<RoleResourceDomain> roleResourceList = accountFeign.findRoleResource();

        for (RoleResourceDomain roleResource : roleResourceList) {
            String url = roleResource.getUrl();
            if (!matchPathRequest(filterInvocation, url)) {
                continue;
            }
            SecurityConfig securityConfig = new SecurityConfig(roleResource.getRoleCode());
            result.add(securityConfig);
        }

        return result;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    /**
     * 判断路径跟资源中value是否匹配 匹配成功返回TRUE，否则返回FALSE.
     *
     * @param filterInvocation
     * @param url
     * @return
     */
    private boolean matchPathRequest(FilterInvocation filterInvocation, String url) {
        String pattern = SecurityConstant.EMPTY_STRING;
        try {
            JSONObject jsonObj = JSONObject.parseObject(url);
            pattern = jsonObj.getString(SecurityConstant.URL);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            logger.error("resource value is wrong: " + url);
        }

        if(StringUtils.isEmpty(pattern)){
            return Boolean.FALSE;
        }

        AntPathRequestMatcher matcher = new AntPathRequestMatcher(pattern);
        if (!matcher.matches(filterInvocation.getHttpRequest())) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
