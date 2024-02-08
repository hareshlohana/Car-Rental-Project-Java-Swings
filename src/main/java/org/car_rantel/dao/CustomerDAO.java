package org.car_rantel.dao;

import org.car_rantel.domain.Customer;
import org.car_rantel.mapper.CustomerMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.car_rantel.dao.SqlQueryConstant.*;

public class CustomerDAO extends BaseDAO implements ICrud<Customer>{

    private static final CustomerMapper customerMapper = new CustomerMapper();

    @Override
    public void insert(Customer obj) {

        try {
            PreparedStatement ps = conn.prepareStatement(INSERT_INTO_CUSTOMER);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getContact());
            ps.setString(3, obj.getCnic());
            ps.setString(4, obj.getAddress());
            ps.setString(5, obj.getRef_number());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> getAll() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(Get_All_CUSTOMER);
            return customerMapper.resultSetToList(rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer getById(Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement(Get_CUSTOMER_BY_ID);
            ps.setInt(1, id.intValue());
            ResultSet rs = ps.executeQuery();
            return customerMapper.resultSetToObject(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getByName(String name) {
        try {
            PreparedStatement ps = conn.prepareStatement("select * from customer where c_name like '%"+name+"%'");
            ResultSet rs = ps.executeQuery();
            return customerMapper.resultSetToList(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Customer obj, Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE_CUSTOMER_BY_ID);
            ps.setString(1,obj.getName());
            ps.setInt(2,id.intValue());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> deleteByID(Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement(DELETE_CUSTOMER_BY_ID);
            ps.setInt(1,id.intValue());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public static void deleteByIndex(Integer index) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM customer where id ="+index+"");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Customer getByIndex(Integer index) {
        try {
            PreparedStatement ps = conn.prepareStatement("WITH IndexedRows AS (SELECT *, ROW_NUMBER() OVER (ORDER BY id) AS row_num FROM customer) SELECT * FROM IndexedRows WHERE row_num = "+index+"");
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
