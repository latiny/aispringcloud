package latiny.com.mapper;

import cn.latiny.domain.UserRoleDomain;

public interface UserRoleDomainMapper {
    int insert(UserRoleDomain record);

    int insertSelective(UserRoleDomain record);
}