package homepage;

import browserTesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://tutorialsninja.com/demo/index.php";
    @Before
    public void setupTest() {
        openBrowser(baseUrl);
    }

    public void selectMenu (String menu) {
        driver.findElement(By.linkText(menu)).click();
    }


    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        Actions action = new Actions(driver);
        WebElement desktopsTab = driver.findElement(By.xpath("//a[text()='Desktops']"));
        action.moveToElement(desktopsTab).click().perform();
        selectMenu("Show AllDesktops");

        //String expectedTitle = "Desktops"; //1.1 Method
        //String actualTitle = driver.getTitle(); //1.2 Method
        //assertEquals("Desktops",actualTitle, expectedTitle); //1.3 Method
        assertEquals("Desktops", driver.findElement(By.xpath("//h2[text()='Desktops']")).getText()); // 2 method

    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
          Actions action = new Actions(driver);
          WebElement laptopsAndNotebooksTab = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
          action.moveToElement(laptopsAndNotebooksTab).click().perform();
          selectMenu("Show AllLaptops & Notebooks");

          //String expectedTitle = "Desktops"; //1.1 Method
          //String actualTitle = driver.getTitle(); //1.2 Method
          //assertEquals("Laptops & Notebooks",actualTitle, expectedTitle); //1.3 Method
          assertEquals("Laptops & Notebooks", driver.findElement(By.xpath("//h2[text()='Laptops & Notebooks']")).getText()); // 2 method
      }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        Actions action = new Actions(driver);
        WebElement componentsTab = driver.findElement(By.xpath("//a[text()='Components']"));
        action.moveToElement(componentsTab).click().perform();
        selectMenu("Show AllComponents");

        //String expectedTitle = "Desktops"; //1.1 Method
        //String actualTitle = driver.getTitle(); //1.2 Method
        //assertEquals("Components",actualTitle, expectedTitle); //1.3 Method
        assertEquals("Components", driver.findElement(By.xpath("//h2[text()='Components']")).getText()); // 2 method
    }




    @After
    public void tearDown() {
       closeBrowser();
    }
}
