package com.academy.tae.pages;

import com.academy.tae.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page class, illustrating the page or section where the system asks for confirmation before disabling the account.
 * <p>
 * Flow: Disable Account
 * @author juanpablo.vasquez
 */
public class ConfirmDisableAccountPage extends BasePage {
    /**
     * Frame where the page is located
     */
    private WebElement iFrame;
    /**
     * Section of the @iFrame, where all elements can be located
     */
    private By section = By.cssSelector("#did-ui-view .workflow-deactivate");
    /**
     * Header of the section, as well as the title page
     */
    private By sectionHeader = By.cssSelector("#did-ui-view .workflow-deactivate");
    /**
     * Button to confirm an action
     */
    private By confirmAction = By.cssSelector("#did-ui-view .workflow-deactivate button[ng-click*='confirm']");

    /**
     * constructor method of ConfirmDisableAccountPage, its set to set the context of the page and access certain elements
     * that are inside certain IFrame
     * <p>
     * Flow: Disable Account
     * @param driver to set the context
     * @param iFrame to switch the context
     */
    public ConfirmDisableAccountPage(WebDriver driver, WebElement iFrame) {
        super(driver);
        this.iFrame = iFrame;
        getDriver().switchTo().frame(iFrame);
    }

    /**
     * Method to interact with the "confirm" element in the current context, it uses the common clickElement function.
     * it waits then for the application to load, verifying the stalenessOf method on the current Header and finally
     * switches back to the default driver context.
     * @return AccountDisabilityPage instance (new)
     */
    public AccountDisabilityPage clickConfirm() {
        clickElement(getDriver().findElement(confirmAction));
        getWait().until(ExpectedConditions.stalenessOf(getDriver().findElement(sectionHeader)));
        getDriver().switchTo().defaultContent();
        return new AccountDisabilityPage(getDriver(), iFrame);
    }


}
