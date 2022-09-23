package stepdefinitions;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class SignInSteps extends BaseSteps {

    @And("User checks sign in link visibility")
    public void checkSingInLinkVisibility() {
        pageFactoryManager = new PageFactoryManager(getDriver());
        homePage = pageFactoryManager.getHomePage();
        Assert.isTrue(homePage.isSignInLinkVisible(), "Sing in link is not visible");
    }
}
