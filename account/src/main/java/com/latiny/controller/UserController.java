package com.latiny.controller;

import com.latiny.domain.UsersDomain;
import com.latiny.mapper.UserDomainMapper;
import com.latiny.model.Users;
import com.latiny.service.UsersService;
import com.latiny.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: UserController
 * @date 2019/12/9 9:16
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDomainMapper userDomainMapper;

    @Autowired
    private UsersService usersService;

    @RequestMapping("/findAll/{index}/{limit}")
    public ResultVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        List<Users> list = usersService.findAll(index, limit);
        return new ResultVO(0, "success", usersService.count(), list);
    }

    @RequestMapping("/findById/{id}")
    public UsersDomain findById(@PathVariable("id") long id) {
        return userDomainMapper.findById(id);
    }

    @RequestMapping("/count")
    public int count() {
        return userDomainMapper.count();
    }

    @PostMapping("/save")
    public void save(@RequestBody UsersDomain user) {
        userDomainMapper.insert(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody UsersDomain user) {
        userDomainMapper.updateByPrimaryKey(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        userDomainMapper.deleteByPrimaryKey(id);
    }


}
