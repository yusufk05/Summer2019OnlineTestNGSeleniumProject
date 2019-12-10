package tests.day5;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class TestForTageNameLocator {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

    //    driver.findElement(By.name("full_name")).sendKeys("Test User");
    //    driver.findElement(By.name("email")).sendKeys("test_email@email.com");
    //    driver.findElement(By.name("wooden_spoon")).click();




    }
}
