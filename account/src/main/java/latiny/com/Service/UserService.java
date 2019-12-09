package latiny.com.Service;

import cn.latiny.domain.UserDomain;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: UserService
 * @date 2019/9/30 11:58
 */
public interface UserService {

    List<UserDomain> findAll();

    UserDomain findUserByUsername(String username);
}
