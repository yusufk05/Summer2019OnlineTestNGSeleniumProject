package tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserFactory;

public class BrowserFactoryTest {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        // now we can get webdriver with getDriver() method
        driver.get("http://practice.cybertekschool.com/");
        // how we can print a source code of the page?
        System.out.println(driver.getPageSource());

        driver.close();

    }
}
