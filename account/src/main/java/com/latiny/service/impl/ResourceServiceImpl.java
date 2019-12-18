package com.latiny.service.impl;

import com.latiny.domain.ResourceDomain;
import com.latiny.mapper.ResourceDomainMapper;
import com.latiny.service.ResourceService;
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
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDomainMapper resourceDomainMapper;

    @Override
    public ResourceDomain getResourceByUrl(String url) {
        if (url.contains("?")) {
            url = url.substring(0, url.indexOf("?"));
        }
        int a = 10;
        return resourceDomainMapper.getResourceByUrl(url);
    }

    @Override
    public List<ResourceDomain> findAll() {
        return resourceDomainMapper.findAll();
    }
}
