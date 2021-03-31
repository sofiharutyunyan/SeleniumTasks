package pom.greetz;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.BasePage;

import java.sql.Driver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {

        driver.get("https://www.greetz.nl/auth/login");

        WebElement elUsername = driver.findElement(By.xpath("//input[@data-qa-ref='login-email']"));
        elUsername.click();
        elUsername.sendKeys(username);

        WebElement elPassword = driver.findElement(By.xpath("//input[@data-qa-ref='login-password']"));
        elPassword.click();
        elPassword.sendKeys(password + Keys.ENTER);

    }
}
