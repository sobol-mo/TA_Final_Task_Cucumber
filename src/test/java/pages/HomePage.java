package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//input[@id='gh-ac']")
    WebElement searchInput;

    @FindBy(xpath = "//input[@id='gh-btn']")
    WebElement searchButton;

    @FindBy(xpath = "//span[@id='gh-ug']//a[contains(text(),'Sign in')]")
    WebElement signInLink;


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

    public void clickSignIn() {
        signInLink.click();
    }

}
