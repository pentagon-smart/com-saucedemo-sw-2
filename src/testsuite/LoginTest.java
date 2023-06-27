package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
//      Enter “standard_user” username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
//      Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
//      Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
//     Verify the text “PRODUCTS”

        String expectedText = "PRODUCTS";
        String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals("PRODUCTS is not displayed", expectedText, actualText);

    }


    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
//      Enter “standard_user” username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
//      Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
//      Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
//   Verify that six products are displayed on page

        List<WebElement> productNumber = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        System.out.println("Product Number is: " +productNumber.size());
    }

    @After
    public void tearUp() {
        closeBrowser();
    }

}
