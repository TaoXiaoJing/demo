package org.iothust.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.iothust.dao.entity.User;
import org.iothust.dao.mapper.UserMapper;
import org.iothust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by weilong on 2018/06/02.
 **/
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserMapper userMapper;


    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    /*
     * pageNum:开始页数
     * pageSize:每页显示的数据条数
     * */
    @Override
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现分页
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectUsers();
        PageInfo result = new PageInfo(users);
        return result;
    }

    @Override
    public User getUserByUserName(String username,String password) {
        return userMapper.getUserByUserName(username,password);
    }

}
