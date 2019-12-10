package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FramesPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/frames");
    }

    @Test(description = "iFrame exapmle")
    public void Test1(){
        driver.findElement(By.linkText("iFrame")).click();

        // Since element inside the frame element is not visible for Selenium without switching to the frame
        // We can switch to frame based on id, name, index(from 0), WebElement
        driver.switchTo().frame("mce_0_ifr");

        WebElement inputArea = driver.findElement(By.id("tinymce"));
        String expectedText = "Your content goes here.";
        String actualText = inputArea.getText();
        Assert.assertEquals(actualText, expectedText );

        BrowserUtils.wait(2);
        inputArea.clear();
        BrowserUtils.wait(2);
        inputArea.sendKeys("Java is fun!");

        // to exit from frame
        driver.switchTo().defaultContent();
    }

    // in case of nested frames
    // we must switch to first frame then another frame
    @Test(description = "Nested Frames examples")
    public void Test2(){
        driver.findElement(By.linkText("Nested Frames")).click();

        driver.switchTo().frame(driver.findElement(By.cssSelector("[name='frame-bottom']")));
        WebElement content = driver.findElement(By.tagName("body"));
        System.out.println(content.getText());

        // Firstly we need to navigate to default then other levels one by one
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println(driver.findElement(By.tagName("body")).getText());

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }



}
