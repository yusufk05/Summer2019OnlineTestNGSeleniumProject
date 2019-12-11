package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class JSExecutorPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
    }

    @Test(description = "Scrolling with JavaScriptExecutor")
    public void Test1(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for(int i = 0 ; i<11; i++){
            js.executeScript("window.scrollBy(0,500)");
            BrowserUtils.wait(1);
        }
            BrowserUtils.wait(2);
    }

    @Test(description = "Scrolling with JSExecutor to specific element")
    public void Test2(){
        driver.get("http://practice.cybertekschool.com/large");
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        BrowserUtils.wait(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // arguments[0] means first WebElement after comma link
        // arguments is an array of webelements after comma
        js.executeScript("arguments[0].scrollIntoView(true)", link);
        BrowserUtils.wait(2);
    }

    @Test(description = "Click with JS executer")
    public void Test3(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        WebElement link1 = driver.findElement(By.partialLinkText("Example 1"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",link1);
        BrowserUtils.wait(2);
    }

    // document.getElementsByName('full_name')[0].setAttribute('value','myname')
    @Test(description = "Enter Text with JS Executer")
    public void Test4(){
       driver.get("http://practice.cybertekschool.com/sign_up");
       WebElement name = driver.findElement(By.name("full_name"));
       WebElement email = driver.findElement(By.name("email"));
       WebElement submit = driver.findElement(By.name("wooden_spoon"));

       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].setAttribute('value','John Smith')", name );
       js.executeScript("arguments[0].setAttribute('value','some@email.com')", email);
       BrowserUtils.wait(2);
       js.executeScript("arguments[0].click()", submit);
       BrowserUtils.wait(2);
        System.out.println("Hello Joseph");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
