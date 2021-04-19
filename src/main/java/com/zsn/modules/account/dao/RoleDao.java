package com.zsn.modules.account.dao;

import com.zsn.modules.account.entity.Role;
import com.zsn.modules.account.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface RoleDao {
    @Select("<script>" +
            "select * from role "
            + "<where>"
            + "<if test='keyWord != \"\" and keyWord != null'>"
            + " and (role_name like '%${keyWord}%') "
            + "</if>"
            + "</where>"
            + "<choose>"
            + "<when test='orderBy != \"\" and orderBy != null'>"
            + " order by ${orderBy} ${sort}"
            + "</when>"
            + "<otherwise>"
            + " order by role_id asc"
            + "</otherwise>"
            + "</choose>"
            + "</script>")
    List<Role> getRoleList();

    @Select("SELECT\n" +
            "user_info.user_id,\n" +
            "user_info.user_name,\n" +
            "user_info.nick_name,\n" +
            "user_info.real_name,\n" +
            "user_info.birthday,\n" +
            "user_info.tel_phone,\n" +
            "user_info.email,\n" +
            "user_info.address,\n" +
            "user_info.grade,\n" +
            "user_info.`password`,\n" +
            "user_info.sex,\n" +
            "role.role_name as adminName\n" +
            "FROM\n" +
            "user_info\n" +
            "INNER JOIN user_role ON user_role.user_id = user_info.user_id\n" +
            "INNER JOIN role ON role.role_id = user_role.role_id where role.role_name='管理员' or role.role_name='超级管理员'\n")
    List<UserInfo> getAdminList();

    @Insert("insert into user_info (user_name,real_name,birthday,tel_phone,email,password) values" +
            "(#{userName},#{realName},#{birthday},#{telPhone},#{email},#{password}) ")
    void insertAdmin(UserInfo userInfo);

    @Select("select * from role ")
    List<Role> getRoles();

    @Insert("insert into user_role (user_id,role_id) values (#{userId},#{roleId})")
    void insertRoleUser(int userId, Integer roleId);
}
