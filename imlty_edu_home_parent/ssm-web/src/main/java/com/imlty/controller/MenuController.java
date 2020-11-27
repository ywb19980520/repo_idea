package com.imlty.controller;

import com.imlty.domain.Menu;
import com.imlty.domain.ResponseResult;
import com.imlty.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询所有菜单信息
     * @return
     */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){
        List<Menu> list = menuService.findAllMenu();

        return new ResponseResult(true,200,"查询所有菜单信息成功",list);
    }
    /**
     * 回显菜单信息
     */
    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(Integer id){
        //判断当前是更新还是新增操作  -1:新增
        ResponseResult result = new ResponseResult(true,200,null,null);
        Map<String, Object> map = new HashMap<>();
        List<Menu> menuList = menuService.findSubMenuListByPid(-1);//查询所有主菜单信息
        if (id == -1){
            //添加回显操作
            map.put("menuInfo",null);
            map.put("parentMenuList",menuList);
            result.setMessage("添加回显成功");
        }else {
            //修改的回显
            Menu menu = menuService.findMenuById(id);//这是显示的菜单信息
            map.put("menuInfo",menu);
            map.put("parentMenuList",menuList);
            result.setMessage("修改回显成功");
        }
        System.out.println(map);
        result.setContent(map);
        return result;
    }
}
