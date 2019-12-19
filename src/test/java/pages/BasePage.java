package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

// Everything that is common among we can go here
// Top menu appears on every single page
public class BasePage {

    @FindBy(css = "div[class='loader-mask shown']")
    public WebElement loadermask;




    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    /**
     * This method stands for navigator in vytrack application
     * provide moduleName, for example "Fleet" as String
     * provide subModuleName, for example "Vehicles" as String
     * @param subModuleName
     * @param moduleName
     * normalize-space() same like .trim() in java
     */
    public void navigateTo(String moduleName, String subModuleName){
        String moduleLocator = "//*[normalize-space()='"+moduleName+"' and @class = 'title title-level-1']";
        String subModuleLocator = "//*[normalize-space()='"+subModuleName+"' and @class = 'title title-level-2']";

        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleLocator)));

        WebElement module = Driver.get().findElement(By.xpath(moduleLocator));
        wait.until(ExpectedConditions.visibilityOf(module));
        wait.until(ExpectedConditions.elementToBeClickable(module));
        module.click(); // Once we click on module submodule should be visible

        WebElement subModule = Driver.get().findElement(By.xpath(subModuleLocator));
        wait.until(ExpectedConditions.visibilityOf(subModule));
        subModule.click();

        // wait until loader mask disappear
        wait.until(ExpectedConditions.invisibilityOf(loadermask));
    }

}
