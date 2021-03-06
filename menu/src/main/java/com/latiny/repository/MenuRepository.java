package com.latiny.repository;

import com.latiny.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: Repository
 * @date 2019/12/3 10:55
 */
@Repository
public interface MenuRepository {

    public List<Menu> findAll(int index, int limit);

    public int count();

    public Menu findById(long id);

    public void save(Menu menu);

    public void update(Menu menu);

    public void deleteById(long id);
}
