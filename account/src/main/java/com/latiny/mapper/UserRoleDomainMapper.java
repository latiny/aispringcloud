package com.latiny.mapper;

import com.latiny.domain.UserRoleDomain;

public interface UserRoleDomainMapper {
    int insert(UserRoleDomain record);

    int insertSelective(UserRoleDomain record);
}