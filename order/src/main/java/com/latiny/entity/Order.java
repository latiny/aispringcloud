package com.latiny.entity;

/**
 * @author Latiny
 * @version 1.0
 * @description: Order
 * @date 2019/12/17 17:59
 */
public class Order {

    private Menu menu;
    private SysUser user;
    private SysUser admin;
    private Integer state;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public SysUser getAdmin() {
        return admin;
    }

    public void setAdmin(SysUser admin) {
        this.admin = admin;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
