package com.mycompany.mvvmExample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class LoginView {
    
	private LoginViewModel model;
	
    @FXML
    private TextField userNameTextField;
    
    @FXML
    private PasswordField passwordTextField;
    
    @FXML
    private Button loginButton;
    
    @FXML
    private Text loginButtonFiredLabel;
    
    @FXML
    protected void handleLoginButtonFired(ActionEvent event){
    	model.loginButtonFiredProperty().set(true);
    }
    
    @FXML
    void initialize() {
        this.model = new LoginViewModel();
        /* Hier wird die View mit dem ViewModel verbunden.*/
        userNameTextField.textProperty().bindBidirectional(model.userNameProperty());
        passwordTextField.textProperty().bindBidirectional(model.passwordProperty());
        loginButton.disableProperty().bind(model.isLoginPossibleProperty().not());
        loginButtonFiredLabel.textProperty().bindBidirectional(model.loginButtonFiredLabelProperty());        
    }
    
}
