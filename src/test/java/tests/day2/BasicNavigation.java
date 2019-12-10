package tests.day2;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {
        // if you have exception: cannot load a class
        // that means that package name, doesn't match with location of the class itself
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        // to maximize browser
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        // We want to navigate to the different page
        driver.navigate().to("http://amazon.com");

        // If i want to come back to the previous page
        driver.navigate().back();

        // If i want to know URL of current website
        String url = driver.getCurrentUrl();
        System.out.println(url);

        // Selenium cannot close browser automatically
        // So we use method close();


    }
}
