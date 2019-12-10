package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class ActionClass_DragAndDropPractice {

    @Test(description = "Drag and Drop Example")
    public void Test() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions action = new Actions(driver);

        WebElement moon = driver.findElement(By.id("draggable"));
        WebElement earth = driver.findElement(By.id("droptarget"));

        BrowserUtils.wait(3);
        action.dragAndDrop(moon,earth).perform();

        driver.quit();


    }
}
