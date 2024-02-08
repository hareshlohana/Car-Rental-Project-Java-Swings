package org.car_rantel.service;

import org.car_rantel.dao.CustomerDAO;
import org.car_rantel.dao.VehicleDAO;
import org.car_rantel.domain.Customer;
import org.car_rantel.domain.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.car_rantel.dao.SqlQueryConstant.Get_All_VEHICLE;

public class VehicleService {
    VehicleDAO dao = new VehicleDAO();


    public String[][] searchByName(String name){

        List<Vehicle> vehicleList = dao.getByName(name);
        String[][] data = new String[vehicleList.size()][5];
        return transformToJTable(vehicleList, 5);
    }
    public String[][] getAllVehicleForJTable(){

        List<Vehicle> vehicleList = dao.getAll();
        String[][] data = new String[vehicleList.size()][5];

        for (int i = 0; i < vehicleList.size(); i++) {
            data[i][0] = vehicleList.get(i).getV_name();
            data[i][1] = vehicleList.get(i).getModel();
            data[i][2] = vehicleList.get(i).getBrand();
            data[i][3] = vehicleList.get(i).getColor();
            data[i][4] = String.valueOf(vehicleList.get(i).getOwner_id());
        }
        System.out.println(data);
        return data;
    }

    public String[][] transformToJTable(List<Vehicle> vehicleList, int columnsize){
        String[][] data = new String[vehicleList.size()][5];

        for (int i = 0; i < vehicleList.size(); i++) {
            data[i][0] = vehicleList.get(i).getV_name();
            data[i][1] = vehicleList.get(i).getModel();
            data[i][2] = vehicleList.get(i).getBrand();
            data[i][3] = vehicleList.get(i).getColor();
            data[i][4] = String.valueOf(vehicleList.get(i).getOwner_id());
        }
        return data;
    }

    public void save(String name, String model, String brand, String color, String owner_id) {
        Vehicle vehicle = Vehicle.builder()
                .v_name(name)
                .model(model)
                .brand(brand)
                .color(color)
                .owner_id(Long.valueOf(owner_id))
                .build();

        dao.insert(vehicle);
    }

}
