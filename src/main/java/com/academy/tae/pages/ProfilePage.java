package com.academy.tae.pages;

import com.academy.tae.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * ProfilePage is representing the Profile page in the browser, it defines the usable elements and performable actions
 * @author juanpablo.vasquez
 */
public class ProfilePage extends BasePage {
    /**
     * Frame where the ProfilePage is displayed, and its elements can be reached
     */
    private WebElement iFrame;
    /**
     * Section under frame, where all elements are located, without the excess widths and heights
     */
    private By scrollableSection = By.id("did-ui-view");
    /**
     * Button to disable account, that travels to ConfirmDisableAccountPage
     */
    private By disableAccountLink = By.id("cancel-account");

    /**
     * Basic instantiation of elements and context
     * @param driver to set default context
     * @param iFrame to switch the context
     */
    public ProfilePage(WebDriver driver, WebElement iFrame) {
        super(driver);
        this.iFrame = iFrame;
        getDriver().switchTo().frame(iFrame);
    }

    /**
     * Performs the scroll action in the ProfilePage to the bottom of the page, where the disableAccountLink is located
     */
    public void scrollToDisableAccountLink() {
        WebElement disableAccount = getDriver().findElement(disableAccountLink);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true)", disableAccount);
    }

    /**
     * Performs the Confirmation to the flow of Disable Account, then it forwards the application context to the Confirmation page
     * @return an instance of ConfirmDisableAccountPage
     */
    public ConfirmDisableAccountPage clickDisableAccount() {
        clickElement(getDriver().findElement(disableAccountLink));
        getDriver().switchTo().defaultContent();
        return new ConfirmDisableAccountPage(getDriver(), iFrame);
    }
}
