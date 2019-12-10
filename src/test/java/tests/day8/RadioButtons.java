package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class RadioButtons {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        // To go Radio Buttons Page
        // If element have <a> tag we can use "By.LinkText" <a href="/radio_buttons">Radio Buttons</a>
        driver.findElement(By.linkText("Radio Buttons")).click();
    }

    @Test(description = "Verify that blue button is selected")
    public void test1(){
        // Find blue radio button
        WebElement blueButton = driver.findElement(By.id("blue"));
        // Verify that radio button is selected
        // assertTrue that button is selected
        // If button is selected it will return true otherwise false
        Assert.assertTrue(blueButton.isSelected());
    }

    @Test(description = "Verify that red button is not selected")
    public void test2(){
        WebElement redButton = driver.findElement(By.id("red"));
        Assert.assertFalse(redButton.isSelected());
    }

    @Test(description = "Verify that green button is not clickable")
    public void test3(){
        WebElement greenButton = driver.findElement(By.id("green"));
        Assert.assertFalse(greenButton.isEnabled());
    }

    // Let's find all radio buttons and click on them one by one

    @Test(description = "Click all radio buttons one by one")
    public void test4(){
        WebElement blueButton = driver.findElement(By.id("blue"));
        WebElement redButton = driver.findElement(By.id("red"));
        WebElement yellowButton = driver.findElement(By.id("yellow"));
        WebElement blackButton = driver.findElement(By.id("black"));
        WebElement greenButton = driver.findElement(By.id("green"));

        if(blueButton.isSelected()){
            BrowserUtils.wait(2);
            redButton.click();
            BrowserUtils.wait(2);
            yellowButton.click();
            BrowserUtils.wait(2);
            blackButton.click();
            BrowserUtils.wait(2);
        }
        Assert.assertFalse(greenButton.isEnabled());
    }

    @Test(description = "REAL Click all radio buttons one by one")
    public void test4_1(){
        // Any radio button will have type='radio'
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        // Lets click only if button is not clicked and is available for clicking
        for(WebElement button: radioButtons){
            if(button.isEnabled() && !button.isSelected()){
                button.click();
                System.out.println("Button Clicked: "+button.getAttribute("id"));
            } else {
                System.out.println(("Button was not clicked: "+button.getAttribute("id")));
            }
            BrowserUtils.wait(1);
        }

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
