package site.zengguang.home.dao;

import site.zengguang.home.data.User;

public interface UserMapper {

    /**
     * @param userId
     * @return User
     */
    public User selectUserById(Integer userId);
}
