package com.academy.tae.base;

import com.academy.tae.util.listeners.EventHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * BasePage is the base class to all the Page classes in the application.
 * <p>
 * This class is given the driver already instantiated and starts a PageFactory, given the driver's context,
 * after doing so, it executes some configurations such as maximizing windows and registering eventHandlers.
 * <p>
 * it also provides different common methods used along the different Page classes.
 * @author juanpablo.vasquez
 */
public class BasePage {
    /**
     * Wait instance to send to the pages with the call of getWait()
     */
    private WebDriverWait wait;
    /**
     * EventDriver wrapper for the WebDriver instance, to register different Listeners
     */
    private EventFiringWebDriver eventDriver;
    /**
     * Listener class, WebDriverEventListener
     */
    private EventHandler eventHandler;

    /**
     * Start PageFactory with the given driver's context and set up the WebDriver event handler.
     * @param pDriver driver instance
     */
    public BasePage(WebDriver pDriver) {
        PageFactory.initElements(pDriver, this);
        pDriver.manage().window().maximize();
        this.eventDriver = new EventFiringWebDriver(pDriver);
        this.eventHandler = new EventHandler();
        this.eventDriver.register(eventHandler);
        //driver = pDriver;
    }

    /**
     * Common action in Selenium, receives an element of type WebElement, creates an expected wait until
     * said element is clickable, then it performs said action.
     * @param element to be clicked
     */
    public void clickElement(WebElement element) {
        wait = new WebDriverWait(eventDriver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * Common action in Selenium, it receives two params:
     * <ul>
     *     <li>WebElement element</li>
     *     <li>String text</li>
     * </ul>
     * <p>
     * It waits until said element is visible then it sends the text to it.
     * @param element to be set up
     * @param text to set in @element
     */
    public void setElementText(WebElement element, String text) {
        wait = new WebDriverWait(eventDriver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    /**
     * Gets the driver's wait element so it can be used in the children Page classes,
     * it returns an instance of the drivers wait type with a set number of 20 seconds.
     * @return WebDriverWait element
     */
    public WebDriverWait getWait() {
        wait = new WebDriverWait(eventDriver, 20);
        return wait;
    }

    /**
     * Gets the driver instance itself, and returns it to be used in the children classes.
     * Must know that the element being returned is the eventHandler, so the listeners can do its job properly.
     * @return WebDriver element
     */
    public WebDriver getDriver() {
        return eventDriver;
    }

    /**
     * Tear-Down method, to exit and stop the drivers instance.
     */
    public void dispose() {
        if(eventDriver != null) {
            eventDriver.quit();
        }
    }
}
