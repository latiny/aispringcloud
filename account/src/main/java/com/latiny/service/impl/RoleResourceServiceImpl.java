package com.latiny.service.impl;

import com.latiny.domain.RoleResourceDomain;
import com.latiny.mapper.RoleResourceDomainMapper;
import com.latiny.service.RoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: ResourceServiceImpl
 * @date 2019/9/30 14:25
 */
@Service
public class RoleResourceServiceImpl implements RoleResourceService {

    @Autowired
    private RoleResourceDomainMapper roleResourceDomainMapper;

    @Override
    public List<RoleResourceDomain> findAll() {
        return roleResourceDomainMapper.findAll();
    }
}
