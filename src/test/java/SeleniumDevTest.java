import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumDevTest extends BaseTest{

    @BeforeMethod
    protected void beforeMethod(){

        driver.get("https://www.selenium.dev/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@id='navbar']")));
    }

    @Test
    private void openBrowserClickDownloads(){
        WebElement downloads = driver.findElement(By.linkText("Downloads"));
        downloads.click();

        By locStableVersion = By.xpath("//p[text()='Latest stable version ']//a");
        waitUntilElementIsVisible(locStableVersion);

        String expectedResult = "3.141.59";
        String actualResult = driver.findElement(locStableVersion).getText();

        Assert.assertEquals(actualResult, expectedResult, "The version is not the latest stable one.");
    }

    @Test
    private void searchText(){
        WebElement searchBar = driver.findElement(By.name("search"));
        String searchText = "selenium webdriver";
        searchBar.click();
        searchBar.sendKeys(searchText + Keys.ENTER);

        By locSearchBar = By.xpath("//div[@class='gsc-expansionArea']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locSearchBar));

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='gs-title']//a[@target]"));

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locSearchBar, 0));

        boolean alreadyFound = false;
        for (WebElement element : searchResults) {
            if (element.getText().toLowerCase().contains(searchText)){
                alreadyFound = true;
                break;
            }
        }

        Assert.assertTrue(alreadyFound, "Search results are more than 0.");
    }

    @AfterMethod
    private void afterMethod() throws InterruptedException {
        driver.quit();
    }
}
