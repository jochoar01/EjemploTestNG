package com.academy.tae.logout;

import com.academy.tae.base.BaseTest;
import com.academy.tae.pages.HomePage;
import com.academy.tae.pages.LoginPage;
import com.academy.tae.utils.providers.LoginProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * Test: Logout
 * @author juanpablo.vasquez
 */
public class LogoutTests extends BaseTest {
    /**
     * Email to be used in the Logout Flow
     */
    private String email;
    /**
     * Password to be used in the Logout Flow
     */
    private String password;

    /**
     * Basic initialization of the LogoutTests class, using @Factory to retrieve the data needed to fulfill
     * preconditions
     * @param email to be used in the preconditions of the Logout flow
     * @param password to be used in the preconditions of the Logout flow
     */
    @Factory(dataProvider = "dpStaticLogin", dataProviderClass = LoginProvider.class)
    public LogoutTests(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Test the ability to log out of the application successfully, following the available elements
     */
    @Test(
        description = "Test if log out flow does work"
    )
    public void testSuccessfulLogOut() {
        HomePage.GlobalUserSection userSection = getHomePage().doLogout();
        Assert.assertTrue(userSection.isDisplayed(), "Hover not displayed");
        Assert.assertEquals(userSection.getWelcomeText(), "Welcome!", "Welcome text is still greeting user");
    }

    /**
     * Pre-condition: Be logged into the application successfully
     */
    @BeforeMethod
    public void beforeMethodLogIn() {
        getHomePage().doLogin(email, password);
    }
}
