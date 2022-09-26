package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchInput;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement searchButton;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    WebElement signInLink;

    @FindBy(xpath = "//span[contains(text(),'Hello')]")
    WebElement accountLink;

//    @FindBy(xpath = "//span[contains(text(),'Your password is incorrect')]")
//    WebElement incorrectPasswordMessage;

    // Enter the characters you see


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(final String url) {
        driver.get(url);
    }

    public void inputKeyWord(final String keyWord) {
        searchInput.clear();
        searchInput.sendKeys(keyWord);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isSearchFieldVisible() {
        return searchInput.isDisplayed();
    }

    public boolean isSignInLinkVisible() {
        return signInLink.isDisplayed();
    }

    public boolean isAccountLinkVisible() {
        return accountLink.isDisplayed();
    }



    public void clickSignIn() {
        signInLink.click();
    }

}
