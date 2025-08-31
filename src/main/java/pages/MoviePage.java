package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

//import java.util.List;

public class MoviePage {
    WebDriver driver;
    
    // ===== Constructor =====

    public MoviePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
 // ===== Page Elements =====

    // --- Recommended movies ---
    @FindBy(xpath = "//div[contains(@class,'sc-dv5ht7-0 hexaHF')]")
//  @FindBy(xpath = "//h2[contains(text(),'Recommended Movies')]/following::div[1]//a")
//  @FindBy(xpath = "//div[contains(@class,'sc-133848s-3')]//a[@class='sc-133848s-11 sc-lnhrs7-5 ctsexn bHVBt']")
//  @FindBy(xpath = "//h2[contains(text(),'Recommended Movies')]/following::div[1]//a")
//  private List<WebElement> recommendedMovies;
    private WebElement recommendedMovies;

    // --- Movie details page elements ---
    @FindBy(xpath = "//h1[contains(@class,'sc-qswwm9-6 ea-drWB')]")
    private WebElement movieName;

    @FindBy(xpath = "//section[contains(@class,'sc-qswwm9-0 fuLSrE')]")
    private WebElement moviePoster;

    @FindBy(xpath = "//span[contains(text(),'Book tickets')]")
    private WebElement bookingOption;

    // --- Movies tab ---
    @FindBy(xpath = "//a[text()='Movies']")
    private WebElement moviesTab;

    // Filters header
    @FindBy(xpath = "//div[@class='sc-1y4pbdw-4 efRRvH']")
    private WebElement filtersHeader;

    // Genre filter element
    @FindBy(xpath = "//div[contains(text(),'Genre')]")
    private WebElement genreFilter;

    // --- Explore Upcoming Movies link ---
    @FindBy(xpath = "//img[@alt='Coming Soon']")
    private WebElement exploreUpcomingMoviesImgLink;

    // --- "In Cinemas Near You" link ---
    @FindBy(xpath = "//img[@alt='Now Showing']")
    private WebElement inCinemasNearYouImgLink;
    

	// ===== Actions =====

    // --- Recommended Movies ---
    public void selectFirstRecommendedMovie() {
//    	 if (!recommendedMovies.isEmpty()) {
//             recommendedMovies.get(1).click();
//         } else {
//             throw new RuntimeException("No recommended movies found!");
//         }
    	WaitUtils.waitForClickability(driver, recommendedMovies).click();
    }

    public boolean isMovieDetailsPageDisplayed() {
        return WaitUtils.waitForVisibility(driver, movieName).isDisplayed();
    }

    public boolean isMovieNameDisplayed() {
        return WaitUtils.waitForVisibility(driver, movieName).isDisplayed();
    }

    public boolean isMoviePosterVisible() {
        return WaitUtils.waitForVisibility(driver, moviePoster).isDisplayed();
    }

    public boolean isBookingOptionAvailable() {
        return WaitUtils.waitForVisibility(driver, bookingOption).isDisplayed();
    }

    // --- Movies tab + UI validations ---
    public void clickMoviesTab() {
        WaitUtils.waitForClickability(driver, moviesTab).click();
    }

    public boolean isFiltersVisible() {
        return WaitUtils.waitForVisibility(driver, filtersHeader).isDisplayed();
    }

    public boolean isGenreFilterVisible() {
        return WaitUtils.waitForVisibility(driver, genreFilter).isDisplayed();
    }

    // --- Upcoming Movies ---
    public void clickExploreUpcomingMovies() {
        WaitUtils.waitForClickability(driver, exploreUpcomingMoviesImgLink).click();
    }

    public boolean isInCinemasNearYouVisible() {
        return WaitUtils.waitForVisibility(driver, inCinemasNearYouImgLink).isDisplayed();
    }
}
