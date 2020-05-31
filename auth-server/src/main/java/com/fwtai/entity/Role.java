package com.fwtai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 用户角色信息，有角色 id、角色名称（英文、中文），@Entity 表示这是一个实体类
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2020-05-31 20:25
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@Entity(name = "t_role")
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nameZh;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getNameZh(){
        return nameZh;
    }

    public void setNameZh(String nameZh){
        this.nameZh = nameZh;
    }

    @Override
    public String toString(){
        return "Role{" + "id=" + id + ", name='" + name + '\'' + ", nameZh='" + nameZh + '\'' + '}';
    }
}