package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class EnterTextPractice {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        // Write Credentials
        WebElement inputBox = driver.findElement(By.name("email"));
        inputBox.sendKeys("ykara@gmail.com");

        // Click Sign in
        WebElement button = driver.findElement(By.id("form_submit"));
        button.click();
        BrowserUtils.wait(2);
        String Expected = "http://practice.cybertekschool.com/email_sent";
        String Actual = driver.getCurrentUrl();

        if(Actual.equals(Expected)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected URL: "+Expected);
            System.out.println("Actual URL: "+Actual);
        }

        driver.close();


    }
}
