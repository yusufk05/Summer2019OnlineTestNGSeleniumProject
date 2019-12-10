package tests.day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class PopUpPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test(description = "Click OK in pop up message")
    public void test1(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        BrowserUtils.wait(2);
        // To deal with popup We can create object of Alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
        BrowserUtils.wait(2);
    }

    @Test(description = "Click on CANCEL in PopUp message")
    public void test2(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[2]")).click();
        BrowserUtils.wait(2);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
        System.out.println(driver.findElement(By.id("result")).getText());
    }

    @Test(description = "Click on button 3 and enter some text and then click OK")
    public void test3(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        BrowserUtils.wait(2);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Sorry");
        BrowserUtils.wait(2);
        alert.accept();
        BrowserUtils.wait(2);
        System.out.println(driver.findElement(By.id("result")).getText());


    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
