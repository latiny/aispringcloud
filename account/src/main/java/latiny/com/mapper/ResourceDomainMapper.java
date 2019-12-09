package latiny.com.mapper;

import cn.latiny.domain.ResourceDomain;
import org.springframework.stereotype.Component;

@Component
public interface ResourceDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResourceDomain record);

    int insertSelective(ResourceDomain record);

    ResourceDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResourceDomain record);

    int updateByPrimaryKey(ResourceDomain record);

    ResourceDomain getResourceByUrl(String url);
}