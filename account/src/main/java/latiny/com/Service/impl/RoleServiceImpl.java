package latiny.com.Service.impl;

import cn.latiny.Service.RoleService;
import cn.latiny.domain.RoleDomain;
import cn.latiny.mapper.RoleDomainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: RoleServiceImpl
 * @date 2019/9/30 10:41
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDomainMapper roleDomainMapper;

    @Override
    public List<RoleDomain> findRolesByUserName(String username) {
        return roleDomainMapper.findRolesByUserName(username);
    }

    @Override
    public List<RoleDomain> findRolesByRosourceId(long resourceId) {
        return roleDomainMapper.findRolesByResourceId(resourceId);
    }
}
