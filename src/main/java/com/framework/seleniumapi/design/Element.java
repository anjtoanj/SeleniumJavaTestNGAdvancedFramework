package com.framework.seleniumapi.design;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public interface Element {
    /**
     * This method will click the element and take snap
     * @param ele   - The Webelement (button/link/element) to be clicked
     * @see locateElement method in Browser Class
     * @throws StaleElementReferenceException
     */
    void click(WebElement ele);

    /**
     * This method will clear the value in the given text field
     * @param ele   - The Webelement (text field) in which the data to be entered
     * @see locateElement method in Browser Class
     * @throws InvalidElementStateException    (throws if not user-editable element)
     */
    void clear(WebElement ele);

    /**
     * This method will clear and type the value in the given text field
     * @param ele   - The Webelement (text field) in which the data to be entered
     * @param data  - The data to be sent to the webelement
     * @see locateElement method in Browser Class
     * @throws ElementNotInteractable,IllegalArgumentException(throws if keysToSend is null)
     */
    void clearAndType(WebElement ele,String data);

    /**
     * This method will get the visible text of the element
     * @param ele   - The Webelement (button/link/element) in which text to be retrieved
     * @see locateElement method in Browser Class
     */
    String getElementText(WebElement ele);

    /**
     * This method will select the drop down visible text
     * @param ele   - The Webelement (dropdown) to be selected
     * @param value The value to be selected (visibletext) from the dropdown
     * @see locateElement method in Browser Class
     * @throws NoSuchElementException
     */
    void selectDropDownUsingText(WebElement ele, String value) ;

    /**
     * This method will verify exact given text with actual text on the given element
     * @param ele   - The Webelement in which the text to be need to be verified
     * @param expectedText  - The expected text to be verified
     * @see locateElement method in Browser Class
     * @return true if the given object represents a String equivalent to this string, false otherwise
     */
    boolean verifyExactText(WebElement ele, String expectedText);

    /**
     * This method will verify if the element is visible in the DOM
     * @param ele   - The Webelement to be checked
     * @see locateElement method in Browser Class
     * @return true if the element is displayed or false otherwise
     */
    boolean verifyDisplayed(WebElement ele);


    /**
     * This method will verify if the input element is Enabled
     * @param ele   - The Webelement (Radio button, Checkbox) to be verified
     * @return true - if the element is enabled else false
     * @see locateElement method in Browser Class
     * @return True if the element is enabled, false otherwise.
     */
    boolean verifyEnabled(WebElement ele);

    /**
     * This method will verify if the element (Radio button, Checkbox) is selected
     * @param ele   - The Webelement (Radio button, Checkbox) to be verified
     * @see locateElement method in Browser Class
     * @return True if the element is currently selected or checked, false otherwise.
     */
    boolean verifySelected(WebElement ele);

}
