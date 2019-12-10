package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class EnterTextPractice2 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement input = driver.findElement(By.name("email"));
        input.sendKeys("ykara@gmail.com", Keys.ENTER);

        WebElement result = driver.findElement(By.name("confirmation_message"));
        String ExpectedMassage ="Your e-mail's been sent!";
        String ActualResult = result.getText();
        if (ExpectedMassage.equals(ActualResult)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        driver.close();

    }
}
