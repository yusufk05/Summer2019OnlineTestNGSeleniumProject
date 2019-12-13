package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigurationReader;
import utils.Driver;

// This class will be a test foundation for all test cases
// We will put here only before and after parts
// In this way before and after methods will be same
//Every test class will extend testbas class

public abstract class TestBase {

    @BeforeMethod
    public void setup(){
        String url = ConfigurationReader.getProperty("url");
        Driver.get().get(url);
    }

    @AfterMethod
    public void teardown(){
        Driver.close();
    }


}
