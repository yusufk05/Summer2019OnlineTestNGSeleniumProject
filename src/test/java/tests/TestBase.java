package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

import java.io.IOException;

// This class will be a test foundation for all test cases
// We will put here only before and after parts
// In this way before and after methods will be same
//Every test class will extend testbase class
public abstract class TestBase {
    // ExtentReports itself does not build any reports, but allows reporters to access information, which in
    //turn build the said reports. An example of building an HTML report and adding information to ExtentX:
    // ExtentHtmlReporter html = new ExtentHtmlReporter("Extent.html");
    // ExtentXReporter extentx = new ExtentXReporter("localhost");

    protected static ExtentReports extentReports; // Initialize report as it is
    // The ExtentHtmlReporter creates a rich standalone HTML file. It allows several
    protected static ExtentHtmlReporter extentHtmlReporter;
    // Defines a test. You can add logs, snapshots, assign author and categories to a test and its children.
    protected static ExtentTest extentTest;

    @BeforeTest
    @Parameters({"test", "env_url"})
    public void beforeTest(@Optional String test,@Optional String env_url){
        // Location of report
        String reportName = "report";
        if(test != null){
            reportName = test;
        }
        String filePath = System.getProperty("user.dir")+"/test-output/"+reportName+".html";
        extentReports = new ExtentReports();
        // We need to give Folder PAth as a parameter
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setReportName("VyTrack Test Result");
        //System Information
        String env = ConfigurationReader.getProperty("url");
        if(env_url != null){
            env = env_url;
        }
        extentReports.setSystemInfo("Environment", env);
        extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
        extentReports.setSystemInfo("OS",System.getProperty("os.name"));
    }

    @AfterTest
    public void AfterTest(){
        // Writes test information from the started reporters to their output view
        extentReports.flush();
    }

    //        <parameter name = "env_url" value = "https://qa3.vytrack.com/"></parameter>
    @BeforeMethod
    @Parameters("env_url")
    public void setup(@Optional String env_url){
        String url = ConfigurationReader.getProperty("url");
        if(env_url != null){
            url = env_url;
        }
        Driver.get().get(url);
    }

    // ITestResult class describes the result of a test. (in TestNG)
    @AfterMethod
    public void teardown(ITestResult result){

        if(result.getStatus() == ITestResult.FAILURE){
            extentTest.fail(result.getName());
            extentTest.fail(result.getThrowable());
            try {
                // Returns take screenshot and location of that ScreenShot
                extentTest.addScreenCaptureFromPath(BrowserUtils.getScreenshot(result.getName()));
            } catch (IOException e){
                e.printStackTrace();
            }
        } else if(result.getStatus() == ITestResult.SKIP){
            extentTest.skip("Test case was skipped: "+result.getName());
        }

        Driver.close();

    }



}
