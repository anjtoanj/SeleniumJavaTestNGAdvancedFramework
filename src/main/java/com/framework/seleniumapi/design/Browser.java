package com.framework.seleniumapi.design;

import org.openqa.selenium.*;

import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;

public interface Browser {
    /**
     * This method will launch the Chrome browser and
     * maximise the browser and set the wait for 30 seconds
     * and load the url
     * @param url - This will load the specified url  `
     * @throws MalformedURLException
     */
    public void startApp(String url, boolean headless);


    /**
     * This method will locate the element using any given locator
     * @param locatorType  - The locator by which the element to be found
     * @param locValue - The locator value by which the element to be found
     * @throws NoSuchElementException
     * @return The first matching element on the current context.
     */
    public WebElement locateElement(Locators locatorType, String value);

    /**
     * This method will locate the element using id
     * @param locValue - The locator value by which the element to be found
     * @throws NoSuchElementException
     * @return The first matching element on the current context.
     */
    public WebElement locateElement(String value);

    /**
     * This method will locate all matching element using any given locator
     * @param locatorType  - The locator by which the element to be found
     * @param locValue - The locator value by which the element to be found
     * @return A list of all WebElements, or an empty list if nothing matches.
     */
    public List<WebElement> locateElements(Locators locatorType, String value);

    /**
     * This method will switch to the Alert
     * @return NoAlertPresentException
     */
    public void switchToAlert();

    /**
     * This method will accept the alert opened
     * @throws NoAlertPresentException
     */
    public void acceptAlert();

    /**
     * This method will dismiss the alert opened
     * @throws NoAlertPresentException
     */
    public void dismissAlert();
    /**
     * This method will switch to the Window of interest
     * @param index The window index to be switched to. 0 -> first window
     * @throws NoSuchWindowException
     */
    public void switchToWindow(int index);

    /**
     * This method will switch to the specific frame
     * @param ele   - The Webelement (frame) to be switched
     * @throws NoSuchFrameException, StaleElementReferenceException
     */
    public void switchToFrame(WebElement ele);

    /**
     * This method will verify browser actual url with expected
     * @param url   - The url to be checked
     * @return true if the given object represents a String equivalent to this url, false otherwise
     */
    public boolean verifyUrl(String url);

    /**
     * This method will verify browser actual title with expected
     * @param title - The expected title of the browser
     * @return true if the given object represents a String equivalent to this title, false otherwise
     */
    public boolean verifyTitle(String title);

    /**
     * This method will close the active browser
     */
    public void close();

    /**
     * This method will close all the browsers
     */
    public void quit();
}
