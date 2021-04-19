package com.zsn.modules.account.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * (UserInfo)实体类
 *
 * @author makejava
 * @since 2020-09-04 18:24:50
 */

public class UserInfo implements Serializable {
    private static final long serialVersionUID = -20376731440307299L;
    private boolean rememberMe;
    private Integer userId;

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    /**
     * 用户名，登录时需要用的
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 真实姓名，别人不可见
     */
    private String realName;

    private String birthday;

    private String telPhone;

    private String email;
    /**
     * 默认收货地址
     */
    private String address;
    /**
     * 会员等级
     */
    private String grade;

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    private int gradeCount;

    public int getGradeCount() {
        return gradeCount;
    }

    private String adminName;

    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }


    public void setGradeCount(int gradeCount) {
        this.gradeCount = gradeCount;
    }

    /**
     * 密码
     */
    private String password;

    private String sex;


    public Object getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}