package com.imlty.service;

import com.imlty.domain.ResourceCategory;
import com.imlty.domain.Role;
import com.imlty.vo.RoleMenuVO;

import java.util.List;

public interface RoleService {
    /**
     * 查询所有角色
     */
    List<Role> findAllRole(Role role);
    /**
     * 根据角色id查询菜单的id
     * @param roleId
     * @return
     */
    List<Integer> findMenuIdByRoleId(Integer roleId);
    /**
     * 为角色分配菜单
     */
    void roleContextMenu(RoleMenuVO roleMenuVO);
    /**
     * 删除角色
     */
    void deleteRole(Integer id);

    /**
     * 根据角色id查询目录信息以及相关的资源信息
     * @param roleId
     * @return
     */
    List<ResourceCategory>findResourceListByRoleId(Integer roleId);
}
