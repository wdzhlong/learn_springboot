package com.springboot.learnSpringboot.dataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author: zhenghailong
 * @date: 2019/9/22 10:29
 * @modified By:
 * @description:
 */
@Service
public class JdbcTemplateServiceImpl implements JdbcTemplateService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> getUserMapper(){
        RowMapper<User> rowMapper = (ResultSet rs, int rownum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("user_name"));
            user.setSex(rs.getInt("sex"));
            user.setNote(rs.getString("note"));
            return user;
        };
        return rowMapper;
    }

    @Override
    public User getUser(Long id) {
        String sql = "select id,user_name,sex,note from t_user where id = ?";
        Object[] params = new Object[]{id};
        User user = jdbcTemplate.queryForObject(sql,params,getUserMapper());
        return user;
    }

    @Override
    public List<User> findUsers(String username, String note) {
        return null;
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into t_user(user_name,sex,note) values (?,?,?)";
        return jdbcTemplate.update(sql,user.getUserName(),user.getSex(),user.getNote(),user.getId());
    }

    @Override
    public int updateUser(User user) {
        String sql = "update t_user set user_name = ?,sex = ?,note = ? where id = ?";
        return jdbcTemplate.update(sql,user.getUserName(),user.getSex(),user.getNote(),user.getId());
    }

    @Override
    public int deleteUser(Long id) {
        String sql = "delete from t_user where id = ?";
        return jdbcTemplate.update(sql,id);
    }
}
