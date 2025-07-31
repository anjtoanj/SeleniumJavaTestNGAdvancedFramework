package com.salesforce.pages;

import com.framework.seleniumapi.design.Locators;
import com.framework.testngapi.ProjectSpecificMethods;

public class HomePage  extends ProjectSpecificMethods {



    // Method to verify home page after login
    public boolean verifyHomePage(){
        try {
            verifyDisplayed(locateElement(Locators.XPATH,"//span[text()='Home']"));
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
