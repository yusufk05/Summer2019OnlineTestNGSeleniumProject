package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class CSSselectorPractice {

    // Which locator to use?
    //#1 id
    //#2 CSS
    //#3 xpath
    //#4 whatever
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        // lets find all buttons, and click on them one by one
        // we put '.' because it's 2 class names --> .btn.btn-primary
        // in this case we'll find all buttons that have: class="btn btn-primary"
        // [class='btn btn-primary'] no need '.'
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
        // loop through list of buttons
        for(WebElement button: buttons){
            // click all buttons one by one
            button.click();
            BrowserUtils.wait(1);
            //get massage after click
        }



        driver.quit();
    }
}
