package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver driver;

    private Driver(){
    }

    public static WebDriver get(){
        // if Webdriver object was not created yet
        if(driver==null){
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    // If Browser type is wrong, stop test and throw exception
                    throw new RuntimeException("Wrong Browser Type");
            }
        }return driver;
    }

    public static void close(){
        if(driver != null){
            //close all drive
            driver.quit();
            // destroy driver object
            driver = null;
        }
    }


}
