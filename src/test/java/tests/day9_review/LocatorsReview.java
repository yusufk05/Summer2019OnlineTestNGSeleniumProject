package tests.day9_review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class LocatorsReview {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test(description = "Verify Checkboxes")
    public void test1(){
        driver.findElement(By.linkText("Checkboxes")).click();
        // [type='checkbox'] there are 2 elements with same locator
        // I need only first one so i can use cssSelector --> [type='checkbox']:nth-of-type(index) 2nd, 3rd, 4th...
        //any tag or tag + attributes :nth-of-type(index)
        WebElement checkbox1 = driver.findElement(By.cssSelector("[type='checkbox']:nth-of-type(1)"));
        //how to verify if checkbox is not clicked???
        Assert.assertFalse(checkbox1.isSelected(), "Checkbox 1 was selected"); // assert
        // Secend checkbox
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        Assert.assertTrue(checkbox2.isSelected(),"Checkbox 2 was not selected");


    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
