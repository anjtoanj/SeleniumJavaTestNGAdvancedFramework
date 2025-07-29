package com.framework.seleniumapi.base;

import com.framework.seleniumapi.design.Browser;
import com.framework.seleniumapi.design.Element;
import com.framework.seleniumapi.design.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class SeleniumBase extends DriverInstance implements Browser, Element {

    protected Actions act;

    @Override
    public void startApp(String browser, boolean headless, String url) {
        try{
            if(browser.equalsIgnoreCase("chrome")) {

                setDriver("chrome", headless);
            } else if(browser.equalsIgnoreCase("firefox")) {
                         setDriver("firefox", headless);
            }else if (browser.equalsIgnoreCase("ie")) {
                         setDriver("ie", headless);
            }

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
        try {
            switch (locatorType) {
                case CLASS_NAME:
                    return getDriver().findElement(By.className(value));
                case CSS:
                    return getDriver().findElement(By.cssSelector(value));
                case ID:
                    return getDriver().findElement(By.id(value));
                case LINK_TEXT:
                    return getDriver().findElement(By.linkText(value));
                case NAME:
                    return getDriver().findElement(By.name(value));
                case PARTIAL_LINKTEXT:
                    return getDriver().findElement(By.partialLinkText(value));
                case TAGNAME:
                    return getDriver().findElement(By.tagName(value));
                case XPATH:
                    return getDriver().findElement(By.xpath(value));
                default:
                    System.err.println("Locator is not Valid");
                    break;
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public WebElement locateElement(String value) {
        try{
            WebElement findElementById = getDriver().findElement(By.id(value)); // similar to driver.findElement(By.id(value));
        } catch (NoSuchElementException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
