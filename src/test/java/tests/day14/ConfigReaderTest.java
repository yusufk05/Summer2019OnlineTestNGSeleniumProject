package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationReader;

public class ConfigReaderTest {

    @Test
    public void tes1(){
        String expectedBrowser = "chrome";
        String actualBrowser = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actualBrowser, expectedBrowser);
        // read value of url property
        System.out.println("URL: "+ConfigurationReader.getProperty("url"));
        // read valu of user_name property
        System.out.println("UserName: "+ConfigurationReader.getProperty("user_name"));
        //read value of password property
        System.out.println("Password: "+ConfigurationReader.getProperty("password"));
    }
}
