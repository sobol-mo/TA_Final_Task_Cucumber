package stepdefinitions;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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

    static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(30);
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

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
    }

    @And("I open {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
//        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);

    }

    @And("I check search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.isSearchFieldVisible();
        Assert.isTrue(homePage.isSearchFieldVisible(), "");
    }

    @When("I make search by keyword {string}")
    public void userMakesSearchByKeyword(final String keyWord) {
        homePage.inputKeyWord(keyWord);
        this.keyWord = keyWord;

    }

    @And("I click search button")
    public void userClicksSearchButton() {
        homePage.clickSearchButton();
        searchResultsPage = pageFactoryManager.getSearchResultsPage();

    }

    @Then("I can see right amount of products {string}")
    public void rightAmountOfProductsIsDisplayed(final String productsAmount) {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
//        searchResultsPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        Assert.isTrue(searchResultsPage.isSearchResultStringVisible(), "");
        Assert.state(searchResultsPage
                .getSearchResultsNumber() == Integer.parseInt(productsAmount), "");
    }




    // ********** Sing in:
    @And("I check sign in link visibility")
    public void checkSingInLinkVisibility() {
        pageFactoryManager = new PageFactoryManager(driver);
        homePage = pageFactoryManager.getHomePage();
        Assert.isTrue(homePage.isSignInLinkVisible(), "");
    }

    @And("I go to sign in page")
    public void userGoesToSignInPage() {
        homePage.clickSignIn();
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
//        signInPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        Assert.isTrue(signInPage.isUserIDInputVisible(), "");


    }

    @When("I enter credentials {string} and {string}")
    public void userEnterCredentials(final String userID, final String userPassword) {
        signInPage.setUserIDInput(userID);
        signInPage.clickContinueButton();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.isTrue(signInPage.isUserPasswordInputVisible(), "");
        signInPage.setUserPasswordInput(userPassword);
        signInPage.clickSignInButton();
    }

    @Then("I logged in successfully")
    public void userLoggedInSuccessfully() {
        Assert.isTrue(homePage.isAccountLinkVisible(), "");
    }

    @Then("I logged in unsuccessfully")
    public void userLoggedInUnsuccessfully() {
//        Assert.isTrue(signInPage.isEnterCharactersMessageVisible(), "");
        Assert.isTrue(signInPage.isIncorrectPasswordMessageVisible(), "");
    }

    @When("I enter wrong {string}")
    public void userEnterWrongUserID(final String userID) {
        signInPage.setUserIDInput(userID);
        signInPage.clickContinueButton();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);

    }

    @Then("I logged in unsuccessfully with wrong userID")
    public void userLoggedInUnsuccessfullyWithWrongUserID() {
        Assert.isTrue(signInPage.isCannotFindAccountMessageVisible(), "");
    }


}
