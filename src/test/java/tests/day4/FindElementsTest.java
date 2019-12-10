package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FindElementsTest {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        String ExpectedTitle = driver.getTitle();

        WebElement text = driver.findElement(By.name("email"));
        text.sendKeys("ykara@gmail.com");
        BrowserUtils.wait(3);

        // Create object of WebElement and use WebElement
        WebElement button = driver.findElement(By.id("form_submit"));
        // to click on the element
        button.click();
        BrowserUtils.wait(2);

        String ActualTitle = driver.getTitle();
        if(ExpectedTitle.equals(ActualTitle)){
            System.out.println("Test Passed");
        }   else{
            System.out.println("Test Failed");
            System.out.println("Expected Title is: "+ExpectedTitle);
            System.out.println("Actual Title is: "+ActualTitle);
        }

        WebElement result = driver.findElement(By.name("confirmation_message"));
        System.out.println(result.getText());
        driver.close();


    }
}
