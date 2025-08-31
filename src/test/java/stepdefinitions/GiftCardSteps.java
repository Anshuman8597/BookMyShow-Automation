package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.GiftCardPage;

public class GiftCardSteps {

    WebDriver driver = Hooks.getDriver();
    GiftCardPage giftCardPage = new GiftCardPage(driver);

    @When("User navigates to Gift Card section")
    public void user_navigates_to_gift_card_section() {
        giftCardPage.goToGiftCardSection();
    }

    @Then("Verify Check Gift Card balance icon is visible")
    public void verify_check_gift_card_balance_icon_is_visible() {
        Assert.assertTrue(giftCardPage.isCheckBalanceIconDisplayed(),
                "Check Gift Card balance icon is not visible");
    }

    @And("User clicks on bottom {string}")
    public void user_clicks_on_bottom_check_balance(String linkName) {
        giftCardPage.clickCheckBalanceOption();
    }

    @And("User enters invalid voucher {string} in the balance input box")
    public void user_enters_invalid_voucher(String voucher) {
        giftCardPage.enterVoucherCode(voucher);;
    }

    @And("Clicks on Check Balance button")
    public void clicks_on_check_balance_button() throws InterruptedException {
        giftCardPage.clickCheckBalance();
    }

    @Then("Verify error message {string}")
    public void verify_error_message(String expectedMsg) {
        Assert.assertEquals(giftCardPage.getErrorMessage(), expectedMsg,
                "Error message does not match");
    }
}
