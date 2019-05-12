package pages.login;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.main.MainPage;

public class SignInPage {
    @FindBy(xpath="//input[@id = 'username']")
    private WebElement username;
    @FindBy (xpath="//input[@id = 'password']")
    private WebElement password;
    @FindBy (xpath="//button//span[text()[contains(.,'Next')]]")
    private WebElement nextButton;
    @FindBy (xpath="//button//span[text()[contains(.,'Sign in')]]")
    private WebElement signInButton;

    public SignInPage() {
        PageFactory.initElements(WebDriverSingleton.getInstance(), this);
    }

    public void typeUsername(String name) {
        username.clear();
        username.sendKeys(name);
    }

    public void typePassword(String pass) {
        password.clear();
        password.sendKeys(pass);
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public MainPage clickSignInButton() {
        signInButton.click();
        return new MainPage();
    }
}
