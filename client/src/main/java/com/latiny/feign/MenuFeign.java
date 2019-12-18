package com.latiny.feign;

import com.latiny.entity.Menu;
import com.latiny.entity.Type;
import com.latiny.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: MenuFeign
 * @date 2019/12/3 15:10
 */
@FeignClient(value = "menu")
public interface MenuFeign {

    @GetMapping("/menu/findAll/{index}/{limit}")
    public ResultVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @DeleteMapping("/menu/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);

    @GetMapping("/menu/findTypes")
    public List<Type> findTypes();

    @PostMapping(value = "/menu/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(Menu menu);

    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id") long id);

    @PutMapping(value = "/menu/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(Menu menu);
}
