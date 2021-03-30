package pom.greetz;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(String url) {
        super(url);
    }

    public void login() {

        WebElement username = driver.findElement(By.xpath("//input[@data-qa-ref='login-email']"));
        username.click();
        username.sendKeys("sharutyunyan@mailinator.com" );

        WebElement password = driver.findElement(By.xpath("//input[@data-qa-ref='login-password']"));
        password.click();
        password.sendKeys("greetz123" + Keys.ENTER);

    }
}
