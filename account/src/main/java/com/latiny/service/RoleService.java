package com.latiny.service;

import com.latiny.domain.RoleDomain;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: RoleService
 * @date 2019/9/30 10:39
 */
public interface RoleService {

    List<RoleDomain> findRolesByUserName(String username);

    List<RoleDomain> findRolesByRosourceId(long resourceId);
}
