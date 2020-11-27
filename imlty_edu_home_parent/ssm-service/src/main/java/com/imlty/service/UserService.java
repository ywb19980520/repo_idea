package com.imlty.service;

import com.github.pagehelper.PageInfo;
import com.imlty.domain.Role;
import com.imlty.domain.User;
import com.imlty.vo.UserVO;

import java.util.List;
import java.util.Map;

public interface UserService {
    /*
        查询所有用户
    */
    PageInfo<User> findAllUserByPage(UserVO userVO);
    /**
     * 用户登录(根据用户名查询用户具体的用户信息)
     * @param user
     * @return
     */
    User login(User user) throws Exception;
    /**
     * 根据用户id 查询用户关联的角色信息
     * @param id
     * @return
     */
    List<Role> findUserRelationRoleById(Integer id);

    /**
     * 给用户添加角色信息
     * @param userVo
     */
    void userContextRole(UserVO userVo);

    /**
     * 获取用户权限  进行菜单的动态展示
     */
    Map<String,Object> getUserPermissions(Integer userId);
}
