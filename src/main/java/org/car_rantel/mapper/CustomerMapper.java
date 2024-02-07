package org.car_rantel.mapper;

import lombok.SneakyThrows;
import org.car_rantel.domain.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper implements Imapper<Customer> {

    private static String ID = "id";
    private static String NAME = "c_name";
    private static String CONTACT = "c_number";
    private static String CNIC = "cnic";
    private static String ADDRESS = "address";
    private static String REF_NUMBER = "ref_number";
    @Override
    public List<Customer> resultSetToList(ResultSet rs) throws SQLException {
        List<Customer> customerList = new ArrayList<Customer>();
        while (rs.next()){
            Customer customer = Customer.builder()
                    .id((long) rs.getInt(ID))
                    .name(rs.getString(NAME))
                    .contact(rs.getString(CONTACT))
                    .cnic(rs.getString(CNIC))
                    .address(rs.getString(ADDRESS))
                    .ref_number(rs.getString(REF_NUMBER))
                    .build();
            customerList.add(customer);
        }
        return customerList;
    }

    @SneakyThrows
    @Override
    public Customer resultSetToObject(ResultSet rs) {
        if (rs.next()){
            return Customer.builder()
                    .id((long) rs.getInt(ID))
                    .name(rs.getString(NAME))
                    .contact(rs.getString(CONTACT))
                    .cnic(rs.getString(CNIC))
                    .address(rs.getString(ADDRESS))
                    .ref_number(rs.getString(REF_NUMBER))
                    .build();
        }
        return null;
    }
}
