package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class WebTablesPractice {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));
    }

    @Test(description = "Print table1 data")
    public void Test1(){
        WebElement table = driver.findElement(By.id("table1"));
        System.out.println(table.getText());
    }

    @Test(description = "Verify that number of column equals 6 in the first table")
    public void Test2(){
        int actualColumnNumber = driver.findElements(By.xpath("//table[@id='table1']//th")).size();
        int expectedColumnNumber =6;
        Assert.assertEquals(actualColumnNumber,expectedColumnNumber,"Size is WRONG");
    }

    @Test(description = "Verify that number of rows are 5" )
    public void Test3(){
        int actualRowNumber = driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
        int expectedRowNumber = 5;
        Assert.assertEquals(actualRowNumber,expectedRowNumber,"Row numbers are wrong!!!");
    }

    @Test(description = "Print all values from the 2nd row(exclude table header) and others")
    public void TestEX1(){
        for(int i = 2; i<5; i++) {
            for(int j=1; j<7; j++) {
                System.out.print(driver.findElement(By.xpath("//table[@id='table1']//tr[" + i + "]//td[" + j + "]")).getText()+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void Test4(){
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[2]//td"));
        for (WebElement cell : row){
            System.out.println(cell.getText());
        }
    }

    @Test(description = "Print all values from the n-th row")
    public void Test5(){
        int index =1;
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr["+index+"]//td"));
        for (WebElement cell : row){
            System.out.println(cell.getText());
        }
    }

    @Test(description = "Verify that email in the 3rd row is equal -> jdoe@hotmail.com ")
    public void Test6(){
        WebElement email = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[3]//td[3]"));
        String expectedEmail = "jdoe@hotmail.com";
        String actualEmail = email.getText();
        Assert.assertEquals(actualEmail,expectedEmail,"Email is Different");
    }

    /*
        Get all values from email column and verify every value contains "@"
        if they dont have fail test
     */

    @Test(description = "Verify email has '@' ")
    public void Test7(){
        List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[3]"));
        for (WebElement email : emails){
            Assert.assertFalse(!email.getText().contains("@"));
        }
    }

    // Bach - Conway - Doe - Smith
    @Test(description = "Verify that after click last name, values will be sorted alphabetic order")
    public void Test8_YK(){ // PASS DONEEEEE
        driver.findElement(By.xpath("//table[@id='table1']//tr//th[1]")).click();
        String[] expectedLastNameOrder = {"Bach", "Conway", "Doe", "Smith"};
        List<WebElement> lastnames = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[1]"));

        for (int i = 0; i<4; i++){
            Assert.assertEquals(lastnames.get(i).getText(), expectedLastNameOrder[i], "NOT EQUAL");
        }
    }

    @Test(description = "Verify that after click last name, values will be sorted alphabetic order")
    public void Test8(){
        WebElement lastNameElement = driver.findElement(By.xpath("//table[@id='table1']//thead//th[1]"));
        lastNameElement.click();

        List<WebElement> lastnames = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[1]"));

        for(int i=0; i<lastnames.size()-1; i++){
            String lastName = lastnames.get(i).getText();
            String followingLastName = lastnames.get(i+1).getText();
            System.out.println("###########iteretion "+i);
            System.out.println("Current LAstName: "+lastName);
            System.out.println("Following LastNAme: "+followingLastName);
            Assert.assertTrue(lastName.compareTo(followingLastName) < 0);
        }

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
