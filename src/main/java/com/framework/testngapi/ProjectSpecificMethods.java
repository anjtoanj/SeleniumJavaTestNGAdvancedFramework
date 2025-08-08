package com.framework.testngapi;

import com.framework.seleniumapi.base.SeleniumBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.framework.utils.DataLibrary;

public class ProjectSpecificMethods extends SeleniumBase {

    public static Properties prop;

    public static String username, password;
    public static String contactName;

    @DataProvider(name = "fetchData", indices = 0)
    public Object[][] fetchData() throws IOException {
        return DataLibrary.readExcelData(excelFileName);
    }

    @BeforeMethod
    public void preCondition() throws IOException {

        //Loads the configuration file located in your resources folder.
        // FileInputStream reads the contents of config.properties into the Java program.
        FileInputStream config = new FileInputStream("./src/main/resources/config.properties");
        prop = new Properties();
        prop.load(config);
//		Initializes the Properties object.
//		Loads the key-value pairs from the file (like browser=chrome, url=https://example.com, etc.) into memory.
        startApp("chrome", false, prop.getProperty("url"));
//        setNode();
        username = prop.getProperty("username");
        password = prop.getProperty("password");

    }

    public void postCondition() {
        close();

    }
}

