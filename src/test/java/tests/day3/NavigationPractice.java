package tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigationPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize(); // to maximize browser window

        driver.get("http://google.com");
        Thread.sleep(3000);

        driver.navigate().to("http://amazon.com");

        BrowserUtils.wait(3);

        // navigate back to google
        driver.navigate().back();

        BrowserUtils.wait(3);

        // move forward to amazon again
        driver.navigate().forward();

        // to refresh page
        driver.navigate().refresh();

        driver.close();
    }
}
