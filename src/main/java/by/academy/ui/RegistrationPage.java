package by.academy.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    protected final By registrationButton = By.xpath("//input[@value='Зарегистрироваться']");
    protected final By usernameField = By.xpath("//input[@name='name']");
    protected final By registrationTitle = By.xpath("//body/div[3]/div[1]/div[2]/h2");
    protected final By emailField = By.xpath("/html/body/div[3]/div[1]/div[2]/form/table/tbody/tr[2]/td[2]/input");
    protected final By passwordField = By.xpath("/html/body/div[3]/div[1]/div[2]/form/table/tbody/tr[3]/td[2]/input");
    protected final By incorrectEmailNotification = By.xpath("/html/body/div[3]/div[1]/div[2]/form/p");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isRegistrationButtonPresent() {
        return driver.findElement(registrationButton).isDisplayed();
    }

    public boolean isUserNameFieldPresent() {
        return driver.findElement(usernameField).isDisplayed();
    }

    public boolean isRegistrationTitlePresent() {
        return driver.findElement(registrationTitle).isDisplayed();
    }

    public boolean isEmailFieldPresent() {
        return driver.findElement(emailField).isDisplayed();
    }

    public boolean isPasswordFieldPresent() {
        return driver.findElement(passwordField).isDisplayed();
    }

    public boolean isIncorrectEmailNotificationPresent() {
        return driver.findElement(incorrectEmailNotification).isDisplayed();
    }

    public RegistrationPage enterUserName(String email) {
        driver.findElement(usernameField).sendKeys(email);
        return this;
    }

    public RegistrationPage enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoggedInPage clickRegistrationButton() {
        driver.findElement(registrationButton).click();
        return new LoggedInPage(getDriver());
    }

}
