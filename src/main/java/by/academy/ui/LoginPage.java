package by.academy.ui;

import org.openqa.selenium.By;

public class LoginPage {
    protected final By emailField = By.xpath("//input[@name='login']");
    protected final By passwordField = By.xpath("//form[@action='/user/login/index.html']/table/tbody/tr[2]/td[2]");
    protected final By authorizationButton = By.xpath("//input[@value='Авторизоваться']");
    protected final By loginTitle = By.xpath("//body/div[3]/div[1]/div[1]/h2");
    protected final By greetingsTitle = By.xpath("/html/body/div[3]/div[1]/div[1]/p");
}
