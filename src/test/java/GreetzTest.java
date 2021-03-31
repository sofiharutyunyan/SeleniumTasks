import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.greetz.LoginPage;

public class GreetzTest extends BaseTest {

    @Test
    private void addItemInBag(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("sharutyunyan@mailinator.com", "greetz123");
    }

    /**
     * if this method is not overrighted the browser is not closing
     */
//    @AfterMethod
//    private void afterMethod() {
//        driver.quit();
//    }
}
