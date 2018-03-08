package com.longke.manager.project.entity.generator;

import javax.persistence.*;

@Table(name = "sys_role_resources")
public class SysRoleResources {
    @Id
    @Column(name = "roleId")
    private Integer roleid;

    @Id
    @Column(name = "resourcesId")
    private Integer resourcesid;

    /**
     * @return roleId
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * @return resourcesId
     */
    public Integer getResourcesid() {
        return resourcesid;
    }

    /**
     * @param resourcesid
     */
    public void setResourcesid(Integer resourcesid) {
        this.resourcesid = resourcesid;
    }
}