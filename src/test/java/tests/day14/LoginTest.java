package tests.day14;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tests.TestBase;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

public class LoginTest extends TestBase {


    @Ignore
    @Test
    public void Test1(){
        String url = ConfigurationReader.getProperty("url");
        //Driver.get() will return WebDriver Object
        // Then we can call Webdirever methods like get(), findelement()......
        Driver.get().get(url);
        BrowserUtils.wait(2);
        Driver.close();
    }

    @Test
    public void test2(){
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(2);
    }

}
