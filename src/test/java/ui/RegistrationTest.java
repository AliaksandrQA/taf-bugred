package ui;

import by.academy.steps.RegistrationSteps;
import by.academy.ui.LoggedInPage;
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
        String name = "avid03";
        String email = "test01@ebay.com";
        String password = "1000";
        LoggedInPage registeredUser = registrationSteps.validUserRegistration(name, email, password);

        Assertions.assertEquals(name, registeredUser.getUserName());
    }
    @Test
    public void checkInvalidRegistrationProcedure() {
        registrationSteps = new RegistrationSteps(getDriver());
        String name = "Cavid03";
        String invalidEmail = "applecom";
        String password = "1000";
        registrationSteps.userRegistrationWithoutEmail(name, invalidEmail, password);

        Assertions.assertTrue(registrationSteps.isIncorrectEmailMessagePresent());
    }
}
