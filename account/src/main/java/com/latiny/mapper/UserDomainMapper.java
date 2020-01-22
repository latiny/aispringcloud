package com.latiny.mapper;

import com.latiny.domain.UsersDomain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDomainMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UsersDomain record);

    int insertSelective(UsersDomain record);

    UsersDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UsersDomain record);

    int updateByPrimaryKey(UsersDomain record);

    List<UsersDomain> findAll(int index, int limit);

    UsersDomain findUserByUsername(String username);

    UsersDomain findById(long id);

    int count();
}