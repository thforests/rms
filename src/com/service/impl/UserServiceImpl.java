package com.service.impl;

import com.bean.User;
import com.dao.IUserDao;
import com.dao.impl.UserDaoImpl;
import com.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {

    //关联Dao层
    IUserDao userDao = new UserDaoImpl();


    @Override
    public User isLogin(String name, String password) {
        User user = userDao.isLogin(name,password);
        if (user != null){
            return  user;
        }
        return null;
    }

    @Override
    public List<User> selectAll() {
        List<User> users = userDao.selectAllUser();
        if (users != null){
            return users;
        }
        return null;
    }

    @Override
    public User getOneMessage(String name) {
        User one = userDao.getOne(name);
        if (one != null){
            return one;
        }
        return null;
    }

    @Override
    public int deleteUser(int id) {
        int i = userDao.deleteUser(id);
        //删除成功
        if (i == 1){
            return 1;
        }
        return 0;
    }

    @Override
    public User updateUser(int userId) {
        User user = userDao.updateSelect(userId);
        if (user != null){
            return user;
        }
        return null;
    }

    @Override
    public int updateOneUser(Object... users) {
        int i = userDao.updateUser(users);
        if (i!=0){
            return i;
        }
        return 0;
    }

    @Override
    public int addUser(User user) {
        if (user != null){
            int num = userDao.addUser(user);
            return num;
        }
        return 0;
    }

    @Override
    public int updatePwd(String newpassword,String password,String name) {
        int i = userDao.updatePwd(newpassword,password,name);
        if (i!=0){
            return i;
        }
        return 0;
    }
}
