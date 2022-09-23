package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.SearchResultsPage;

import java.time.Duration;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseSteps {
    static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(60);
    static WebDriver driver;

    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    SearchResultsPage searchResultsPage;

    public WebDriver getDriver() {
        return driver;
    }

    /*{
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
        homePage = pageFactoryManager.getHomePage();
    }*/

//    public void BaseSteps() {
//        chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        pageFactoryManager = new PageFactoryManager(driver);
//        homePage = pageFactoryManager.getHomePage();
//    }

}
