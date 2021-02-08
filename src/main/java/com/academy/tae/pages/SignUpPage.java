package com.academy.tae.pages;

import com.academy.tae.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * SignUpPage represents the SignUp page in the application, representing its elements and interactions
 * @author juanpablo.vasquez
 */
public class SignUpPage extends BasePage {
    /**
     * Section under Frame where all the elements are located, ignoring the full width and height of the form
     */
    private By SignUpSection = By.id("did-ui-view");
    /**
     * Form field where the FirstName is set up
     */
    private By firstNameField = By.cssSelector("input[name='firstName'][ng-model*='firstName']");
    /**
     * Form field where LastName is set up
     */
    private By lastNameField = By.cssSelector("input[name='lastName'][ng-model*='lastName']");
    /**
     * Form field where Email is set up
     */
    private By emailField = By.cssSelector("input[name='email'][ng-model*='email']");
    /**
     * Form field where Password is set up
     */
    private By passwordField = By.cssSelector("input[name='newPassword'][ng-model*='newPassword']");
    /**
     * Button to submit form and travel to HomePage, after creating the account.
     */
    private By submitButton = By.cssSelector(".section-submit button[type='submit']");

    /**
     * Basic instantiation, setting context its proper switch
     * @param driver to set default context
     * @param iFrame to switch context properly
     */
    public SignUpPage(WebDriver driver, WebElement iFrame) {
        super(driver);
        getDriver().switchTo().frame(iFrame);
    }

    /**
     * Set @firstName into @firstNameField properly
     * @param firstName to be set in @firstNameField
     */
    public void setFirstName(String firstName) {
        setElementText(getDriver().findElement(firstNameField), firstName);
    }

    /**
     * Set @lastName into @lastNameField properly
     * @param lastName to be set in @lastNameField
     */
    public void setLastName(String lastName) {
        setElementText(getDriver().findElement(lastNameField), lastName);
    }

    /**
     * Set @email into @emailField properly
     * @param email to be set in @emailField
     */
    public void setEmail(String email) {
        setElementText(getDriver().findElement(emailField), email);
    }

    /**
     * Set @password into @passwordField properly
     * @param password to be set in @passwordField
     */
    public void setPassword(String password) {
        setElementText(getDriver().findElement(passwordField), password);
    }

    /**
     * Performs a click on the submit button of the SignUpPage form, it waits for it to disappear, then redirects
     * the user to the HomePage
     * @return an instance of HomePage
     */
    public HomePage clickSignUp() {
        clickElement(getDriver().findElement(submitButton));
        getWait().until(ExpectedConditions.invisibilityOf(getDriver().findElement(SignUpSection)));
        getDriver().switchTo().defaultContent();
        return new HomePage(getDriver());
    }

    /**
     * Group of actions to fill out the Sign Up form properly and then, submit it.
     * @param firstName to be set in @firstNameField
     * @param lastName to be set in @lastNameField
     * @param email to be set in @emailField
     * @param password to be set in @passwordField
     * @return an instance of HomePage, following the clickSignUp method.
     */
    public HomePage doSignUpForm(String firstName, String lastName, String email, String password) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setPassword(password);

        return this.clickSignUp();
    }
}
