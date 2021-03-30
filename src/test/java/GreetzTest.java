import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pom.greetz.BasePage;
import pom.greetz.LoginPage;

public class GreetzTest extends BaseTest {

    @Test
    private void addItemInBag(){
        LoginPage loginPage = new LoginPage("https://www.greetz.nl/auth/login");
        waitUntilElementIsVisible(By.xpath("//input[@data-qa-ref='login-email']"));
        loginPage.login();
    }

}
