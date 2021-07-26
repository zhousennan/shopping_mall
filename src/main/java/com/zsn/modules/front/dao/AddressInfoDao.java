package com.zsn.modules.front.dao;

import com.zsn.modules.front.entity.AddressInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AddressInfoDao {

    @Select("select * from address_info where user_name=#{userName} ")
    List<AddressInfo> getAddressByUser(String userName);

    @Insert("insert into address_info (address,user_name,status,tel_phone,receiver_name) values" +
            " (#{address},#{userName},#{status},#{telPhone},#{receiverName})")
    void insertAddress(AddressInfo addressInfo);

    @Select("select * from address_info where user_name=#{userName}")
    List<AddressInfo> getAddress(String userName);

    @Delete("DELETE from address_info where address_id=#{id}")
    void deletedAddress(int id);
}
