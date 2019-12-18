package com.latiny.controller;

import com.latiny.domain.ResourceDomain;
import com.latiny.domain.RoleDomain;
import com.latiny.domain.RoleResourceDomain;
import com.latiny.domain.UserDomain;
import com.latiny.service.ResourceService;
import com.latiny.service.RoleResourceService;
import com.latiny.service.RoleService;
import com.latiny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: AccountController
 * @date 2019/12/9 16:47
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private RoleResourceService roleResourceService;

    @GetMapping("/index")
    public String index() {
        return port;
    }

    @GetMapping("/findAllUsers")
    public List<UserDomain> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/findUserByUsername/{username}")
    public UserDomain findUserByUsername(@PathVariable("username") String username) {
        return userService.findUserByUsername(username);
    }

    @GetMapping("/findRolesByUserName/{username}")
    public List<RoleDomain> findRolesByUserName(@PathVariable("username") String username) {
        return roleService.findRolesByUserName(username);
    }

    @GetMapping("/findRolesByRosourceId/{resourceId}")
    public List<RoleDomain> findRolesByRosourceId(@PathVariable("resourceId") long resourceId) {
        return roleService.findRolesByRosourceId(resourceId);
    }

    @RequestMapping("/getResourceByUrl")
    public ResourceDomain getResourceByUrl(@RequestParam("url") String url) {
        ResourceDomain domain = resourceService.getResourceByUrl(url);
        return domain;
    }

    @GetMapping("/findAllResources")
    public List<ResourceDomain> findAllResources() {
        List<ResourceDomain> result = resourceService.findAll();
        return result;
    }

    @GetMapping("/findRoleResource")
    public List<RoleResourceDomain> findRoleResource() {
        List<RoleResourceDomain> result = roleResourceService.findAll();
        return result;
    }
}
