package com.mycompany.mvvmExample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class LoginViewModel {
    /* Attribute werden als Properties definiert, damit man sie mit den Objekten in 
    der View synchronisieren (binden) kann.*/
    private final StringProperty userName = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final ReadOnlyBooleanWrapper loginPossible = new ReadOnlyBooleanWrapper();
    private final StringProperty loginButtonFiredLabel = new SimpleStringProperty();
    private final BooleanProperty loginButtonFired = new SimpleBooleanProperty();
    
    /* Beim initialisieren der Klasse werden die Booleschen Werte, die aussagen,
    ob ein Name und ein Passwort eingegeben wurden, aneinander gebunden.*/
    public LoginViewModel() {
        loginPossible.bind(userName.isNotEmpty().and(password.isNotEmpty()));
        /* Hier steht, was passiert, wenn der Wert von loginButtonFired verändert wird.*/
        loginButtonFired.addListener(new ChangeListener<Boolean>() {
        	public void changed(ObservableValue<? extends Boolean> observable, 
        			Boolean oldValue, Boolean newValue) {
        		loginButtonFiredLabel.set("Button fired");
            }
        });
        	
    }
    /* Die folgenden Methoden, die alle auf "Property" enden, brauchen wir, damit wir
     * die Properties in den Return-Statements an die Properties der Objekte der View
     * (z.B. loginButton) binden können. Das Binden geschieht im Controller
     * (LoginView.java).
     */ 
    public StringProperty userNameProperty(){
        return userName;
    }
    
    public StringProperty passwordProperty(){
        return password;
    }
    
    public ReadOnlyBooleanProperty isLoginPossibleProperty(){
        return loginPossible.getReadOnlyProperty();
    }
    
	public Property<String> loginButtonFiredLabelProperty() {
		return loginButtonFiredLabel;
	}
	
	public BooleanProperty loginButtonFiredProperty() {
		return loginButtonFired;
	}
	  
}

