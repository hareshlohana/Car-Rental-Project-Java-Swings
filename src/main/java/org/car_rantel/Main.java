package org.car_rantel;

import org.car_rantel.UI.CustomerPanelUI;
import org.car_rantel.UI.HomeUI;
import org.car_rantel.UI.LoginUI;
import org.car_rantel.dao.CustomerDAO;
import org.car_rantel.domain.Customer;
import org.car_rantel.mapper.CustomerMapper;
import org.car_rantel.service.CustomerService;

public class Main {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
//        customerDAO.getAll().forEach(System.out::println);
//        =========================================================
//        Customer newCus = Customer.builder()
//                .name("Bilal")
//                .contact("03456789035")
//                .cnic("43305-4567893-6")
//                .address("Johar")
//                .ref_number("03334567892")
//                .build();
//        customerDAO.insert(newCus);
//        customerDAO.getAll().forEach(System.out::println);

//        Customer customer = customerDAO.getById(2L);
//        customer.setName("Jamil");
//        customerDAO.update(customer, 2L);
//        System.out.println(customerDAO.getById(2L));
//        customerDAO.deleteByID(5L);
//        System.out.println(customerDAO.getAll());

//        LoginUI loginUI = new LoginUI();
        new HomeUI();

    }
}