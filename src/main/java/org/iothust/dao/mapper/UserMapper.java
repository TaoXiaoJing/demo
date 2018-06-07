package org.iothust.dao.mapper;

import org.apache.ibatis.annotations.Select;
import org.iothust.dao.entity.User;

import java.util.List;

public interface UserMapper {
    @Select("select * from t_user order by userid ")
    List<User> selectUsers();

    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /*通过用户名和密码查找用户*/
    User getUserByUserName(String username,String password);
}