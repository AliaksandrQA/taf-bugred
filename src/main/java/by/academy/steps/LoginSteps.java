package by.academy.steps;

import by.academy.ui.BasePage;
import by.academy.ui.LoggedInPage;
import by.academy.ui.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginSteps extends BasePage {
    LoginPage loginPage = new LoginPage(getDriver());

    public LoginSteps(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginFieldsPresent() {
        return loginPage.isLoginTitlePresent() &&
                loginPage.isEmailFieldPresent() &&
                loginPage.isPasswordFieldPresent() &&
                loginPage.isAuthorizationButtonPresent() &&
                loginPage.isAuthorizationMessagePresent();
    }

    public boolean isAuthorizationHelpMessagePresent() {
        return loginPage.isAuthorizationMessagePresent();
    }

    public LoggedInPage validLogin(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickAuthorizationButton();
        return new LoggedInPage(getDriver());
    }

    public LoginPage invalidLogin(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickAuthorizationButton();
        return new LoginPage(getDriver());
    }
}
