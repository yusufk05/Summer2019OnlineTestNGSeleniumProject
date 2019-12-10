package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Set;

public class WindowSwitching {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }
    @Test(description = "Verify that title is still Practice")
    public void test1() {
        driver.findElement(By.linkText("New tab")).click();
        // after 3 seconds another Website will be opened in the second window
        // Selenium doesn't switch automatically to the new window
        BrowserUtils.wait(4);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Practice", "Title is wrong");
    }

    @Test(description = "Verify that user is able to see new window")
    public void test2(){
        driver.findElement(By.linkText("New tab")).click();
        // record id of original window, that we opened initially
        String oldWindow = driver.getWindowHandle();
        // After 3 seconds new window will open
        // Selenium doesn't switch automatically
        BrowserUtils.wait(5);
        // In the Selenium every window has an id. That id calls window handle
        // To read window handle we use a method getWindowHandle()
        // After the window was opened, we can get list of all window id's\ window handles
        // list - it's a data structure
        // set it's also a data structure, like list, but doesn't allow duplicates
        // also, you cannot easily access anything from there
        // there is no .get() method
        // thats why we need to loop thorough the set to read a data from there
        // set can store only unique values
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println(windowHandles);
        for(String windowHandle: windowHandles){
            // If it's not old window switch to new window
            if(!windowHandle.equals(oldWindow)){
                System.out.println(oldWindow);
                System.out.println(windowHandle);
                driver.switchTo().window(windowHandle);
            }
        }
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Fresh tab", "old tab");
        // COMEBACK ORIGINAL PAGE
        for(String windowHandle: windowHandles){
            //keep jumping from window to window once we found ORIGINAL PAGE
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals("Practice"));
            break;
        }
        Assert.assertEquals(driver.getTitle(), "Practice", "Not Original");



    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}