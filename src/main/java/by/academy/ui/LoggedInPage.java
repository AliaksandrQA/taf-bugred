package by.academy.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class LoggedInPage extends BasePage {
    protected final By loggedInUserCabinetInfo = By.xpath(" //a[@role='button' and @class='dropdown-toggle']");

    public LoggedInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserCabinetPresent() {
        return driver.findElement(loggedInUserCabinetInfo).isDisplayed();
    }

    public String getUserName() {
        waitForElementVisibility(loggedInUserCabinetInfo);
        return getDriver().findElement(loggedInUserCabinetInfo).getText();
    }

}
