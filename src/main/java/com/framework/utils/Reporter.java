package com.framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.framework.seleniumapi.base.DriverInstance;

public abstract class Reporter extends DriverInstance {

    public  static ExtentReports extent;
    public static final ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
    public static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public static final ThreadLocal<String> testName = new ThreadLocal<>();

    private String fileName = "result.html";
    private String pattern = "dd-MMM-yyyy HH-mm-ss";

    public String testcaseName, testDescription, authors, category, dataFileName, dataFileType, excelFileName,sheetName;
    public static String folderName = "";


    public synchronized void setNode() {
        ExtentTest child = parentTest.get().createNode(getTestName());
        test.set(child);
    }

    public String getTestName() {
        return testName.get();
    }
}
