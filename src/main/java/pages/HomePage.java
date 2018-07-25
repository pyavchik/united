package pages;

import io.trueautomation.client.driver.FindByTA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    private String baseURL = "https://www.united.com/en/us/";

    @FindByTA(taName="ta:homePage:flightStatusToggler", id = "statusTab")
    private WebElement flightStatusToggler;

    @FindByTA(taName="ta:homePage:flightNumberField", id = "flightStatusModel.flightNumber")
    private WebElement flightNumber;

    @FindByTA(taName="ta:homePage:datesDropdown", id = "datesDropdown")
    private WebElement datesDropdown;

    @FindByTA(taName="ta:homePage:fromInput", id = "flightStatusOriginInput")
    private WebElement fromInput;

    @FindByTA(taName="ta:homePage:toInput", id = "flightStatusDestinationInput")
    private WebElement toInput;

    @FindByTA(taName="ta:homePage:searchButton", xpath = "//button[@aria-label='Search']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToHomePage(){
        driver.get(baseURL);
    }

    public void goToFlightStatusToggler(){
        flightStatusToggler.click();
    }

    public boolean isFlightNumberFieldAvailable(){
        return flightNumber.isDisplayed();
    }

    public boolean isDatesDropdownAvailable(){
        return datesDropdown.isDisplayed();
    }

    public boolean isFromInputAvailable(){
        return fromInput.isDisplayed();
    }

    public boolean isToInputAvailable(){
        return toInput.isDisplayed();
    }

    public boolean isSearchButtonAvailable(){
        return searchButton.isDisplayed();
    }
}
