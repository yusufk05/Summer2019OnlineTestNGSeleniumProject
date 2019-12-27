package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;
import utils.Driver;

public class CreateCarPage extends BasePage {

    @FindBy(css = "[id^='custom_entity_type_LicensePlate']")
    public WebElement licensePlate;

    @FindBy(name = "custom_entity_type[Driver]")
    public  WebElement driverElement;

    @FindBy(name = "custom_entity_type[Location]")
    public WebElement locationElement;

    @FindBy(css = "[class='btn btn-success action-button']")
    public WebElement saveAndCloseButtonElement;

    @FindBy(css = "div[id*='FuelType']")
    public WebElement fuelTypeElement;

    // if this locator doesn't work use [id^='uniform-custom_entity_type_Logo_file'] > span[class='action']
    @FindBy(name = "custom_entity_type[Logo][file]")
    public WebElement logoElement;

    /**
     * This method stands for selecting tags
     * Provide tag name to select
     * If checkbox already selected, it will not do anything
     * @param tagName
     */
    public WebElement selectTags(String tagName){
        // Locator for checkbox is based on label name
        String locator = "//label[text()='"+tagName+"']/preceding-sibling::input[@type='checkbox']";
        WebElement checkbox = Driver.get().findElement(By.xpath(locator));
        BrowserUtils.waitForVisibility(checkbox, 10);
        BrowserUtils.waitForClickablility(checkbox, 10);
        if(!checkbox.isSelected()){
            checkbox.click();
        }
        return checkbox;
    }

    /**
     * Select fuel type by visible text
     * @param fuelType - Diesel, Electric, Hybrid
     *
     * usage: CreateCarPage createCarPage = new CreateCarPage();
     */
    public void selectFuelType(String fuelType){
        String locator = "//div[@class='select2-result-label' and text()='"+fuelType+"']";
        BrowserUtils.waitForClickablility(fuelTypeElement, 10);
        fuelTypeElement.click();
        WebElement fuelTypeSelectionElement = Driver.get().findElement(By.xpath(locator));
        BrowserUtils.waitForClickablility(fuelTypeSelectionElement,10);
        fuelTypeSelectionElement.click();
    }

    public void uploadLogo(String pathToTheFile){
        BrowserUtils.waitForVisibility(logoElement,10);
        logoElement.sendKeys(pathToTheFile);
    }
}