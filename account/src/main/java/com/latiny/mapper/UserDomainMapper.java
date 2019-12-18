package com.latiny.mapper;

import com.latiny.domain.UserDomain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDomainMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserDomain record);

    int insertSelective(UserDomain record);

    UserDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDomain record);

    int updateByPrimaryKey(UserDomain record);

    List<UserDomain> findAll();

    UserDomain findUserByUsername(String username);
}