package latiny.com.Service.impl;

import cn.latiny.Service.ResourceService;
import cn.latiny.domain.ResourceDomain;
import cn.latiny.mapper.ResourceDomainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return resourceDomainMapper.getResourceByUrl(url);
    }
}
