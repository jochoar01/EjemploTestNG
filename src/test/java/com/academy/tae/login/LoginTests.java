package com.academy.tae.login;

import com.academy.tae.base.BaseTest;
import com.academy.tae.pages.HomePage;
import com.academy.tae.pages.LoginPage;
import com.academy.tae.utils.providers.LoginProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Test: Login
 * @author juanpablo.vasquez
 */
public class LoginTests extends BaseTest {

    /**
     * Test the ability to log into the application successfully
     * @param email to be used in the LogIn form, in the Login Flow
     * @param password to be used in the LogIn form, in the Login Flow
     */
    @Test(
        description = "Test successful log in flow into the application",
        dataProvider = "dpStaticLogin",
        dataProviderClass = LoginProvider.class
    )
    public void testSuccessfulLogin(String email, String password) {
        HomePage.GlobalUserSection userSection = getHomePage().doLogin(email, password);
        Assert.assertTrue(userSection.isDisplayed(), "Hover after login is not working");
        Assert.assertTrue(!userSection.getWelcomeText().equals("Welcome!"), "Welcome text is not greeting user");
    }

    /**
     * Post-condition: Log out of the application after confirming the flow success.
     */
    @AfterMethod
    public void afterMethodLogOut() {
        HomePage.GlobalUserSection userSection = getHomePage().hoverOverUserIcon();
        userSection.clickLogOutLink();
    }
}
