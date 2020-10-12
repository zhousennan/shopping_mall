package com.zsn.modules.account.dao;

import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserInfoDao {
    @Select("<script>" +
            "select * from user_info "
            + "<where> "
            + "<if test='keyWord != \"\" and keyWord != null'>"
            + " and (user_name like '%${keyWord}%') "
            + "</if>"
            + "</where>"
            + "<choose>"
            + "<when test='orderBy != \"\" and orderBy != null'>"
            + " order by ${orderBy} ${sort}"
            + "</when>"
            + "<otherwise>"
            + " order by user_id desc"
            + "</otherwise>"
            + "</choose>"
            + "</script>")
    List<UserInfo> getUserInfoList(SearchVo searchVo);

    @Insert("insert into user_info (user_name,nick_name,real_name," +
            "birthday,tel_phone,email,address,grade,password) values (#{userName},#{nickName}," +
            "#{realName},#{birthday},#{telPhone},#{email},#{address},#{grade},#{password})")
    void insertUserInfo(UserInfo userInfo);

    @Delete("delete from user_info where user_id = #{userId}")
    void deleteUserInfo(int userId);

    @Update("update user_info set nick_name=#{nickName} where user_id=#{userId}")
    void updateUserInfo(UserInfo userInfo);

    @Select("select * from user_info where user_name=#{userName} ")
    UserInfo getUserByUserName(String userName);

    @Select("select * from user_info where user_id=#{userId}")
    UserInfo getUserInfoByUserId(int userId);

    @Select("select * from user_info where user_name=#{userName}")
    UserInfo getUserInfoByUserName(String userName);

    @Select("select grade  ,COUNT(*) as gradeCount from user_info GROUP BY grade")
    List<UserInfo> getUserGradData();

    @Delete("delete from user_role where user_id=#{userId}")
    void deletedUserRoleByUserId(int userId);
}
