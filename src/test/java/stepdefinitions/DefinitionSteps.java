package stepdefinitions;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.SignInPage;

import java.time.Duration;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(60);
    static WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    SignInPage signInPage;
    String keyWord;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

/*    @After
    public void tearDown() {
//        driver.manage().deleteAllCookies();
//        driver.quit();
        driver.close();
    }*/

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.isSearchFieldVisible();
        Assert.isTrue(homePage.isSearchFieldVisible(), "SearchField is not visible");
    }

    @When("User makes search by keyword {string}")
    public void userMakesSearchByKeyword(final String keyWord) {
        homePage.inputKeyWord(keyWord);
        this.keyWord = keyWord;

    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        homePage.clickSearchButton();
//        Assert.isTrue(driver.getCurrentUrl().contains(keyWord), "Query doesn't match keyWord");
    }

    @And("User clicks watchlist on first product")
    public void userClicksWatchlistOnFirstProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickInWatchListOnFirstProduct();
    }

    // Sing in:
    @And("User checks sign in link visibility")
    public void checkSingInLinkVisibility() {
        pageFactoryManager = new PageFactoryManager(driver);
        homePage = pageFactoryManager.getHomePage();
        Assert.isTrue(homePage.isSignInLinkVisible(), "Sing in link is not visible");
    }

    @And("User goes to sign in page")
    public void userGoesToSignInPage() {
        homePage.clickSignIn();
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        Assert.isTrue(signInPage.isUserIDInputVisible(), "UserId Input is not visible");

    }
}
