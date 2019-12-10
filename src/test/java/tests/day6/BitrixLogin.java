package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class BitrixLogin {
    //helpdesk59@cybertekschool.com
    //UserUser
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //go to bitrix
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        //enter email
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk59@cybertekschool.com");
        //enter password
        // * means --> matches any element
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("UserUser");
        // click Log in
        driver.findElement(By.xpath("//input[@class='login-btn']")).click();
        BrowserUtils.wait(3);
        driver.quit();

    }
}
