package org.car_rantel.service;

import org.car_rantel.dao.VehicleDAO;
import org.car_rantel.dao.Vehicle_OwnerDAO;
import org.car_rantel.domain.Vehicle;
import org.car_rantel.domain.Vehicle_Owner;

import java.util.List;

public class VehicleOwnerService {
    Vehicle_OwnerDAO dao = new Vehicle_OwnerDAO();


    public String[][] searchByName(String name){

        List<Vehicle_Owner> vehicleOwnerList = dao.getByName(name);
        String[][] data = new String[vehicleOwnerList.size()][5];
        return transformToJTable(vehicleOwnerList, 5);
    }
    public String[][] getAllVehicleOwnerForJTable(){

        List<Vehicle_Owner> vehicleOwnerList = dao.getAll();
        String[][] data = new String[vehicleOwnerList.size()][5];

        for (int i = 0; i < vehicleOwnerList.size(); i++) {
            data[i][0] = vehicleOwnerList.get(i).getOwner_name();
            data[i][1] = vehicleOwnerList.get(i).getOwner_number();
            data[i][2] = vehicleOwnerList.get(i).getCnic();
            data[i][3] = vehicleOwnerList.get(i).getAddress();
            data[i][4] = String.valueOf(vehicleOwnerList.get(i).getCommission());
        }
        System.out.println(data);
        return data;
    }

    public String[][] transformToJTable(List<Vehicle_Owner> vehicleOwnerList, int columnsize){
        String[][] data = new String[vehicleOwnerList.size()][5];

        for (int i = 0; i < vehicleOwnerList.size(); i++) {
            data[i][0] = vehicleOwnerList.get(i).getOwner_name();
            data[i][1] = vehicleOwnerList.get(i).getOwner_number();
            data[i][2] = vehicleOwnerList.get(i).getCnic();
            data[i][3] = vehicleOwnerList.get(i).getAddress();
            data[i][4] = String.valueOf(vehicleOwnerList.get(i).getCommission());
        }
        return data;
    }

    public void save(String name, String number, String cnic, String address, String commission) {
        Vehicle_Owner vehicle_owner = Vehicle_Owner.builder()
                .owner_name(name)
                .owner_number(number)
                .cnic(cnic)
                .address(address)
                .commission(Float.valueOf(commission))
                .build();

        dao.insert(vehicle_owner);
    }
}
