package com.academy.tae.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * BaseDriver is the base class for all of the Page-Object Model structure as it provides the browser set up and instance
 * for it to be used in the different Page classes.
 * <p>
 * This base class is not implementing any Thread-Safe strategies as of yet.
 * @author juanpablo.vasquez
 */
public class BaseDriver {
    /**
     * Driver to interact with the elements in a given page
     */
    private WebDriver driver;

    /**
     * Instantiate the preferred browser, setting up it's respective driver to the System environment.
     * @param browser to instantiate
     */
    public BaseDriver(String browser) {
        switch (browser) {
            case "chrome":
                // This is using chrome v88
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
        }
    }

    /**
     * Method to return the driver already instantiated.
     * @return the driver
     */
    public WebDriver getDriver() {
        return driver;
    }
}
