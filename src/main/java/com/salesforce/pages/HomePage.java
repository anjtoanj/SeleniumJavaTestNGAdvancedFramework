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
    public HomePage clickAppLauncher() {

        click(locateElement(Locators.XPATH, "//div[@class='slds-icon-waffle']"));
   //     reportStep("Toggle Menu button clicked successfully", "pass");
        return this;
    }

    public HomePage clickViewAll() {

        click(locateElement(Locators.XPATH, "//button[text()='View All']"));
    //    reportStep("View All link clicked successfully", "pass");
        return this;
    }

    public HomePage enterSearchField(String search) {
        clearAndType(locateElement(Locators.XPATH, "//input[@placeholder='Search apps or items...']"), search);
    //    reportStep("Search Field entered successfully", "pass");
        return this;
    }

    public HomePage clickSales() {
        click(locateElement(Locators.XPATH, "(//p[@class='slds-truncate']/mark[text()='Sales'])[3]"));
     //   reportStep("Sales is clicked sucessfully", "pass");
        return this;
    }

    public IndividualsPage clickIndividualsLink() {

        click(locateElement(Locators.XPATH, "//mark[text()='Individuals']"));
        //   reportStep("Individuals link clicked successfully", "pass");
        return new IndividualsPage();
    }

}
