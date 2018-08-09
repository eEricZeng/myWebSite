package site.zengguang.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.zengguang.home.dao.UserMapper;
import site.zengguang.home.data.User;
import site.zengguang.home.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired  
    private UserMapper userMapper;  

    public User selectUserById(Integer userId) {  
        return userMapper.selectUserById(userId);  
    }  
}
