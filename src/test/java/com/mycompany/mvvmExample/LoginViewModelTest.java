package com.mycompany.mvvmExample;

import org.junit.Assert;
import org.junit.Test;

public class LoginViewModelTest {
    @Test
    public void disableLoginButton() throws Exception {
		LoginViewModel loginViewModel = new LoginViewModel();
		// No username and password were set
		Assert.assertFalse(loginViewModel.isLoginPossibleProperty().get());
		loginViewModel.userNameProperty().set("Stefanie Albrecht");
		// username was set, but no password
		Assert.assertFalse(loginViewModel.isLoginPossibleProperty().get());
		loginViewModel.passwordProperty().set("<3");
		// username and password were set
		Assert.assertTrue(loginViewModel.isLoginPossibleProperty().get());
    }
    /* Hier wird getestet, ob der String "Button fired" angezeigt wird,
     * wenn man den loginButton drückt.*/
    @Test
    public void displayLoginButtonFired() throws Exception {
    	LoginViewModel loginViewModel = new LoginViewModel();
    	loginViewModel.loginButtonFiredProperty().setValue(true);
    	Assert.assertEquals(loginViewModel.loginButtonFiredLabelProperty().getValue(), "Button fired");
    }
}
