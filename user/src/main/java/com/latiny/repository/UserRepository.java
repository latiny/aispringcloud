package com.latiny.repository;

import com.latiny.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: UserRepository
 * @date 2019/12/9 9:32
 */
@Repository
public interface UserRepository {

    public List<User> findAll(int index, int limit);

    public User findById(long id);

    public int count();

    public void save(User user);

    public void update(User user);

    public void deleteById(long id);
}
