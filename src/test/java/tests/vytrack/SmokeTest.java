package tests.vytrack;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;

public class SmokeTest extends TestBase {

    @Test(dataProvider = "navigationInfo")
    public void smokeTest(String moduleName, String subModuleName, String pageSubtitle){

        extentTest = extentReports.createTest("Verify that page subtitle is equals to "+pageSubtitle);

        LoginPage loginPage = new LoginPage();

        loginPage.login("Storemanager85", "UserUser123");

        loginPage.navigateTo(moduleName,subModuleName);

        Assert.assertEquals(loginPage.getPageSubTitle(), pageSubtitle);

        extentTest.pass("Verified that page subtitle '"+pageSubtitle+"' is displayed");
    }

    @DataProvider(name = "navigationInfo")
    public Object[][] navigationInfo(){
        return new Object[][]{
                {"Dashboards", "Dashboard", "Dashboard"},
                {"Dashboard", "Manage Dashboard", "All Manage Dashboard"},
                {"Fleet", "Vehicles", "All Cars"},
                {"Customers", "Accounts", "All Accounts"}
        };
    }

}
