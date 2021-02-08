package com.academy.tae.pages;

import com.academy.tae.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * LoginPage is the class representing the real Login in the application, and interacts with their elements
 * @author juanpablo.vasquez
 */
public class LoginPage extends BasePage {
    /**
     * Section where all elements from the LoginPage can be found
     */
    private By loginSection = By.id("did-ui-view");
    /**
     * Form field where the Email is set
     */
    private By emailField = By.cssSelector("input[type='email'][ng-model*='username']");
    /**
     * Form field where the Password is set
     */
    private By passwordField = By.cssSelector("input[type='password'][ng-model*='password']");
    /**
     * Button to submit button and log into the application
     */
    private By loginButton = By.cssSelector("button.btn-submit[type='submit']");

    /**
     * Basic instantiation and setting of context, switching to IFrame to interact with elements properly inside LoginPage
     * @param driver to give default context
     * @param iFrame to switch context into
     */
    public LoginPage(WebDriver driver, WebElement iFrame) {
        super(driver);
        getDriver().switchTo().frame(iFrame);
    }

    /**
     * Action to set the @emailField with @email param
     * @param email to be set in @emailField
     */
    public void setEmail(String email) {
        setElementText(getDriver().findElement(emailField), email);
    }

    /**
     * Action to set the @passwordField with @password param
     * @param password to be set in @passwordField
     */
    public void setPassword(String password) {
        setElementText(getDriver().findElement(passwordField), password);
    }

    /**
     * Action to submit the Login form and forward context to HomePage
     * @return an instance of HomePage
     */
    public HomePage clickLogin() {
        clickElement(getDriver().findElement(loginButton));
        getWait().until(ExpectedConditions.invisibilityOf(getDriver().findElement(loginSection)));
        getDriver().switchTo().defaultContent();
        return new HomePage(getDriver());
    }

    /**
     * Group of actions to perform the Login action faster.
     * @param email to be set in @emailField
     * @param password to be set in @passwordField
     * @return an instance of HomePage after clicking submit
     */
    public HomePage doLoginForm(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
        return this.clickLogin();
    }
}
