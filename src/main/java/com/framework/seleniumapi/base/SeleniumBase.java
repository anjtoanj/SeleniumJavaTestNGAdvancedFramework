package com.framework.seleniumapi.base;

import com.framework.seleniumapi.design.Browser;
import com.framework.seleniumapi.design.Element;
import com.framework.seleniumapi.design.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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

//    @Override
//    public List<WebElement> locateElements(Locators locatorType, String value) {
//        return List.of();
//    }


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
        if (getDriver().getCurrentUrl().equals(url)) {
          //  reportStep("The url: " + url + " matched successfully", "info");
            return true;
        } else {
         //   reportStep("The url: " + url + " not matched", "fail");
        }
        return false;
    }

    @Override
    public boolean verifyTitle(String title) {
        if(getDriver().getTitle().equals(title)){
            return true;
        }else {
            System.out.println("title locator not valid");
        }
        return false;
    }

    @Override
    public void close() {
        try {
            getDriver().close();
            //reportStep("Browser is closed", "info", false);
        } catch (Exception e) {
            e.printStackTrace();
            //reportStep("Browser cannot be closed " + e.getMessage(), "fail", false);
        }
    }

    @Override
    public void quit() {
        try {
            getDriver().quit();
            //reportStep("Browser is closed", "info", false);
        } catch (Exception e) {
           // reportStep("Browser cannot be closed " + e.getMessage(), "fail", false);
        }
    }

    @Override
    public void click(WebElement ele) {
        try{
            ele.isDisplayed();
            getWait().until(ExpectedConditions.elementToBeClickable(ele));

        } catch (NoSuchElementException e)  {

            //reportStep("The Element " + ele + " is not found", "fail");
        }
        String text = "";
        try {
            try {
                Thread.sleep(500);
                getWait().until(ExpectedConditions.elementToBeClickable(ele));
                text = ele.getText();
                if (ele.isEnabled()) {
                    ele.click();
                } else {
                    getDriver().executeScript("arguments[0].click()", ele);
                }
            } catch (Exception e) {
                boolean bFound = false;
                int totalTime = 0;
                while (!bFound && totalTime < 10000) {
                    try {
                        Thread.sleep(500);
                        ele.click();
                        bFound = true;

                    } catch (Exception e1) {
                        bFound = false;
                    }
                    totalTime = totalTime + 500;
                }
                if (!bFound)
                    ele.click();
            }
        } catch (StaleElementReferenceException e) {
            System.err.println(e);
      //      reportStep("The Element " + text + " could not be clicked due to:" + e.getMessage(), "fail");
        } catch (WebDriverException e) {
            System.err.println(e);
       //     reportStep("The Element " + ele + " could not be clicked due to: " + e.getMessage(), "fail");
        } catch (Exception e) {
            System.err.println(e);
       //     reportStep("The Element " + ele + " could not be clicked due to: " + e.getMessage(), "fail");
        }
    }

    @Override
    public void clear(WebElement ele) {
        try {
            ele.clear();
        } catch (ElementNotInteractableException e) {
           // reportStep("The field is not Interactable \n" + e.getMessage(), "fail");
        }
    }

    @Override
    public void clearAndType(WebElement ele, String data) {
        try {
            getWait().until(ExpectedConditions.visibilityOf(ele));
            ele.clear();
            ele.sendKeys("", "", data);
        } catch (ElementNotInteractableException e) {
          //  reportStep("The Element " + ele + " is not Interactable \n" + e.getMessage(), "fail");
        } catch (WebDriverException e) {
          //      reportStep("The Element " + ele + " did not allow to clear / type \n" + e.getMessage(), "fail");
        }
    }

    @Override
    public void typeAndEnter(WebElement ele, String data) {
        try {
            getWait().until(ExpectedConditions.visibilityOf(ele));
            ele.clear();
            ele.sendKeys("", "", data, Keys.ENTER);
        } catch (ElementNotInteractableException e) {
           // reportStep("The Element " + ele + " is not Interactable \n" + e.getMessage(), "fail");
        } catch (WebDriverException e) {
           // reportStep("The Element " + ele + " is not Interactable \n" + e.getMessage(), "fail");
        }

    }

    @Override
    public String getElementText(WebElement ele) {
        try{
            String text = ele.getText();
            return text;
        }catch( Exception e){

        }
        return null;
    }

    @Override
    public void selectDropDownUsingText(WebElement ele, String value) {
        try{

            Select sel = new Select(ele);
            sel.selectByVisibleText(value);

        } catch (Exception e) {

            //reportStep("Not able to select the drop down with text \n" + value, "fail");
        }
    }

    @Override
    public boolean verifyExactText(WebElement ele, String expectedText) {
        return false;
    }

    @Override
    public boolean verifyDisplayed(WebElement ele) {
        try {
            if (ele.isDisplayed()) {
                return true;
            } else {
             //   reportStep("The element " + ele + " is not visible", "warnings");
            }
        } catch (WebDriverException e) {
           // reportStep("WebDriverException : \n" + e.getMessage(), "fail");
        }
        return false;
    }

    @Override
    public boolean verifyEnabled(WebElement ele) {
        try {
            if (ele.isEnabled()) {
                return true;
            } else {
               // reportStep("The element " + ele + " is not Enabled", "warning");
            }
        } catch (WebDriverException e) {
           // reportStep("WebDriverException : \n" + e.getMessage(), "fail");
        }
        return false;
    }

    @Override
    public boolean verifySelected(WebElement ele) {
        try {
            if (ele.isSelected()) {
                return true;
            } else {
              //  reportStep("The element " + ele + " is not selected", "warning");
            }
        } catch (WebDriverException e) {
         //   reportStep("WebDriverException : \n" + e.getMessage(), "fail");
        }
        return false;
    }
}
