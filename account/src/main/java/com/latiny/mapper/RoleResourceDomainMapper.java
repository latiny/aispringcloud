package com.latiny.mapper;

import com.latiny.domain.RoleResourceDomain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleResourceDomainMapper {

    List<RoleResourceDomain> findAll();
}