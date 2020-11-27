package com.imlty.service.impl;

import com.imlty.dao.MenuMapper;
import com.imlty.domain.Menu;
import com.imlty.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findSubMenuListByPid(Integer pid) {
        return menuMapper.findSubMenuListByPid(pid);
    }

    @Override
    public List<Menu> findAllMenu() {
       return menuMapper.findAllMenu();
    }

    @Override
    public Menu findMenuById(Integer id) {
        return menuMapper.findMenuById(id);
    }
}
