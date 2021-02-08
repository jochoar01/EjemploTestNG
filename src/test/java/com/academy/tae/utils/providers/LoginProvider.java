package com.academy.tae.utils.providers;

import org.testng.annotations.DataProvider;

/**
 * Provider for the Login process
 * @author juanpablo.vasquez
 */
public class LoginProvider {
    /**
     * Static data provider with valid credentials for the Login process
     * @return an Object[][] with valid credentials
     */
    @DataProvider(name = "dpStaticLogin")
    public Object[][] dpStaticLogin() {
        return new Object[][] {
                {"ci@g.com", "testing123*"}
        };
    }
}
