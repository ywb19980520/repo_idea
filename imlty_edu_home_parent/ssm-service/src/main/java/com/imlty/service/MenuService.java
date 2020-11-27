package com.imlty.service;

import com.imlty.domain.Menu;

import java.util.List;

public interface MenuService {
    /**
     * 查询所有的父子菜单信息
     */
    List<Menu> findSubMenuListByPid(Integer pid);
    /**
     * 查询所有菜单信息
     * @return
     */
    List<Menu> findAllMenu();

    /**
     * 根据id 查询菜单信息
     * @param id
     * @return
     */
    Menu findMenuById(Integer id);
}
