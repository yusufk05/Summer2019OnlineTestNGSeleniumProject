package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class ActionsClass_HoverPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/hovers");
    }

    @Test(description = "Verify first image")
    public void Test1(){
        // Creat object of action class to perform actions
        Actions action =new Actions(driver);

        WebElement image1 = driver.findElement(By.cssSelector(".figure:nth-of-type(1)"));
        // We want to just hover to element not click!!!
        // .build() is required if we need more action
        // without .perform() it will not work
        action.moveToElement(image1).perform();

        WebElement textOfImageElement = driver.findElement(By.cssSelector(".figure:nth-of-type(1) h5"));
        String expectedText = "name: user1";
        String actualText = textOfImageElement.getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @Test(description = "Verify all images")
    public void Test2(){
        Actions action = new Actions(driver);
        for(int i=1; i<4; i++){
            action.moveToElement(driver.findElement(By.cssSelector(".figure:nth-of-type("+i+")"))).perform();
            BrowserUtils.wait(3);
            String actualResult = driver.findElement(By.cssSelector(".figure:nth-of-type("+i+") h5")).getText();
            System.out.println(actualResult);
            Assert.assertEquals(actualResult,"name: user"+i);
        }
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
