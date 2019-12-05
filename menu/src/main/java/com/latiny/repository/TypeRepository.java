package com.latiny.repository;

import com.latiny.entity.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: Repository
 * @date 2019/12/3 10:55
 */
@Repository
public interface TypeRepository {

    public List<Type> findAll();
}
