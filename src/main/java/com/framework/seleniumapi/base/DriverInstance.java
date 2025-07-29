package com.framework.seleniumapi.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.groovy.json.internal.Chr;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverInstance {

        private static final ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal<>();
        private static final ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

        public void setDriver(String browser, boolean headless){

                switch(browser){
                        case "chrome" :
                                WebDriverManager.chromedriver().setup();
                                ChromeDriverService serviceC = new ChromeDriverService.Builder().withSilent(true).build();// suppress ChromeDriver logs for clean code
                                ChromeOptions optionC = new ChromeOptions();
                                remoteWebDriver.set(new ChromeDriver(optionC));
                                break;
                        case "firefox":
                                WebDriverManager.firefoxdriver().setup();
                                FirefoxOptions optionF = new FirefoxOptions();
                                remoteWebDriver.set(new FirefoxDriver(optionF));
                                break;
                        case "ie" :
                                WebDriverManager.iedriver().setup();
                                InternetExplorerDriverService serviceI = new InternetExplorerDriverService.Builder().withSilent(true).build();// suppress ChromeDriver logs for clean code
                                InternetExplorerOptions optionIE = new InternetExplorerOptions();
                                remoteWebDriver.set(new InternetExplorerDriver(optionIE));
                                break;
                        default:
                                break;
                }

        }

        public RemoteWebDriver getDriver(){
                return remoteWebDriver.get();
        }
        public void setWait(){
                wait.set(new WebDriverWait(remoteWebDriver.get(), Duration.ofSeconds(30)));
        }

        public  WebDriverWait getWait(){
                return wait.get();
        }

}
