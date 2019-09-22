package com.springboot.learnSpringboot.transactional.manual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author: zhenghailong
 * @date: 2019/9/22 17:24
 * @modified By:
 * @description:
 */
@Service
public class JdbcServiceImpl implements JdbcService{

    @Autowired
    private DataSource dataSource;

    @Override
    public int insertUser(String username, String note) {
        Connection connection = null;
        int result = 0;
        try {
            // 获取链接
            connection = dataSource.getConnection();
            // 开启事物
            connection.setAutoCommit(false);
            // 设置事物隔离级别
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            // 执行SQL
            PreparedStatement preparedStatement = connection.prepareStatement("insert into t_user(user_name,note) values (?,?)");

            preparedStatement.setString(1,username);
            preparedStatement.setString(2,note);
            result = preparedStatement.executeUpdate();
            // 提交事物
            connection.commit();
        } catch (Exception e) {
            if(connection != null){
                try {
                    // 回滚事物
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
