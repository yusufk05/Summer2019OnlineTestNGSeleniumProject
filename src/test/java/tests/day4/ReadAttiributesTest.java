package tests.day4;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class ReadAttiributesTest {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement input = driver.findElement(By.name("email"));
        System.out.println(input.getAttribute("pattern"));
        input.sendKeys("email@email.com");

        // how to read entered text?
        // it's gonna be inside value attirubute
        System.out.println(input.getAttribute("value"));

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        //Alternative to click (only if type = "submit"
        retrievePasswordButton.submit();
        driver.close();
    }
}
