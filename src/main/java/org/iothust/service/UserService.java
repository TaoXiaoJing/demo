package org.iothust.service;

import com.github.pagehelper.PageInfo;
import org.iothust.dao.entity.User;

/**
 * Create by weilong on 2018/06/02.
 **/
public interface UserService {
    int addUser(User user);
    PageInfo<User> findAllUser(int pageNum, int pageSize);

    /*通过用户名和密码查找用户*/
    User getUserByUserName(String username,String password);
}
