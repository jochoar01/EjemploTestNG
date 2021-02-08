package com.academy.tae.base;

import com.academy.tae.pages.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
    /**
     * BaseDriver instance, to set up the Test environment
     */
    private BaseDriver driver;
    /**
     * First point of access to the application, HomePage
     */
    private HomePage homePage;

    /**
     * Setting the environment of the Tests, creating the WebDriver and instantiating the HomePage
     * as well as traveling to the desired URL
     * @param browser where the test will be running
     */
    @BeforeClass
    @Parameters({"browser"})
    public void beforeClass(String browser) {
        driver = new BaseDriver(browser);
        homePage = new HomePage(driver.getDriver());
        gotoHomePage();
    }

    /**
     * After each Test is finished, it will terminate its homepage, destroying the driver instance as well
     */
    @AfterClass
    public void afterClass() {
        homePage.dispose();
    }

    /**
     * Method to travel to the desired URL, in this case ESPNQA
     */
    public void gotoHomePage() {
        driver.getDriver().get("https://www.espnqa.com/?src=com&espn=cloud&_adblock=true");
    }

    /**
     * Method to get the instance of the HomePage.
     * @return an instance of HomePage
     */
    public HomePage getHomePage() {
        return homePage;
    }
}
