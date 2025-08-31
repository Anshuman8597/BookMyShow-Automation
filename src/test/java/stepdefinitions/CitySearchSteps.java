package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CitySearchPage;
import constants.FrameworkConstants;

public class CitySearchSteps {

    WebDriver driver = Hooks.getDriver();
    CitySearchPage cityPage = new CitySearchPage(driver);

    @Given("User is on city selection page")
    public void user_is_on_city_selection_page() {
        driver.get(FrameworkConstants.BASE_URL); // https://in.bookmyshow.com
    }

    @When("I search for city {string}")
    public void i_search_for_city(String cityName) {
        cityPage.searchCity(cityName);
    }

    @Then("I should see {string} in the search results")
    public void i_should_see_city_in_the_search_results(String cityName) throws InterruptedException {
        Assert.assertTrue(cityPage.isCityPresentInResults(cityName));
        Thread.sleep(1000);
        cityPage.clickOnFirstResult();
        Thread.sleep(5000);
    }

    @Then("verify dropdown text should be {string}")
    public void verify_dropdown_text_should_be(String expectedCity) {
    	
        Assert.assertEquals(cityPage.getDropdownText(), expectedCity,
                "Dropdown text mismatch!");
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedMsg) {
        Assert.assertEquals(cityPage.getErrorMessage(), expectedMsg,
                "Error message mismatch!");
    }

    @When("User clicks on popular city {string}")
    public void user_clicks_on_popular_city(String cityName) {
        cityPage.clickPopularCity(cityName);
    }

    @When("User opens View All Cities")
    public void user_opens_view_all_cities() {
        cityPage.openViewAllCities();
    }

//    @Then("Verify city list contains {string} and {string}")
//    public void verify_city_list_contains_and(String city1, String city2) {
//        Assert.assertTrue(cityPage.isCityPresentInAllCities(city1));
//        Assert.assertTrue(cityPage.isCityPresentInAllCities(city2));
//    }
    
    @And("validate that cities like {string}, {string}, {string} are visible")
    public void validate_multiple_cities(String city1, String city2, String city3) {
        Assert.assertTrue(cityPage.isCityPresentInAllCities(city1), city1 + " is not visible in All Cities list");
        Assert.assertTrue(cityPage.isCityPresentInAllCities(city2), city2 + " is not visible in All Cities list");
        Assert.assertTrue(cityPage.isCityPresentInAllCities(city3), city3 + " is not visible in All Cities list");
    }
}
