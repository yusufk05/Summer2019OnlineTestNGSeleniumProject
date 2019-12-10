package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGPractice {

    @Test
    public void test() {
        Assert.assertEquals("apple","apple");
    }

    @Test(description = "Verifying title of the practice website")
    public void verifyTitle(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title is wrong");
        driver.quit();
    }

    // Let's verify that "Test Automation Practice" heading is displayed
    @Test(description = "Verify that heading is displayed")
    public void verifyHeadingIsDisplayed(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        WebElement heading = driver.findElement(By.xpath("//span[text()='Test Automation Practice']"));
        // to make sure that element is visible
        // because elemet can be present, but not visible
        // we need to make sure element is visible
        Assert.assertTrue(heading.isDisplayed(),"Element is not visible Bro");
        driver.quit();
    }






    /* The one that i wrote
    // Let's verify that "Test Automation Practice" heading is displayed
    @Test
    public void verifyHeadingIsDisplayed(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        String expectedHeading = "Test Automation Practice";
        String actualHeading = driver.findElement(By.className("h1y")).getText();
        Assert.assertEquals(actualHeading,expectedHeading,"Head is wrong");
        driver.quit();
    }
    */
























}
