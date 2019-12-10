package VyTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class Tests {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("Chrome");
        driver.manage().window().maximize();


        // load the page
        driver.get("http://qa2.vytrack.com/user/login");

        // get the input box and assign it to the username web element
        WebElement username = driver.findElement(By.name("_username"));

        //fill the information
        username.sendKeys("user183");

        // get the input box for password
        WebElement password = driver.findElement(By.name("_password"));

        // send keys to password element
        password.sendKeys("UserUser123");

        // get the element button
        WebElement button = driver.findElement(By.id("_submit"));

        // click that button
        button.click();



    }
}
