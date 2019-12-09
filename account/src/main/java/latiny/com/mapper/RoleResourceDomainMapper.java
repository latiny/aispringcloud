package latiny.com.mapper;

import cn.latiny.domain.RoleResourceDomain;

public interface RoleResourceDomainMapper {
    int insert(RoleResourceDomain record);

    int insertSelective(RoleResourceDomain record);
}