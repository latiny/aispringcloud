package com.latiny.feign;

import com.latiny.domain.ResourceDomain;
import com.latiny.domain.RoleDomain;
import com.latiny.domain.RoleResourceDomain;
import com.latiny.domain.UserDomain;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: MenuFeign
 * @date 2019/12/3 15:10
 */
@FeignClient(value = "account", configuration = FeignConfig.class)
public interface AccountFeign {

    @GetMapping("/account/findAll")
    public List<UserDomain> findAll();

    @GetMapping("/account/findUserByUsername/{username}")
    public UserDomain findUserByUsername(@PathVariable("username") String username);

    @RequestMapping("/account/findRolesByUserName/{username}")
    public List<RoleDomain> findRolesByUserName(@PathVariable("username") String username);

    @RequestMapping("/account/findRolesByRosourceId/{resourceId}")
    public List<RoleDomain> findRolesByRosourceId(@PathVariable("resourceId") long resourceId);

    @RequestMapping("/account/getResourceByUrl")
    public ResourceDomain getResourceByUrl(@RequestParam("url") String url);

    @GetMapping("/account/findAllResources")
    public List<ResourceDomain> findAllResources();

    @GetMapping("/account/findRoleResource")
    public List<RoleResourceDomain> findRoleResource();
}
