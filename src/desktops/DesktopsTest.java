package desktops;

import browserTesting.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class DesktopsTest extends BaseTest {

    String baseUrl = "https://tutorialsninja.com/demo/index.php";
    @Before
    public void setupTest() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        Actions actions = new Actions(driver);
        WebElement desktopTab = driver.findElement(By.xpath("//a[text()='Desktops']"));
        actions.moveToElement(desktopTab).click().perform();
        driver.findElement(By.linkText("Show AllDesktops")).click();

        Select sortBy = new Select(driver.findElement(By.id("input-sort")));
        sortBy.selectByVisibleText("Name (Z - A)");

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully(){
        Actions actions = new Actions(driver);
        WebElement desktopTab = driver.findElement(By.xpath("//a[text()='Desktops']"));
        actions.moveToElement(desktopTab).click().perform();
        driver.findElement(By.linkText("Show AllDesktops")).click();

        Select sortBy = new Select(driver.findElement(By.id("input-sort")));
        sortBy.selectByVisibleText("Name (A - Z)");

      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.visibilityOf(JButton));

        driver.findElement(By.xpath("//a[text()='HP LP3065']")).click();
        assertEquals("HP LP3065", driver.findElement(By.xpath("//h1[text()='HP LP3065']")).getText());

        driver.findElement(By.xpath("//input[@id='input-option225']")).sendKeys("2022-11-30");
        driver.findElement(By.id("input-quantity")).clear();
        driver.findElement(By.id("input-quantity")).sendKeys("1");

        driver.findElement(By.id("button-cart")).click();

        WebElement successMessage = driver.findElement(By.cssSelector(".alert-success"));
        assertEquals(true, successMessage.getText().contains("Success: You have added HP LP3065 to your shopping cart!"));

        successMessage.findElement(By.linkText("shopping cart")).click();
        assertEquals("Shopping Cart", driver.findElement(By.xpath("//a[text()='Shopping Cart']")).getText());
        driver.findElement(By.xpath("//a[text()='HP LP3065']")).getText();
       // driver.findElement(By.xpath("//small[contains(text(),'2011-11-30')]")).getText();
        driver.findElement(By.xpath("//td[text()='Product 21']")).getText();
        driver.findElement(By.xpath("//td[text()='$122.00']")).getText();

    }




    @After
    public void tearDown() {
       // closeBrowser();
    }
}
