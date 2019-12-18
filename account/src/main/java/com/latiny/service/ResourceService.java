package com.latiny.service;

import com.latiny.domain.ResourceDomain;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: ResourceService
 * @date 2019/9/30 14:25
 */
public interface ResourceService {

    ResourceDomain getResourceByUrl(String url);

    List<ResourceDomain> findAll();
}
