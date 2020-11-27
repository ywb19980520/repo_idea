package com.imlty.controller;

import com.github.pagehelper.PageInfo;
import com.imlty.domain.ResponseResult;
import com.imlty.domain.Role;
import com.imlty.domain.User;
import com.imlty.service.UserService;
import com.imlty.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVO userVO){
        PageInfo<User> pageInfo = userService.findAllUserByPage(userVO);

        return new ResponseResult(true,200,"分页多条件成功",pageInfo);
    }

    /**
     * 用户登录校验
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {
        User checkLogin = userService.login(user);
        ResponseResult result = new ResponseResult(true, 400, "用户名或者密码错误", null);
        if (checkLogin != null){
            //1.保存用户id 以及用户的access_token到session中
            String access_token = UUID.randomUUID().toString();

            HttpSession session = request.getSession();
            session.setAttribute("user_id",checkLogin.getId());
            session.setAttribute("access_token",access_token);
            //2.将查询出来的信息相应给前台
            Map<String, Object> map = new HashMap<>();
            map.put("access_token",access_token);
            map.put("user_id",checkLogin.getId());
            result.setMessage("登陆成功");
            result.setContent(map);
        }
        return result;
    }

    /**
     * 根据用户id回显角色信息
     * @param id
     * @return
     */
    @RequestMapping("/findUserRoleById")
    public ResponseResult findUserRoleById(Integer id){
        List<Role> roleList = userService.findUserRelationRoleById(id);
        return new ResponseResult(true,200,"回显成功",roleList);
    }

    /**
     * 用户分配角色信息
     * @param userVO
     * @return
     */
    @RequestMapping("/userContextRole")
    public ResponseResult userContextRole(@RequestBody UserVO userVO){
        userService.userContextRole(userVO);
        return new ResponseResult(true,200,"分配角色成功",null);
    }

    /**
     * 获取用户权限信息
     * @param request
     * @return
     */
    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request){
        ResponseResult result = new ResponseResult(true, 200, "权限获取失败", null);
        //1.获取请求头中的token
        String token = request.getHeader("Authorization");

        //2.获取session中的access_token
        String access_token = (String) request.getSession().getAttribute("access_token");

        //3.判断
        if (token != null && token.equals(access_token)){
            //4.获取session中的用户id
            Integer user_id = (Integer) request.getSession().getAttribute("user_id");
            Map<String, Object> map = userService.getUserPermissions(user_id);
            result.setMessage("获取菜单信息成功");
            result.setContent(map);
        }
        return result;
    }
}
