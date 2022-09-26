package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[@id='ap_email']")
    WebElement userIDInput;

    @FindBy(xpath = "//input[@id='ap_password']")
    WebElement userPasswordInput;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    WebElement signInButton;

    @FindBy(xpath = "//h4[contains(text(),'Enter the characters you see')]")
    WebElement enterCharactersMessage;

    @FindBy(xpath = "//span[contains(text(),'We cannot find an account')]")
    WebElement cannotFindAccountMessage;


    public boolean isUserIDInputVisible() {
        return userIDInput.isDisplayed();
    }

    public boolean isUserPasswordInputVisible() {
        return userPasswordInput.isDisplayed();
    }

    public void setUserIDInput(final String userID) {
        userIDInput.sendKeys(userID);
    }
    public void setUserPasswordInput(final String userPassword) {
        userPasswordInput.sendKeys(userPassword);
    }

    public void clickContinueButton() {
        continueButton.click();
    }
     public void clickSignInButton() {
        signInButton.click();
    }

    public boolean isEnterCharactersMessageVisible() {
        return enterCharactersMessage.isDisplayed();
    }

    public boolean isCannotFindAccountMessageVisible() {
        return cannotFindAccountMessage.isDisplayed();
    }


    public SignInPage(WebDriver driver) {
        super(driver);
    }


}
