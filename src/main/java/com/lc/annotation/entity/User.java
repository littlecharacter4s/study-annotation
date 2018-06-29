package com.lc.annotation.entity;

import com.lc.annotation.custom.NotNull;
import com.lc.annotation.custom.NotZero;

import java.util.Date;

public class User {
    @NotNull(describe = "主键ID不可为空")
    private Long id;
    @NotZero(describe = "用户ID不可为零")
    private Long uid;
    @NotNull(describe = "用户名不可为空")
    private String name;
    @NotNull(describe = "出生日不可为空")
    private Date birthday;
    @NotNull(describe = "用户钱不可为空")
    @NotZero(describe = "用户钱不可为零")
    private Double money;
    @NotNull(describe = "创建点不可为空")
    private Date createTime;
    @NotNull(describe = "修改点不可为空")
    private Date updateTime;
    @NotNull(describe = "版本号不可为空")
    @NotZero(describe = "版本号不可为零")
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", money=" + money +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", version=" + version +
                '}';
    }
}
