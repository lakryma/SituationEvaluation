/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FunctionDAO;
import dao.UserDAO;
import java.util.ArrayList;
import javax.swing.JComboBox;
import model.Function;
import model.User;
import view.NewUserView;

/**
 *
 * @author Formation
 */
public class NewUserController {

    boolean isValid = true;
    String errorMessage = "";
    
    private UserDAO userDAO;
    
//------------------------------------------------------------------------------
    
    public NewUserController() {
   
    }
    
//------------------------------------------------------------------------------
    
    public NewUserController(UserDAO userDAO) {
       
        this.userDAO = userDAO;
    }

//------------------------------------------------------------------------------
    
    public void CreateNewUser(NewUserView newUserView) {
                                
    User user = new User();
    
    String pseudo = newUserView.getTf_pseudo().getText();
    String password = newUserView.getPf_password().getText();
    String firstname = newUserView.getTf_firstname().getText();
    String lastname = newUserView.getTf_lastname().getText();
    String mail = newUserView.getTf_mail().getText();
    String tel = newUserView.getTf_tel().getText();
    String address = newUserView.getTf_address().getText();
    String city = newUserView.getTf_city().getText();
    String country = newUserView.getTf_country().getText();
    
    user.setFirstname(firstname);
    user.setLastname(lastname);
    user.setMail(mail);
    user.setTel(tel);
    user.setAddress(address);
    user.setCity(city);
    user.setCountry(country);
    user.setFunction(0);
    
    userDAO.create(user);
}
//------------------------------------------------------------------------------    
 
public void addComboBox(JComboBox cb_function){
    
    FunctionDAO functionDAO = new FunctionDAO();
    ArrayList <Function> function = new ArrayList<>();
    
    function = functionDAO.getAll();
    
    cb_function.addItem("");
    
    for(int i = 0; i < function.size(); i++){
        cb_function.addItem(function.get(i).getDefinition());
    }
}
}
