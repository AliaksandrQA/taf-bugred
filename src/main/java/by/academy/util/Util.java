package by.academy.util;

import by.academy.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util extends BasePage {
    public Util(WebDriver driver) {
        super(driver);
    }

    public String getResultMessage(By element) {
        waitForElementVisibility(element);
        return getDriver().findElement(element).getText();
    }
}
