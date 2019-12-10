package tests.day11;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class testPizza {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");



        for (int i=0; i<10; i++) {
            driver.get("https://www.google.com/");
            driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("pizza lake mary", Keys.ENTER);
            driver.findElement(By.partialLinkText("Diginos Pizza Lake Mary - Food delivery - Lake Mary")).click();
            i++;
        }
        driver.quit();
    }
}
