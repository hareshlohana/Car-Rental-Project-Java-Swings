package org.car_rantel.service;

import org.car_rantel.dao.UserDAO;
import org.car_rantel.domain.User;

public class AuthenticationService {

    private final UserDAO userDAO = new UserDAO();
    public Boolean checkLogin(String usernmae, String password){
        User user = userDAO.getUserByUsernameAndPassword(usernmae,password);
        if(user != null){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
