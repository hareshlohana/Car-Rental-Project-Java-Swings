package org.car_rantel.dao;

import org.car_rantel.domain.Customer;
import org.car_rantel.domain.User;
import org.car_rantel.mapper.UserMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.car_rantel.dao.SqlQueryConstant.*;

public class UserDAO extends BaseDAO implements ICrud<User>{

    private final UserMapper userMapper = new UserMapper();

    public User getUserByUsernameAndPassword(String name, String password){
        try {
            PreparedStatement ps = conn.prepareStatement(Get_USER_BY_USERNAME_AND_PASSWORD);
            ps.setString(1,name);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();
            return userMapper.resultSetToObject(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void insert(User obj) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public void update(User obj,Integer index) {

    }

    @Override
    public List<Customer> deleteByID(Long id) {

        return null;
    }
}
