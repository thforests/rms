package com.service;

import com.bean.User;

import java.util.List;

public interface IUserService {

    /**
     * 判断登录
     * @param name
     * @param password
     * @return
     */
    public User isLogin(String name,String password);

    /**
     * 查询所有
     * @return
     */
    public List<User> selectAll();

    /**
     * 获取登录者信息
     */
    public User getOneMessage(String name);

    /**
     * 删除
     */
    public int deleteUser(int id);

    /**
     * 更新前数据查询
     */
    public User updateUser(int userId);

    /**
     * 更新后数据
     */
    public int updateOneUser(Object... users);

    /**
     * 添加数据
     */
    public int addUser(User user);

    /*
    * 修改密码
    * */
    public int updatePwd(String newpassword,String password,String name);
}
