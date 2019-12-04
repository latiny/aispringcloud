package com.latiny.controller;

import com.latiny.entity.Menu;
import com.latiny.repository.MenuRepository;
import com.latiny.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: MenuHandler
 * @date 2019/12/2 9:31
 */
@RestController
@RequestMapping("/menu")
public class MenuHandler {

    @Value("${server.port}")
    private String port;

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index,
                          @PathVariable("limit")int limit) {
        int count = menuRepository.count();
        return new MenuVO(0, "", count, menuRepository.findAll(index, limit));
    }

    @GetMapping("/index")
    public String index() {
        return this.port;
    }
}
