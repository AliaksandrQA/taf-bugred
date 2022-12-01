package ui;

import by.academy.steps.LoginSteps;
import by.academy.ui.LoggedInPage;
import by.academy.ui.LoginPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static by.academy.driver.DriverSingleton.getDriver;

public class LoginTest extends BaseTest {
    LoginSteps steps;

    @Test
    public void checkLoginPageElements() {
        steps = new LoginSteps(getDriver());
        Assertions.assertTrue(steps.isLoginFieldsPresent());

    }

    @Test
    public void checkProperLoginProcedure() {
        steps = new LoginSteps(getDriver());
        String testUserMail = "testUser0101@gmail.com";
        String testUserPassword = "1111";

        LoggedInPage loggedInUser = steps.validLogin(testUserMail, testUserPassword);

        Assertions.assertTrue(loggedInUser.isUserCabinetPresent());
    }

    @Test
    public void checkLoginWithInvalidPassword() {
        steps = new LoginSteps(getDriver());
        String testUserMail = "testUser0101@gmail.com";
        String testUserPassword = "2222";

        LoginPage invalidUser = steps.invalidLogin(testUserMail, testUserPassword);

        Assertions.assertTrue(invalidUser.isAuthorizationMessagePresent());
    }
    @Test
    public void checkLoginWithInvalidEmail() {
        steps = new LoginSteps(getDriver());
        String testUserMail = "test01User0101@gmail.com";
        String testUserPassword = "1111";

        LoginPage invalidUser = steps.invalidLogin(testUserMail, testUserPassword);

        Assertions.assertTrue(invalidUser.isAuthorizationMessagePresent());
    }

}
