package com.academy.tae.disable_account;

import com.academy.tae.base.BaseTest;
import com.academy.tae.pages.AccountDisabilityPage;
import com.academy.tae.utils.providers.AccountProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * Test: Disable Account
 * @author juanpablo.vasquez
 */
public class DisableAccountTests extends BaseTest {
    /**
     * First Name to be used in the Disable Account Flow
     */
    private String firstName;
    /**
     * Last Name to be used in the Disable Account Flow
     */
    private String lastName;
    /**
     * Email to be used in the Disable Account Flow
     */
    private String email;
    /**
     * Password to be used in the Disable Account Flow
     */
    private String password;

    /**
     * Basic instantiation of the Test Class, where we use a @Factory to gather the required information and
     * properly take care of the pre-conditions of the test.
     * @param firstName to be used in the Account Creation, in the Disable Account Flow
     * @param lastName to be used in the Account Creation, in the Disable Account Flow
     * @param email to be used in the Account Creation, in the Disable Account Flow
     * @param password to be used in the Account Creation, in the Disable Account Flow
     */
    @Factory(dataProvider = "dpAccountCredentials", dataProviderClass = AccountProvider.class)
    public DisableAccountTests(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    /**
     * Test the ability to disable my own account in the application
     */
    @Test(
        description = "Test if the Disable Account flow works properly"
    )
    public void testSuccessfulAccountDisable() {
        AccountDisabilityPage disabilityPage = getHomePage().doDisableAccount();
        Assert.assertTrue(disabilityPage.getHeader().contains("deleted"), "Account deletion message is not correct.");
    }

    /**
     * Pre-condition: Have an active account and be logged into the application
     */
    @BeforeMethod
    public void beforeMethodCreateAccount() {
        getHomePage().doCreateAccount(firstName, lastName, email, password);
    }
}
