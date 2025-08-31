package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class GiftCardPage {

    WebDriver driver;
    
    // ===== Constructor =====
    
    public GiftCardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ===== Locators ====
    
    @FindBy(xpath = "//div[@class='sc-1or3vea-19 bfNncl']//a[@href='/giftcards' and text()='Gift Cards']")
    private WebElement giftCardSectionLink;

    @FindBy(xpath = "//div[text()='Check Gift Card Balance']")
    private WebElement checkBalanceIcon;

    @FindBy(xpath = "//input[@id='gift-voucher']")
    private WebElement voucherCodeInput;

    @FindBy(xpath = "//div[@class='sc-zgl7vj-7 kdBUB']")
    private WebElement checkBalanceButton;
    
    @FindBy(xpath = "//p[contains(@class,'sc-12r1n02-9')]")
    private WebElement errorMessage;

    // ==== Actions =====

    // Navigate to Gift Card section
    public void goToGiftCardSection() {
        WaitUtils.waitForClickability(driver, giftCardSectionLink).click();
    }

    // Verify Check Balance icon is visible (scroll into view)
    public boolean isCheckBalanceIconDisplayed() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", checkBalanceIcon);
        return WaitUtils.waitForVisibility(driver, checkBalanceIcon).isDisplayed();
    }
    
    // Click on Check Balance option
    public void clickCheckBalanceOption() {
        WaitUtils.waitForClickability(driver, checkBalanceIcon).click();
    }

    // Enter invalid voucher code
    public void enterVoucherCode(String code) {
        WaitUtils.waitForVisibility(driver, voucherCodeInput).sendKeys(code);
    }
    
    // Click Check Balance button
    public void clickCheckBalance() {
    	WaitUtils.waitForClickability(driver, checkBalanceButton).click();
    }

    // Get error message
    public String getErrorMessage() {
        return WaitUtils.waitForVisibility(driver, errorMessage).getText().trim();
    }
}
