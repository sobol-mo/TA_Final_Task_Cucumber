package manager;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.SignInPage;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }

}
