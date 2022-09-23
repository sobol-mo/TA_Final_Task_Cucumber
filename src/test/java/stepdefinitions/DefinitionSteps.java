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

import java.time.Duration;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps extends BaseSteps {



    String keyWord;

//    public DefinitionSteps() {
//        super();
//    }

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
        driver.close();
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        pageFactoryManager = new PageFactoryManager(driver);
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
}
