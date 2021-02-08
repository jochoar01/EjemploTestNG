package com.academy.tae.pages;

import com.academy.tae.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page class to illustrate the Page that shows the confirmation of the flow: "Disable Account"
 * @author juanpablo.vasquez
 */
public class AccountDisabilityPage extends BasePage {
    /**
     * Frame where the page is located
     */
    private WebElement iFrame;
    /**
     * Section inside the frame, where all the elements can be located
     */
    private By section = By.cssSelector("#did-ui-view .workflow-deactivate");
    /**
     * Header of the @section, title of the page.
     */
    private By sectionHeader = By.cssSelector("#did-ui-view .workflow-deactivate .title");

    /**
     * instantiation of AccountDisabilityPage, this page is set to properly access certain elements in the flow,
     * such as headers or buttons.
     * <p>
     * Its elements are inside an IFrame tag so it must switch to the proper context.
     * @param driver to set the context
     * @param iFrame to switch context
     */
    public AccountDisabilityPage(WebDriver driver, WebElement iFrame) {
        super(driver);
        this.iFrame = iFrame;
        getDriver().switchTo().frame(iFrame);
    }

    /**
     * Page Header, only accessible from this location.
     * @return the page header
     */
    public String getHeader() {
        return getDriver().findElement(sectionHeader).getText();
    }
}
