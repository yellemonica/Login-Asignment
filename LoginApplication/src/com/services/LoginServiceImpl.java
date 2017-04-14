package com.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.LoginDAO;

public class LoginServiceImpl implements LoginService {
	 @Autowired
	 private LoginDAO loginDAO;

	   public void setLoginDAO(LoginDAO loginDAO) {
              this.loginDAO = loginDAO;
       }
      
       public boolean checkLogin(int id, String userName){
              System.out.println("In Service class...Check Login");
              return loginDAO.checkLogin(id, userName);
       }
}
