package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

// according to page object model design
// we have to create corresponded page for each page of application
// login page = login page class
// Every page class will store webelements and methods related to page
public class LoginPage extends BasePage{

    @FindBy(id = "prependedInput") // This line will initilaze Webelement underline
    public WebElement userNameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(css = "[class='alert alert-error']")
    public WebElement warningMessage;

    public LoginPage() {
        // This constructor for @FindBy annotation //
        // This means LoginPAge class
        // Driver.get() returns Webdriver object
        PageFactory.initElements(Driver.get(), this);
    }

    // Just call this method to login
    // Provide Username and Password
    public void login(String userName, String password){
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password, Keys.ENTER);
    }








}
