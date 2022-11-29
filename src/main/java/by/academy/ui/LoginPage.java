package by.academy.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    protected final By emailField = By.xpath("//input[@name='login']");
    protected final By passwordField = By.xpath("//form[@action='/user/login/index.html']/table/tbody/tr[2]/td[2]//input");
    protected final By authorizationButton = By.xpath("//input[@value='Авторизоваться']");
    protected final By loginTitle = By.xpath("//body/div[3]/div[1]/div[1]/h2");
    protected final By helpAuthorizationMessage = By.xpath("/html/body/div[3]/div[1]/div[1]/p");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmailFieldPresent() {
        return driver.findElement(emailField).isDisplayed();
    }

    public boolean isPasswordFieldPresent() {
        return driver.findElement(passwordField).isDisplayed();
    }

    public boolean isAuthorizationButtonPresent() {
        return driver.findElement(authorizationButton).isDisplayed();
    }

    public boolean isLoginTitlePresent() {
        return driver.findElement(loginTitle).isDisplayed();
    }

    public boolean isAuthorizationMessagePresent() {
        return driver.findElement(helpAuthorizationMessage).isDisplayed();
    }

    public LoginPage enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoggedInPage clickAuthorizationButton() {
        driver.findElement(authorizationButton).click();
        return new LoggedInPage(getDriver());
    }
}
