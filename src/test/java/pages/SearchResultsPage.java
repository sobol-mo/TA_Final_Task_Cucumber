package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {


    @FindBy(xpath = "//span[contains(text(),'Dire Straits')]")
    WebElement searchResultString;

    @FindBy(xpath = "//div[@class='a-section aok-relative s-image-fixed-height']")
    List<WebElement> searchResultsEntries;


    public int getSearchResultsNumber() {
        return searchResultsEntries.size();
    }

    public boolean isSearchResultStringVisible() {
        return searchResultString.isDisplayed();
    }


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


}
