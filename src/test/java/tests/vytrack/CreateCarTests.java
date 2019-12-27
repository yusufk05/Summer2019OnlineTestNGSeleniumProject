package tests.vytrack;

import org.testng.annotations.Test;
import pages.CreateCarPage;
import pages.LoginPage;
import pages.VehiclesPage;
import tests.TestBase;

public class CreateCarTests extends TestBase {

    @Test(description = "Create some random car")
    public void test1(){
        extentTest = extentReports.createTest("Create some random car");

        LoginPage loginPage = new LoginPage();
        VehiclesPage vehiclesPage = new VehiclesPage();
        CreateCarPage createCarPage = new CreateCarPage();

        loginPage.login("storemanager218", "UserUser123");
        loginPage.navigateTo("Fleet", "Vehicles");

        loginPage.waitUntilLoaderMaskDisappear();
        vehiclesPage.clickToCreateACar();

        loginPage.waitUntilLoaderMaskDisappear();
        createCarPage.licensePlate.sendKeys("ZK01");
        createCarPage.selectTags("Compact");
        createCarPage.selectFuelType("Diesel");
        createCarPage.driverElement.sendKeys("John");
        createCarPage.saveAndCloseButtonElement.click();

        extentTest.pass("New car was created");
    }
}
