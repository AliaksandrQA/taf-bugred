package by.academy.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;

public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver(){
        System.setProperty("browser", "chrome"); // без этого иногда не запускается
        if (null == driver){
            switch (System.getProperty("browser")){
                case "firefox": {
                    firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.get("http://users.bugred.ru/user/login/index.html");
                }
                default: {
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    driver.get("http://users.bugred.ru/user/login/index.html");
                }
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
