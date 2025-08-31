package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.MoviePage;

public class MovieSteps {

    WebDriver driver = Hooks.getDriver();
    MoviePage moviePage = new MoviePage(driver);

    // --- Current Movies ---
    @When("I select the first movie from the Recommended Movies section")
    public void i_select_the_first_movie_from_the_recommended_movies_section() {
        moviePage.selectFirstRecommendedMovie();
    }

    @Then("I should see the movie details page")
    public void i_should_see_the_movie_details_page() {
        Assert.assertTrue(moviePage.isMovieDetailsPageDisplayed(), "Movie details page not displayed");
    }

    @Then("the movie name should be displayed")
    public void the_movie_name_should_be_displayed() {
        Assert.assertTrue(moviePage.isMovieNameDisplayed(), "Movie name not displayed");
    }

    @Then("the movie poster should be visible")
    public void the_movie_poster_should_be_visible() {
        Assert.assertTrue(moviePage.isMoviePosterVisible(), "Movie poster not visible");
    }

    @Then("the booking option should be available")
    public void the_booking_option_should_be_available() {
        Assert.assertTrue(moviePage.isBookingOptionAvailable(), "Booking option not available");
    }

    // --- UI Validation ---
    @When("I click on the Movies tab")
    public void i_click_on_the_movies_tab() {
        moviePage.clickMoviesTab();
    }


    @Then("Verify \"Filters\" header is visible")
    public void verify_filters_header_is_visible() {
        Assert.assertTrue(moviePage.isFiltersVisible(), "Filters header not visible!");
    }

    @Then("Verify Genre filter is visible")
    public void verify_genre_filter_is_visible() {
        Assert.assertTrue(moviePage.isGenreFilterVisible(), "Genre filter not visible!");
    }

    // --- Upcoming Movies ---
    @And("I click on the {string} link")
    public void i_click_on_the_explore_upcoming_movies_link(String linkText) {
        moviePage.clickExploreUpcomingMovies();
    }

    @Then("I should see the {string} link displayed")
    public void i_should_see_the_in_cinemas_near_you_link_displayed(String linkText) {
        Assert.assertTrue(moviePage.isInCinemasNearYouVisible(), linkText + " link is not visible");
    }
}
