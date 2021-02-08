package com.academy.tae.util.listeners;

import com.academy.tae.util.BaseLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * EventHandler is a class that as its name states, handles the possible events that may arise, while interacting with the
 * different elements.
 * <p>
 * This EventHandler is currently only logging the exceptions that are found during the execution, the reason for
 * that is because the aim for this project is the Test of different flows, meaning that the interactions are set to work
 * properly and theres no need to log each step that the system takes, at this point in time.
 * @author juanpablo.vasquez
 */
public class EventHandler implements WebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {

    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {

    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {

    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    /**
     * Event that fires up when there's an exception, originating from the Driver.
     * @param throwable the exception thrown
     * @param driver the driver and context
     */
    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        BaseLogger.getLogger().trace(throwable.getStackTrace());
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }
}
