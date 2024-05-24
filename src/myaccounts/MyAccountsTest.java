package myaccounts;

import browserTesting.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MyAccountsTest extends BaseTest {

        String baseUrl = "https://tutorialsninja.com/demo/index.php";

        @Before
        public void setupTest() {
            openBrowser(baseUrl);
        }

        public void selectMyAccountOptions(String option) {
            List <WebElement> options = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a"));
            for (WebElement opt : options) {
                if (opt.getText().equalsIgnoreCase(option)) {
                    opt.click();
                    break;
                }
            }
        }

        @Test
        public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
            driver.findElement(By.xpath("//span[text()='My Account']")).click();
            selectMyAccountOptions("Register");
            assertEquals("Register Account", driver.findElement(By.xpath("//h1[text()='Register Account']")).getText());
        }

        @Test
        public void verifyUserShouldNavigateToLoginPageSuccessfully(){
            driver.findElement(By.xpath("//span[text()='My Account']")).click();
            selectMyAccountOptions("Login");
            assertEquals("Returning Customer", driver.findElement(By.xpath("//h2[text()='Returning Customer']")).getText());
        }

        @Test
        public void verifyThatUserRegisterAccountSuccessfully(){
            driver.findElement(By.xpath("//span[text()='My Account']")).click();
            selectMyAccountOptions("Register");
            driver.findElement(By.id("input-firstname")).sendKeys("John");
            driver.findElement(By.id("input-lastname")).sendKeys("Doe");
            driver.findElement(By.id("input-email")).sendKeys("Johndoexy12345@gmail.com");
            driver.findElement(By.id("input-telephone")).sendKeys("437889998");
            driver.findElement(By.id("input-password")).sendKeys("Xyz@123");
            driver.findElement(By.id("input-confirm")).sendKeys("Xyz@123");

            driver.findElement(By.name("agree")).click();
            driver.findElement(By.xpath("//input[@value='Continue']")).click();

            assertEquals("Your Account Has Been Created!", driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText());
            driver.findElement(By.xpath("//a[text()='Continue']")).click();

            driver.findElement(By.linkText("My Account")).click();
            selectMyAccountOptions("Logout");

            assertEquals("Account Logout", driver.findElement(By.xpath("//h1[text()='Account Logout']")).getText());
            driver.findElement(By.xpath("//a[text()='Continue']")).click();
        }

        @Test
        public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
            driver.findElement(By.linkText("My Account")).click();
            selectMyAccountOptions("Login");

            driver.findElement(By.id("input-email")).sendKeys("Johndoexy12@gmail.com");
            driver.findElement(By.id("input-password")).sendKeys("Xyz@123");
            driver.findElement(By.xpath("//input[@value='Login']")).click();

            assertEquals("My Account", driver.findElement(By.xpath("//h2[text()='My Account']")).getText());

            driver.findElement(By.linkText("My Account")).click();
            selectMyAccountOptions("Logout");

            assertEquals("Account Logout", driver.findElement(By.xpath("//h1[text()='Account Logout']")).getText());
            driver.findElement(By.xpath("//a[text()='Continue']")).click();

        }

        @After
        public  void tearDown() {
           // closeBrowser();
        }
}
