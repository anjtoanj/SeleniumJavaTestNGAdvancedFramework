package com.framework.testngapi;

import com.framework.seleniumapi.base.SeleniumBase;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjectSpecificMethods extends SeleniumBase {

    public static Properties prop;
    public static String username, password ;
    public static String contactName;

    @BeforeMethod
    public  void precondition() throws IOException{

        FileInputStream config = new FileInputStream("./src/main/resources/config.properties");
        prop = new Properties();
        prop.load(config);
        startApp("chrome", false, prop.getProperty("url"));
        username = prop.getProperty("username");
        password = prop.getProperty("password");
    }
    public void postCondition() {
        close();
    }
}
