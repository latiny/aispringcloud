package com.latiny.service;

import com.latiny.domain.RoleResourceDomain;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: ResourceService
 * @date 2019/9/30 14:25
 */
public interface RoleResourceService {

    List<RoleResourceDomain> findAll();
}
