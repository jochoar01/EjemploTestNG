package com.academy.tae.pages;

import com.academy.tae.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Home page for the application, where every interaction will be starting from (Main point of access).
 * @author juanpablo.vasquez
 */
public class HomePage extends BasePage {
    /**
     * Frame where all the other pages are located
     */
    private By iFrame = By.id("disneyid-iframe");
    /**
     * Icon or section where the hover action is performed
     */
    private By globalUserBox = By.cssSelector("#global-header > div.container > ul > li.user");
    /**
     * Section that appears after performing the hover action on @globalUserBox
     */
    private By boxGlobalUser = By.cssSelector("div");
    /**
     * Button to travel to SignUpPage, the @signUpButton
     */
    private By signUpButton = By.cssSelector("#sideLogin-left-rail > button[tref*='register']");

    /**
     * Basic instantiation of the page, as its the home page and main point of access its interactions are to be
     * on the default context.
     * @param driver to define context
     */
    public HomePage (WebDriver driver) {
        super(driver);
    }

    /**
     * Search through elements to find the Sign Up button defined by signUpButton and click it,
     * to navigate to the Sign Up page.
     * @return an instance of SignUpPage
     */
    public SignUpPage clickSignUpButton() {
        clickElement(getDriver().findElement(signUpButton));
        return new SignUpPage(getDriver(), getDriver().findElement(iFrame));
    }

    /**
     * Special action of positioning the cursor over an element to perform a Hover.
     * <p>
     * As the item is performing such action, the application will show a menu with mainly user focused actions.
     * @return an instance of GlobalUserSection
     */
    public GlobalUserSection hoverOverUserIcon() {
        WebElement globalUser = getDriver().findElement(globalUserBox);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(globalUser).perform();

        return new GlobalUserSection(globalUser.findElement(boxGlobalUser));
    }

    /**
     * Perform the series of steps needed to Log out from the application, this assumes that the user is currently in
     * the HomePage class.
     * <p>
     * The action hovers over user icon, displaying the user menu and then clicks on the Log Out button. After it reloads
     * it hovers again, and waits for further steps.
     * @return an instance of GlobalUserSection
     */
    public GlobalUserSection doLogout() {
        return this.hoverOverUserIcon().clickLogOutLink().hoverOverUserIcon();
    }

    /**
     * Perfom the steps required to Log in to the application, assuming the user is in the HomePage class and has no active session.
     * <p>
     * The action hovers over the user icon, displaying the user menu and then clicks on the Log In button.
     * Then the flow will be forwarded to the LoginPage where the system required @email and @password, to proceed.
     * After the system logs in the user successfully, it will perform another hovering action to the user icon and
     * will wait for further steps.
     * @param email to be set in @emailField at the Login Form
     * @param password to be set in @passwordField at the Login Form
     * @return an instance of GlobalUserSection
     */
    public GlobalUserSection doLogin(String email, String password) {
        GlobalUserSection userSection = this.hoverOverUserIcon();
        LoginPage loginPage = userSection.clickLogInLink();
        return loginPage.doLoginForm(email, password).hoverOverUserIcon();
    }

    /**
     * Perform the actions needed to create a new account in the system.
     * <p>
     * The system will look for the SignUp button and click it, then it will forward to the SignUpPage.
     * In the SignUpPage the system will require @firstName, @lastName, @email and @password to set their respective fields properly
     * and lastly it will click on the submit button, redirecting to the HomePage.
     * @param firstName to be set in @firstNameField at the Sign Up Form
     * @param lastName to be set in the @lastNameField at the Sign Up Form
     * @param email to be set in the @emailField at the Sign Up Form
     * @param password to be set in the @passwordField at the Sign Up Form
     * @return an instance of HomePage
     */
    public HomePage doCreateAccount(String firstName, String lastName, String email, String password) {
        SignUpPage signUpPage = this.clickSignUpButton();
        return signUpPage.doSignUpForm(firstName, lastName, email, password);
    }

    /**
     * Perform the actions required to disable/delete an account from the application, as the las step it will forward to
     * the confirmation page.
     * <p>
     * The system will assume that the user is already logged in and with a current active account.
     * The system then will perform a hovering action on the user icon, displaying the user action menu.
     * Then it will click on the button with text "ESPN Profile", where it will forward the driver context to this page (ProfilePage)
     * in this ProfilePage, the system will look for the Disable Account link (which is at the bottom, having to scroll) and click it.
     * After clicking this Disable Account link, the system will forward the context to the confirmation page (ConfirmDisableAccountPage)
     * where it will accept the action and be forwarded to the ConfirmationPage, at last.
     * @return an instance of AccountDisabilityPage
     */
    public AccountDisabilityPage doDisableAccount() {
        GlobalUserSection userSection = this.hoverOverUserIcon();
        ProfilePage profilePage = userSection.clickProfileLink();
        profilePage.scrollToDisableAccountLink();
        return profilePage.clickDisableAccount().clickConfirm();
    }

    /**
     * GlobalUserSection makes reference to the section displayed after doing a hover action to the User Icon on the top right
     * corner of the application.
     * @author juanpablo.vasquez
     */
    public class GlobalUserSection {
        /**
         * Section where all elements of GlobalUserSection can be located
         */
        private WebElement section;
        /**
         * Link to travel to Log In
         */
        private By logInLink = By.cssSelector(".user.hover a[tref*='login']");
        /**
         * Welcoming element of the GlobalUserSection, can be associated as its Header
         */
        private By welcomeElement = By.cssSelector(".user.hover li.display-user");
        /**
         * Link to log out from application and travel to HomePage
         */
        private By logOutLink = By.linkText("Log Out");
        /**
         * Link to travel to the User Profile
         */
        private By profileLink = By.linkText("ESPN Profile");
        /**
         * Overlay that appears when the user Profile is being open
         */
        private By profileOverlay = By.cssSelector("#did-ui-view > .content > .global-overlay");

        /**
         * The instantiation and start of context for the section
         * @param section
         */
        public GlobalUserSection (WebElement section) {
            this.section = section;
        }

        /**
         * Method to verify if the section is currently being displayed or not
         * @return the visibility status of the section
         */
        public boolean isDisplayed() {
            return section.isDisplayed();
        }

        /**
         * Action to click on the Log in link, forwarding the context to the LoginPage.
         * @return an instance of LoginPage
         */
        public LoginPage clickLogInLink() {
            clickElement(section.findElement(logInLink));
            return new LoginPage(getDriver(), getDriver().findElement(iFrame));
        }

        /**
         * Action to click on the Profile link, forwarding the context to the ProfilePage
         * @return an instance of ProfilePage
         */
        public ProfilePage clickProfileLink() {
            WebElement webIFrame = getDriver().findElement(iFrame);
            clickElement(section.findElement(profileLink));
            getDriver().switchTo().frame(webIFrame);
            getWait().until(ExpectedConditions.invisibilityOf(getDriver().findElement(profileOverlay)));
            getDriver().switchTo().defaultContent();
            return new ProfilePage(getDriver(), webIFrame);
        }

        /**
         * Action to click the Log Out link, forwarding the context to HomePage
         * @return an instance of HomePage
         */
        public HomePage clickLogOutLink() {
            clickElement(section.findElement(logOutLink));
            getWait().until(ExpectedConditions.stalenessOf(section.findElement(welcomeElement)));
            return new HomePage(getDriver());
        }

        /**
         * Retrieves the heading text of the section, which is a welcoming header.
         * @return the header string, welcoming user
         */
        public String getWelcomeText() {
            return section.findElement(welcomeElement).getText();
        }
    }
}
