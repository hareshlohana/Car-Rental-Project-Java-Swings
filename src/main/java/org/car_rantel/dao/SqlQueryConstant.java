package org.car_rantel.dao;

public class SqlQueryConstant {

    public final static String Get_USER_BY_USERNAME_AND_PASSWORD = "select * from user where name = ? and pass = ?";

//    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public final static String Get_All_CUSTOMER = "select * from customer";
    public final static String Get_CUSTOMER_BY_ID = "select * from customer where id = ?";
//    public final static String Get_CUSTOMER_BY_NAME = "select * from customer where c_name like = '%"+name+"%'";
    public final static String UPDATE_CUSTOMER = "";
    public final static String DELETE_CUSTOMER_BY_ID = "delete from customer where id = ?";
    public final static String INSERT_INTO_CUSTOMER =
            "insert into customer (c_name, c_number,cnic,address,ref_number)" +
            "values (?,?,?,?,?) ";

//    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public final static String Get_All_VEHICLE = "select * from vehicle";
    public final static String Get_VEHICLE_BY_ID = "select * from vehicle where id = ?";
    public final static String UPDATE_VEHICLE_BY_ID = "update vehicle set v_name = ? where id = ?";
    public final static String DELETE_VEHICLE_BY_ID = "delete from vehicle where id = ?";
    public final static String INSERT_INTO_VEHICLE =
            "insert into vehicle (v_name, model,brand,color,owner_id)" +
                    "values (?,?,?,?,?) ";

//    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public final static String Get_All_BOOKING = "select * from booking";
    public final static String Get_BOOKING_BY_ID = "select * from booking where id = ?";
    public final static String DELETE_BOOKING_BY_ID = "delete from booking where id = ?";
    public final static String INSERT_INTO_BOOKING =
            "insert into booking (cid, vid,booking_date,price,booking_status)" +
                    "values (?,?,?,?,?) ";

//    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public final static String Get_All_VEHICLE_OWNER = "select * from vehicle_owner";
    public final static String Get_VEHICLE_OWNER_BY_ID = "select * from vehicle_owner where id = ?";
    public final static String UPDATE_VEHICLE_OWNER_BY_ID = "update vehicle_owner set owner_name = ? where id = ?";
    public final static String DELETE_VEHICLE_OWNER_BY_ID = "delete from vehicle_owner where id = ?";
    public final static String INSERT_INTO_VEHICLE_OWNER =
            "insert into vehicle_owner (owner_name, owner_number,cnic,address,commission)" +
                    "values (?,?,?,?,?) ";
}
