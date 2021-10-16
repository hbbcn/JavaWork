package com.atguigu.dao;

import com.atguigu.pojo.User;

public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return 如果返回null, 说明用户名或密码错误，反之亦然
     */
    public User queryUserByUsernameAndPassword(String username,String password);


    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);

}
