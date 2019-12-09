package latiny.com.Service;

import latiny.com.domain.ResourceDomain;

/**
 * @author Latiny
 * @version 1.0
 * @description: ResourceService
 * @date 2019/9/30 14:25
 */
public interface ResourceService {

    ResourceDomain getResourceByUrl(String url);
}
