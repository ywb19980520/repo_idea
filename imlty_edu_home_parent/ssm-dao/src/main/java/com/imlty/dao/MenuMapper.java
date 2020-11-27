package com.imlty.dao;

import com.imlty.domain.Menu;

import java.util.List;

public interface MenuMapper {

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
     * 根据id查询菜单
     * @param id
     * @return
     */
    Menu findMenuById(Integer id);
}
