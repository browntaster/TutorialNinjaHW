package laptopsandnotebooks;

import browserTesting.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class LaptopsAndNotebooksTest extends BaseTest {

    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setupTest() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        Actions action = new Actions(driver);
        WebElement laptopsAndNotebooksTab = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        action.moveToElement(laptopsAndNotebooksTab).click().perform();

        driver.findElement(By.linkText("Show AllLaptops & Notebooks")).click();

        Select sortBy = new Select(driver.findElement(By.id("input-sort")));
        sortBy.selectByVisibleText("Price (High > Low)");
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully(){
        Actions action = new Actions(driver);
        WebElement laptopsAndNotebooksTab = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        action.moveToElement(laptopsAndNotebooksTab).click().perform();

        driver.findElement(By.linkText("Show AllLaptops & Notebooks")).click();

        Select sortBy = new Select(driver.findElement(By.id("input-sort")));
        sortBy.selectByVisibleText("Price (High > Low)");

        driver.findElement(By.xpath("//a[text()='MacBook']")).click();
        assertEquals("MacBook", driver.findElement(By.xpath("//h1[text()='MacBook']")).getText());

        driver.findElement(By.id("button-cart")).click();
        WebElement successMessage = driver.findElement(By.cssSelector(".alert-success"));

        driver.findElement(By.xpath("//a[text()='shopping cart']")).click();
        assertEquals("Shopping Cart  (0.00kg)", driver.findElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")).getText());
       // assertEquals("MacBook", driver.findElement(By.xpath("//a[text()='MacBook']")).getText());
       // driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/form/div/table/tbody/tr/td[4]/div/input")).clear();
       // driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/form/div/table/tbody/tr/td[4]/div/input")).sendKeys("2");

       // assertEquals("$602.00", driver.findElement(By.xpath("//td[contains(text(),'$602.00')]")).getText());

        driver.findElement(By.linkText("Checkout")).click();

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
