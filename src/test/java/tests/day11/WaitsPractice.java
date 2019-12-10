package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitsPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test
    public void test1(){
        //this line should be before all findElement() methods
        //to wait within 10 seconds, until element is present
        //we apply it once, and it always works
        //put this line into @BeforeMethod and it will work for all tests
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Dynamic Loading")).click();
        //partialLinkText we match only part of the link text
        //partialLinkText it's like contains text
        //Example 2: Element on the page that is rendered after the trigger - link text
        //Example 2 - only part of the link text
        //we can use partialLinkText locator to find element by partial text
        driver.findElement(By.partialLinkText("Example 2")).click();
        driver.findElement(By.tagName("button")).click();
        //this is for "Hello World!"
        WebElement finishElement = driver.findElement(By.id("finish"));
        System.out.println(finishElement.getText());

    }

    @Test
    public void test2(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 1")).click();
        driver.findElement(By.tagName("button")).click();

        WebElement userNameInputBox = driver.findElement(By.id("username"));
        // Explicit Wait
        // We create object of WebDriverWait to apply explicit Way

        WebDriverWait wait = new WebDriverWait(driver,10);
        //How to apply condition
        wait.until(ExpectedConditions.visibilityOf(userNameInputBox));
        //enter Username
        userNameInputBox.sendKeys("tomsmith");
        //enter Password

        WebElement passwordInputBox = driver.findElement(By.id("pwd"));
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();


        WebElement message = driver.findElement(By.tagName("h4"));
        wait.until(ExpectedConditions.visibilityOf(message));
        String ExpectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String ActualMessage = message.getText();

        Assert.assertEquals(ActualMessage, ExpectedMessage, "FAIL");
    }

    @Test
    public void Test3() {
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 5")).click();

        WebDriverWait wait = new WebDriverWait(driver,15);

        WebElement overlayScreen = driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']"));
        wait.until(ExpectedConditions.invisibilityOf(overlayScreen));

        WebElement userNameInputBox = driver.findElement(By.id("username"));
        userNameInputBox.sendKeys("tomsmith");
        //enter Password

        WebElement passwordInputBox = driver.findElement(By.id("pwd"));
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();


        WebElement message = driver.findElement(By.tagName("h4"));
        wait.until(ExpectedConditions.visibilityOf(message));
        String ExpectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String ActualMessage = message.getText();

        Assert.assertEquals(ActualMessage, ExpectedMessage, "FAIL");
    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
