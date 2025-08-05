package com.salesforce.testcases;

import com.framework.testngapi.ProjectSpecificMethods;
import com.salesforce.pages.HomePage;
import com.salesforce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001_VerifyLogin extends ProjectSpecificMethods {
    @BeforeTest
    public void setValues(){


    }

    @Test
    public void login(){
        try{
            // Simulating the login process
            LoginPage loginPage = new LoginPage();
                        loginPage.enterUsername()
                                .enterPassword()
                                .clickLogin();

            // Now verify the home page is loaded (this should return true/false)
            HomePage homePage = new HomePage();
            boolean isLoginSuccessful = homePage.verifyHomePage();

            // Report pass/fail based on the login result
            if (isLoginSuccessful) {
                System.out.println("Test Case:  PASSED");

            } else {
                throw new Exception("Login was not successful");
            }

        } catch (Exception e) {

            System.out.println("Test Case:  FAILED: " + e.getMessage());
            Assert.fail("Test Case failed: " + e.getMessage());  // Fail the test if there is an error
        }

    }

}
