package com.imlty.dao;

import com.imlty.domain.Role;
import com.imlty.domain.Role_menu_relation;

import java.util.List;

public interface RoleMapper {
    /**
     * 查询所有角色
     */
    List<Role> findAllRole(Role role);

    /**
     * 根据角色id查询菜单的id
     *
     * @param roleId
     * @return
     */
    List<Integer> findMenuIdByRoleId(Integer roleId);

    /**
     * 清空中间表的关联关系
     */
    void deleteRoleContextMenuByRoleId(Integer id);

    /**
     * 为角色分配菜单信息
     */
    void RoleContextMenu(Role_menu_relation roleMenuRelation);

    /**
        删除角色
        */
    void deleteRole(Integer id);
}