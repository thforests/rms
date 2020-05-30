package com.dao;

import com.bean.User;

import java.util.List;

public interface IUserDao {

    /**
     * 检查登录
     *
     * @param name
     * @param password
     * @return
     */
    public User isLogin(String name, String password);

    /**
     * 查询所有数据
     *
     * @return
     */
    public List<User> selectAllUser();

    /**
     * 查找当前登录用户信息
     */
    public User getOne(String name);

    /**
     * 删除
     */
    public int deleteUser(int id);


    /**
     * 修改前
     */
    public User updateSelect(int userId);

    /**
     * 修改后查询
     */
    public int updateUser(Object... emps);

    /**
     * 添加
     */
    public int addUser(User user);

    /**
     * 修改密码
     */
    public int updatePwd(String newpassword,String password,String name);


}