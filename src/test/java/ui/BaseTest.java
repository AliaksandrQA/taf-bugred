package ui;

import by.academy.driver.DriverSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {


    @BeforeEach
    public void setWebDriver() {

    }

    @AfterEach
    public void closeWebDiver() {
        DriverSingleton.closeDriver();
    }
}
