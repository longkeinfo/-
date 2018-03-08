package com.longke.manager.project.entity.generator;

import javax.persistence.*;

@Table(name = "sys_role")
public class SysRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "roleDesc")
    private String roledesc;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return roleDesc
     */
    public String getRoledesc() {
        return roledesc;
    }

    /**
     * @param roledesc
     */
    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }
}