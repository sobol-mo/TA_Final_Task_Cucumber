package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    //input[@id='userid']
    @FindBy(xpath = "input[@id='userid']")
    WebElement userIDInput;

    public boolean isUserIDInputVisible() {
        return userIDInput.isDisplayed();

    }


    public SignInPage(WebDriver driver) {
        super(driver);
    }


}
