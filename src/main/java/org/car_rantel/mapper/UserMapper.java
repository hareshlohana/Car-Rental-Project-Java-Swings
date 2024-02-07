package org.car_rantel.mapper;

import org.car_rantel.domain.Customer;
import org.car_rantel.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMapper implements Imapper<User>{

    private static String ID = "id";
    private static String USERNAME = "username";
    private static String PASSWORD = "pass";
    @Override
    public List<User> resultSetToList(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    public User resultSetToObject(ResultSet rs) throws SQLException {
        if (rs.next()){
            return User.builder()
                    .id((int) rs.getInt(ID))
                    .username(rs.getString(USERNAME))
                    .password(rs.getString(PASSWORD))
                    .build();
        }
        return null;
    }
}
