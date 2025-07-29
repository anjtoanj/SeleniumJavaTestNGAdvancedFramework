package com.framework.seleniumapi.base;

import com.framework.seleniumapi.design.Browser;
import com.framework.seleniumapi.design.Element;
import com.framework.seleniumapi.design.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class SeleniumBase extends DriverInstance implements Browser, Element {

    protected Actions act;

    @Override
    public void startApp(String url, boolean headless) {
        try{
              setDriver("chrome", headless);
              setWait();
              act = new Actions(getDriver());
              getDriver().manage().window().maximize();
              getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
              getDriver().get(url);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public WebElement locateElement(Locators locatorType, String value) {
        return null;
    }

    @Override
    public WebElement locateElement(String value) {
        return null;
    }

    @Override
    public List<WebElement> locateElements(Locators locatorType, String value) {
        return List.of();
    }

    @Override
    public void switchToAlert() {

    }

    @Override
    public void acceptAlert() {

    }

    @Override
    public void dismissAlert() {

    }

    @Override
    public void switchToWindow(int index) {

    }

    @Override
    public void switchToFrame(WebElement ele) {

    }

    @Override
    public boolean verifyUrl(String url) {
        return false;
    }

    @Override
    public boolean verifyTitle(String title) {
        return false;
    }

    @Override
    public void close() {

    }

    @Override
    public void quit() {

    }

    @Override
    public void click(WebElement ele) {

    }

    @Override
    public void clear(WebElement ele) {

    }

    @Override
    public void clearAndType(WebElement ele, String data) {

    }

    @Override
    public String getElementText(WebElement ele) {
        return "";
    }

    @Override
    public void selectDropDownUsingText(WebElement ele, String value) {

    }

    @Override
    public boolean verifyExactText(WebElement ele, String expectedText) {
        return false;
    }

    @Override
    public boolean verifyDisplayed(WebElement ele) {
        return false;
    }

    @Override
    public boolean verifyEnabled(WebElement ele) {
        return false;
    }

    @Override
    public boolean verifySelected(WebElement ele) {
        return false;
    }
}
