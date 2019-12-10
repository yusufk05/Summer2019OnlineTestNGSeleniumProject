package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class Dropdowns {
    private WebDriver driver;

    // <select id="dropdown">
    //      <option value="" disabled="disabled" selected="selected">Please select an option</option>
    //      <option value="1">Option 1</option>
    //      <option value="2">Option 2</option>
    //    </select>
    @BeforeMethod
    public  void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Dropdown")).click();
    }

    @Test(description = "Select option 2 from the dropdown")
    public void test1(){
    // To work with select dropdowns we need to use Select Class in Selenium
    // Step 1. Find Dropdown and create WebElement
        WebElement dropdown = driver.findElement(By.id("dropdown"));
    // Step 2. Create a select object
    // Select class requires webelemenr object as parameter
        Select select = new Select(dropdown);
    // To select any option by visible text:
        select.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
    // How to verify Option 2 is selected
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
    }

    @Test(description = "Print list of countries")
    public void test2(){
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
        // Will return availabe options
        List<WebElement> states = select.getOptions();

        for(WebElement option : states){
            System.out.println(option.getText());
        }
        // to select my state
        select.selectByValue("FL");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Florida");
        BrowserUtils.wait(2);

    }







    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
