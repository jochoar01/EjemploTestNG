package com.academy.tae.utils.providers;

import com.academy.tae.util.Helper;
import com.academy.tae.util.Type;
import org.testng.annotations.DataProvider;

/**
 * Providers to the Account Creation Process
 * @author juanpablo.vasquez
 */
public class AccountProvider {
    /**
     * Data Provider that calls the Random Generator to return the valid data to the Account Creation Process
     * @return an Object[][] with valid data inside
     */
    @DataProvider(name = "dpAccountCredentials")
    public Object[][] dpAccountCredentials() {
        
        return new Object[][] {
            {
                    Helper.getInstance().getRandom(Type.FIRST_NAME),
                    Helper.getInstance().getRandom(Type.LAST_NAME),
                    Helper.getInstance().getRandom(Type.EMAIL),
                    Helper.getInstance().getRandom(Type.PASSWORD)
            }
        };
    }
}
