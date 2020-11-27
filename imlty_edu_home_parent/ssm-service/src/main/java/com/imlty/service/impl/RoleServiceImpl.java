package com.imlty.service.impl;

import com.imlty.dao.RoleMapper;
import com.imlty.domain.Role;
import com.imlty.domain.Role_menu_relation;
import com.imlty.service.RoleService;
import com.imlty.vo.RoleMenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole(Role role) {
        List<Role> allRole = roleMapper.findAllRole(role);
        System.out.println(allRole);
        return allRole;
    }

    @Override
    public List<Integer> findMenuIdByRoleId(Integer roleId) {

        List<Integer> menuIds = roleMapper.findMenuIdByRoleId(roleId);

        return menuIds;
    }

    @Override
    public void roleContextMenu(RoleMenuVO roleMenuVO) {
        //1.在新家菜单列表之前需要清空中间的关联关系
        roleMapper.deleteRoleContextMenuByRoleId(roleMenuVO.getRoleId());

        Role_menu_relation roleMenuRelation = new Role_menu_relation();
        Date date = new Date();
        roleMenuRelation.setCreatedTime(date);
        roleMenuRelation.setUpdatedTime(date);
        roleMenuRelation.setRoleId(roleMenuVO.getRoleId());
        roleMenuRelation.setCreatedBy("system");
        roleMenuRelation.setUpdatedby("system");
        //2.为角色分配菜单
        for (Integer menuId : roleMenuVO.getMenuIdList()) {
            //调用dao层
            roleMenuRelation.setMenuId(menuId);
            roleMapper.RoleContextMenu(roleMenuRelation);
        }
    }

    @Override
    public void deleteRole(Integer id) {
        //1.删除中间表
        roleMapper.deleteRoleContextMenuByRoleId(id);
        //2.删除角色信息
        roleMapper.deleteRole(id);
    }
}
