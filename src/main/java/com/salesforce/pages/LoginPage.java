package com.salesforce.pages;

import com.framework.seleniumapi.design.Locators;
import com.framework.testngapi.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {

    public LoginPage enterUsername(){
        clearAndType(locateElement(Locators.ID, "username"), prop.getProperty("username"));
        return this;
    }
    public LoginPage enterPassword(){
        clearAndType(locateElement(Locators.ID, "password"), prop.getProperty("password"));
        return this;
    }
    public HomePage clickLogin(){
        click(locateElement(Locators.ID, "Login"));
        return new HomePage();
    }

}
