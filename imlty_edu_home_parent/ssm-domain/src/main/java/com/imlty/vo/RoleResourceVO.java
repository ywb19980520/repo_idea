package com.imlty.vo;

import java.util.List;

/**
 * 角色资源VO类
 */
public class RoleResourceVO {
    //角色id
    private Integer RoleId;
    //资源的id 列表
    private List<Integer> resourceIdList;

    public Integer getRoleId() {
        return RoleId;
    }

    public void setRoleId(Integer roleId) {
        RoleId = roleId;
    }

    public List<Integer> getResourceIdList() {
        return resourceIdList;
    }

    public void setResourceIdList(List<Integer> resourceIdList) {
        this.resourceIdList = resourceIdList;
    }
}
