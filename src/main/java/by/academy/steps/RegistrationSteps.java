package by.academy.steps;

import by.academy.ui.BasePage;
import by.academy.ui.LoggedInPage;
import by.academy.ui.RegistrationPage;
import org.openqa.selenium.WebDriver;

public class RegistrationSteps extends BasePage {
    RegistrationPage registrationPage = new RegistrationPage(getDriver());

    public RegistrationSteps(WebDriver driver) {
        super(driver);
    }

    public boolean isRegistrationFieldsPresent() {
        return registrationPage.isUserNameFieldPresent() &&
                registrationPage.isEmailFieldPresent() &&
                registrationPage.isPasswordFieldPresent() &&
                registrationPage.isRegistrationButtonPresent() &&
                registrationPage.isRegistrationTitlePresent();
    }

    public LoggedInPage validUserRegistration(String name, String email, String password) {
        registrationPage.enterUserName(name);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.clickRegistrationButton();
        return new LoggedInPage(getDriver());
    }


    public RegistrationPage userRegistrationWithoutEmail(String name, String password,String email) {
        registrationPage.enterUserName(name);
        registrationPage.enterPassword(password);
        registrationPage.enterEmail(password);
        registrationPage.clickRegistrationButton();
        return new RegistrationPage(getDriver());
    }
    public boolean isIncorrectEmailMessagePresent() {
        return registrationPage.isIncorrectEmailNotificationPresent();
    }
}
