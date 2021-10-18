package com.whynotyue.community.dao;

import com.whynotyue.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

// @Mapper：必须要，帮助 MyBatis 找到 Mapper。
// @Repository：可有可无，可以消去依赖注入时 idea 的报错信息。
@Repository
@Mapper
public interface UserMapper {

    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    // 返回插入行数
    int insertUser(User user);

    // 返回修改行数
    int updateStatus(int id,int status);

    int updateHeader(int id,String headerUrl);

    int updatePassword(int id,String password);

}
