package com.latiny.mapper;

import com.latiny.domain.ResourceDomain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ResourceDomainMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ResourceDomain record);

    int insertSelective(ResourceDomain record);

    ResourceDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResourceDomain record);

    int updateByPrimaryKey(ResourceDomain record);

    ResourceDomain getResourceByUrl(String url);

    List<ResourceDomain> findAll();
}