package latiny.com.mapper;

import latiny.com.domain.RoleDomain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleDomainMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RoleDomain record);

    int insertSelective(RoleDomain record);

    RoleDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleDomain record);

    int updateByPrimaryKey(RoleDomain record);

    List<RoleDomain> findRolesByUserName(String username);

    List<RoleDomain> findRolesByResourceId(long resourceId);
}