package tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {
        // We have to set up WebDriver based on the browser that we gonna use
        WebDriverManager.chromedriver().setup();

        // We need to create an object of appropriate class
        ChromeDriver driver = new ChromeDriver();

        // let's open google
        // .get() method allows to open designated website
        driver.get("https://www.google.com/");

        // to read page title, there is method .getTitle()
        String actualResult = driver.getTitle();
        String expectedResult = "Google";
        if(actualResult.equals(expectedResult)){
            System.out.println("Test passed");
        }   else {
            System.out.println("Test failed");
        }

        // to close browser
        driver.close();


    }
}
