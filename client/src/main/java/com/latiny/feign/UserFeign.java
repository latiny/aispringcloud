package com.latiny.feign;

import com.latiny.entity.User;
import com.latiny.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Latiny
 * @version 1.0
 * @description: MenuFeign
 * @date 2019/12/3 15:10
 */
@FeignClient(value = "user")
public interface UserFeign {

    @GetMapping("/user/findAll/{index}/{limit}")
    public ResultVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @GetMapping("/user/findById/{id}")
    public User findById(@PathVariable("id") long id);

    @DeleteMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);

    @PostMapping("/user/save")
    public void save(User user);

    @PutMapping("/user/update")
    public void update(User user);
}
