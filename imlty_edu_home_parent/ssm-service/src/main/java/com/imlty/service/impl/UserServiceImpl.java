package com.imlty.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imlty.dao.UserMapper;
import com.imlty.domain.*;
import com.imlty.service.UserService;
import com.imlty.utils.MD5Utils;
import com.imlty.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> findAllUserByPage(UserVO userVO) {
        //在调用查询之前调用分页
        PageHelper.startPage(userVO.getCurrentPage(),userVO.getPageSize());
        //查询
        List<User> userList = userMapper.findAllUserByPage(userVO);
        //通过PageInfo的有参注入 获得一个PageInfo对象
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    /**
     * 用户登录信息
     * @param user
     * @return
     */
    @Override
    public User login(User user) throws Exception {
        //1.调用mapper方法获取数据库中信息,如果查询出来了 包含了密文密码
        User login = userMapper.login(user);
        if (login != null && MD5Utils.verify(user.getPassword(),MD5Utils.md5key,login.getPassword())){
            //数据库中有数据,并且校验成功
            return login;
        }
        return null;
    }

    @Override
    public List<Role> findUserRelationRoleById(Integer id) {
        return userMapper.findUserRelationRoleById(id);
    }

    @Override
    public void userContextRole(UserVO userVo) {
        //1.清空用户角色关系
        userMapper.deleteUserContextRole(userVo.getUserId());

        //2.添加用户角色关系
        //补全信息
        User_Role_relation userRoleRelation = new User_Role_relation();
        userRoleRelation.setUserId(userVo.getUserId());
        Date date = new Date();
        userRoleRelation.setCreatedTime(date);
        userRoleRelation.setUpdatedTime(date);
        userRoleRelation.setCreatedBy("system");
        userRoleRelation.setUpdatedby("system");
        //建立中间关系
        for (Integer roleId : userVo.getRoleIdList()) {
            userRoleRelation.setRoleId(roleId);
            userMapper.userContextRole(userRoleRelation);
        }
    }

    /**
     * 根据用户id 获取权限信息
     * @param userId 用户id
     * @return
     */
    @Override
    public Map<String, Object> getUserPermissions(Integer userId) {
        Map<String, Object> map = new HashMap<>();

        //1.获取用户的角色信息
        List<Role> roleList = userMapper.findUserRelationRoleById(userId);
        //增加判断查询出的角色信息是否为空(为空默认设置为普通用户)
        if (roleList.size() == 0){
            return null;
        }
        //1.2 获取一个角色id集合
        ArrayList<Integer> roleIds = new ArrayList<>();
        for (Role role : roleList) {
            roleIds.add(role.getId());
        }
        //2.根据角色id查询父级菜单
        List<Menu> parentMenu = userMapper.findParentMenuByRoleId(roleIds);

        //3.根据父菜单id查询子菜单,并分装到对应实体类里面的subMenuList中
        for (Menu menu : parentMenu) {
            List<Menu> subMenuList = userMapper.findSubMenuByPid(menu.getId());
            menu.setSubMenuList(subMenuList);
        }

        //4.获取资源信息
        List<Resource> resourceList = userMapper.findResourceByRoleId(roleIds);

        //5.分装到map集合并返回
        map.put("menuList",parentMenu);
        map.put("resourceList",resourceList);
        return map;
    }
}
