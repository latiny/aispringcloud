package com.latiny.vo;

import com.latiny.entity.Menu;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: MenuVO
 * @date 2019/12/3 16:42
 */
public class MenuVO {

    private Integer code;

    private String msg;

    private Integer count;

    private List<Menu> data;

    public MenuVO() {
    }

    public MenuVO(Integer code, String msg, Integer count, List<Menu> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Menu> getData() {
        return data;
    }

    public void setData(List<Menu> data) {
        this.data = data;
    }
}
