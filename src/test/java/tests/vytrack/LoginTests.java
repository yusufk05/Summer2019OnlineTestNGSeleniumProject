package tests.vytrack;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.ConfigurationReader;
import utils.Driver;

// We use extend TestBase to inherot @Before and @After Methods
// We dont have to find elements here
// We should find elements in page classes only

public class LoginTests extends TestBase {

    @Test(description = "Login ")
    public void test1(){
        //create page object
        LoginPage loginPage = new LoginPage();
        // call login method and provide credentials
        loginPage.login("storemanager85", ConfigurationReader.getProperty("password"));
/*
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        // This is an explicit wait
        // it waits until title is dashboard
        wait.until(ExpectedConditions.titleIs("Dashboard"));
*/
        Assert.assertEquals(Driver.get().getTitle(), "Dashboard");

    }
}
