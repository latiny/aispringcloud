package com.latiny.controller;

import com.latiny.entity.User;
import com.latiny.repository.UserRepository;
import com.latiny.vo.ResultVO;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private UserRepository userRepository;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/index")
    public String index() {
        return port;
    }

    @RequestMapping("/findAll/{index}/{limit}")
    public ResultVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        List<User> list = userRepository.findAll(index, limit);
        return new ResultVO(0, "success", userRepository.count(), list);
    }

    @RequestMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id) {
        return userRepository.findById(id);
    }

    @RequestMapping("/count")
    public int count() {
        return userRepository.count();
    }

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        userRepository.save(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user) {
        userRepository.update(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        userRepository.deleteById(id);
    }
}
