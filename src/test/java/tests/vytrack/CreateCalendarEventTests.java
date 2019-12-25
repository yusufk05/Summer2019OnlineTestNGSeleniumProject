package tests.vytrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.CreateCalendarEventPage;
import pages.LoginPage;
import tests.TestBase;
import utils.ConfigurationReader;

public class CreateCalendarEventTests extends TestBase {

    @Test(description = "Verify owners name is equal to Stephan Haley(it works on qa1 storemenager")
    public void test1(){
        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();

        loginPage.login("storemanager85", "UserUser123");

        loginPage.navigateTo("Activities","Calendar Events");

        calendarEventsPage.waitUntilLoaderMaskDisappear();
        calendarEventsPage.clickToCreateCalendarEvent();

        calendarEventsPage.waitUntilLoaderMaskDisappear();
        String expectedOwner = " Stephan Haley";
        String actualOwner = createCalendarEventPage.owner.getText();

        Assert.assertEquals(actualOwner,expectedOwner);


    }


}
