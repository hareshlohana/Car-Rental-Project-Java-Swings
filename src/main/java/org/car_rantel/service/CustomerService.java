package org.car_rantel.service;

import org.car_rantel.dao.CustomerDAO;
import org.car_rantel.dao.ICrud;
import org.car_rantel.domain.Customer;

import java.util.List;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class CustomerService {

    CustomerDAO dao = new CustomerDAO();


    public String[][] searchByName(String name){

        List<Customer> customerList = dao.getByName(name);
        String[][] data = new String[customerList.size()][5];
        return transformToJTable(customerList, 5);
    }

    public String[][] getAllCustomerForJTable(){

        List<Customer> customerList = dao.getAll();
        String[][] data = new String[customerList.size()][5];

        for (int i = 0; i < customerList.size(); i++) {
            data[i][0] = customerList.get(i).getName();
            data[i][1] = customerList.get(i).getContact();
            data[i][2] = customerList.get(i).getCnic();
            data[i][3] = customerList.get(i).getAddress();
            data[i][4] = customerList.get(i).getRef_number();
        }
        System.out.println(data);
        return data;
    }

    public String[][] transformToJTable(List<Customer> customerList, int columnsize){
        String[][] data = new String[customerList.size()][5];

        for (int i = 0; i < customerList.size(); i++) {
            data[i][0] = customerList.get(i).getName();
            data[i][1] = customerList.get(i).getContact();
            data[i][2] = customerList.get(i).getCnic();
            data[i][3] = customerList.get(i).getAddress();
            data[i][4] = customerList.get(i).getRef_number();
        }
        return data;
    }

    public void save(String name, String number, String cnic, String address, String ref_number) {
        try {
            Customer customer = Customer.builder()
                    .name(name)
                    .contact(number)
                    .cnic(cnic)
                    .address(address)
                    .ref_number(ref_number)
                    .build();

            dao.insert(customer);
        } catch (Exception ex) {
            throw new RuntimeException("Unable to save customer.", ex);
        }
    }

    public void updateCustomer(Integer index, String name, String contact, String cnic, String address, String ref_number) {
        try {
            Customer customer = dao.getByIndex(index);
            customer.setName(name);
            customer.setContact(contact);
            customer.setCnic(cnic);
            customer.setAddress(address);
            customer.setRef_number(ref_number);

            dao.update(customer, index);
        } catch (Exception ex) {
            throw new RuntimeException("Unable to update customer.", ex);
        }
    }

    public void deleteCustomer(Long id) {
        try {
            dao.deleteByID(id);
        } catch (Exception ex) {
            throw new RuntimeException("Unable to delete customer.", ex);
        }
    }
}
