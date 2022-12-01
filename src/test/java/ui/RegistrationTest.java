package ui;

import by.academy.steps.RegistrationSteps;
import by.academy.ui.LoggedInPage;
import by.academy.util.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static by.academy.driver.DriverSingleton.getDriver;

public class RegistrationTest extends BaseTest {
    RegistrationSteps registrationSteps;

    @Test
    public void checkRegistrationPageElements() {
        registrationSteps = new RegistrationSteps(getDriver());
        Assertions.assertTrue(registrationSteps.isRegistrationFieldsPresent());
    }

    @Test
    public void checkProperRegistrationProcedure() {
        registrationSteps = new RegistrationSteps(getDriver());
        String name = User.generateRandomUserData();
        String password = User.generateRandomUserData();
        String email = User.generateRandomUserEmail();
        LoggedInPage registeredUser = registrationSteps.validUserRegistration(name, email, password);

        Assertions.assertEquals(name, registeredUser.getUserName());
    }
    @Test
    public void checkInvalidRegistrationProcedure() {
        registrationSteps = new RegistrationSteps(getDriver());
        String name = User.generateRandomUserData();
        String password = User.generateRandomUserData();
        String invalidEmail = User.generateRandomUserData();
        registrationSteps.userRegistrationWithoutEmail(name, invalidEmail, password);

        Assertions.assertTrue(registrationSteps.isIncorrectEmailMessagePresent());
    }
}
