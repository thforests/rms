package com.dao.impl;

import com.bean.User;
import com.dao.IUserDao;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {


    /**
     * 判断登录
     * @param name
     * @param password
     * @return
     */
    @Override
    public User isLogin(String name, String password) {
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        //1、实体对象
        User user = null;
        //2、连接数据库
        Connection conn = DBUtil.getConn();
        //3、连接数据库对象，返回执行SQL语句对象
        String sql = "select * from user where name=? and password=?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setObject(1,name);
            statement.setObject(2,password);
            //查询结果
            resultSet = statement.executeQuery();
            if (resultSet != null){
                if (resultSet.next()){
                    user = new User();
                    //拿到id对应的用户名
                    String username = resultSet.getString(2);
                    System.out.println("id对应的name："+username);
                    user.setName(username);
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeDB(resultSet,statement,conn);
        }
        return null;
    }

    /**
     * 查询所有数据
     */
    @Override
    public List<User> selectAllUser() {
        ResultSet resultSet =null;
        PreparedStatement statement =null;
        List<User> users = new ArrayList<>();
        User user = null;
        Connection conn = DBUtil.getConn();
        String sql = "SELECT * FROM USER";
        try {
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet != null){
                while (resultSet.next()){
                    user = new User();
                    int userid = resultSet.getInt(1);
                    String username = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    int type = resultSet.getInt(4);
                    String tell = resultSet.getString(5);

                    user.setId(userid);
                    user.setName(username);
                    user.setPassword(password);
                    user.setType(type);
                    user.setTell(tell);

                    System.out.println(user);

                    users.add(user);
                }
                return users;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeDB(resultSet,statement,conn);
        }
        return null;
    }

    /**
     * 获取当前登录用户信息
     */
    @Override
    public User getOne(String name) {
        ResultSet resultSet =null;
        PreparedStatement statement =null;
        User one = null;
        Connection conn = DBUtil.getConn();
        String sql = "select * from user where name = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setObject(1,name);
            resultSet = statement.executeQuery();
            if (resultSet != null){
                while (resultSet.next()){
                    one = new User();
                    int userid = resultSet.getInt(1);
                    String username = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    int type = resultSet.getInt(4);
                    String tell = resultSet.getString(5);

                    one.setId(userid);
                    one.setName(username);
                    one.setPassword(password);
                    one.setType(type);
                    one.setTell(tell);
                }
                return one;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeDB(resultSet,statement,conn);
        }
        return null;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public int deleteUser(int id) {
        int num = 0;
        PreparedStatement statement = null;
        Connection conn = DBUtil.getConn();
        String sql = "DELETE FROM USER WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setObject(1,id);
            num = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeDB(null,statement,conn);
        }
        return num;
    }


    /**
     * 修改
     */
    @Override
    public User updateSelect(int userId) {
        ResultSet resultSet =null;
        PreparedStatement statement =null;
        User user = null;
        Connection conn = DBUtil.getConn();
        String sql = "SELECT * FROM USER WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setObject(1,userId);
            resultSet = statement.executeQuery();
            if (resultSet != null){
                if (resultSet.next()){
                    user = new User();
                    int userid = resultSet.getInt(1);
                    String username = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    int type = resultSet.getInt(4);
                    String tell = resultSet.getString(5);

                    user.setId(userid);
                    user.setName(username);
                    user.setPassword(password);
                    user.setType(type);
                    user.setTell(tell);

                }
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeDB(resultSet,statement,conn);
        }
        return null;
    }

    @Override
    public int updateUser(Object... users) {
        int num = 0;
        PreparedStatement statement = null;
        Connection conn = DBUtil.getConn();
        String sql = "UPDATE USER SET NAME= ? ,TYPE= ?,tell=? WHERE id=?";
        try {
            statement = conn.prepareStatement(sql);
//            for (int i = 1;i<3;i++){
//                statement.setObject(i,users[i-1]);
//            }
            statement.setObject(1,users[0]);
            statement.setObject(2,users[1]);
            statement.setObject(3,users[2]);
            statement.setObject(4,users[3]);
            num = statement.executeUpdate();

            System.out.println("Dao:"+null);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeDB(null,statement,conn);
        }

        return num;
    }

    @Override
    public int addUser(User user) {
        int num = 0;
        PreparedStatement statement = null;
        Connection conn = DBUtil.getConn();
        String sql = "INSERT INTO USER (name,password,type,tell) VALUE(?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
//            statement.setObject(1,user.getId());
            statement.setObject(1,user.getName());
            statement.setObject(2,user.getPassword());
            statement.setObject(3,user.getType());
            statement.setObject(4,user.getTell());

            num = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeDB(null,statement,conn);
        }

        return num;
    }

    @Override
    public int updatePwd(String newpassword,String password,String name) {
        int num = 0;
        PreparedStatement statement = null;
        Connection conn = DBUtil.getConn();
        String sql = "UPDATE USER SET password= ? WHERE password=? and name=?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setObject(1,newpassword);
            statement.setObject(2,password);
            statement.setObject(3,name);
            num = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeDB(null,statement,conn);
        }
        return num;
    }
}
