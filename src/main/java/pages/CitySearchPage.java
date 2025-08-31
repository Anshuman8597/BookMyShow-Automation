package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

import java.util.List;

public class CitySearchPage {
    WebDriver driver;

    // ===== Constructor =====
    public CitySearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ===== Page Elements =====

    // Search box
    @FindBy(xpath = "//input[@placeholder='Search for your city']")
    private WebElement citySearchBox;

    // First suggested city (after typing)
    @FindBy(xpath = "//div[@class='sc-fv93km-0 cPDWyb']//div[1]//div[1]")
    private WebElement firstSuggestedCity;

    // Search results list
    @FindBy(xpath = "//div[@class='sc-5d56x9-0 hIDoFD']//span")
    private List<WebElement> searchResults;

    // Error message when invalid city entered
    @FindBy(xpath = "//div[@class='sc-fv93km-1 fZhJNQ']")
    private WebElement errorMessage;

    // Popular city icons
    @FindBy(xpath = "//li//p")
    private List<WebElement> cityIcons;

    // City dropdown (selected city text)
    @FindBy(xpath = "//div[@id='common-header-region']//span")
    private WebElement cityDropdown;

    // "View All Cities" link
    @FindBy(xpath = "//p[text()='View All Cities']")
    private WebElement viewAllCitiesLink;

    // List of cities from "View All Cities" section
    @FindBy(xpath = "//li[@class='sc-1a0jimq-0 hhOIxv']")
    private List<WebElement> allCitiesList;

    // ===== Actions =====

    // Type in city search box
    public void searchCity(String cityName) {
        WaitUtils.waitForVisibility(driver, citySearchBox).clear();
        citySearchBox.sendKeys(cityName);
    }

    // Select first suggestion
    public void selectFirstSuggestedCity() {
        WaitUtils.waitForClickability(driver, firstSuggestedCity).click();
    }

    // Verify if city appears in search results
    public boolean isCityPresentInResults(String cityName) {
        for (WebElement city : searchResults) {
            if (city.getText().equalsIgnoreCase(cityName)) {
                return true;
            }
        }
        return false;
    }

    // Click first search result
    public void clickOnFirstResult() {
        WaitUtils.waitForClickability(driver, searchResults.get(0)).click();
    }

    // Get dropdown text (selected city)
    public String getDropdownText() {
        return WaitUtils.waitForVisibility(driver, cityDropdown).getText();
    }

    // Get error message for invalid search
    public String getErrorMessage() {
        return WaitUtils.waitForVisibility(driver, errorMessage).getText();
    }

    // Click popular city by icon
    public void clickPopularCity(String cityName) {
        for (WebElement city : cityIcons) {
            if (city.getText().equalsIgnoreCase(cityName)) {
                WaitUtils.waitForClickability(driver, city).click();
                break;
            }
        }
    }

    // Open "View All Cities"
    public void openViewAllCities() {
        WaitUtils.waitForClickability(driver, viewAllCitiesLink).click();
    }

    // Check if city exists in "View All Cities" list
    public boolean isCityPresentInAllCities(String cityName) {
        for (WebElement city : allCitiesList) {
            if (city.getText().equalsIgnoreCase(cityName)) {
                return true;
            }
        }
        return false;
    }
}
