package tests.vytrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import tests.day14.ConfigReaderTest;
import utils.ConfigurationReader;

public class NewCalendarEventsTests extends TestBase {

    @Test(description = "Verify that page subtitle is equals to 'All Calendar Events'")
    public void test1(){
        LoginPage loginPage = new LoginPage();

        loginPage.login("storemanager85", "UserUser123");
        loginPage.navigateTo("Activities","Calendar Events");
        String expectedSubtitle = "All Calendar Events";
        String actualSubtitle = loginPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle,expectedSubtitle);
    }

}
