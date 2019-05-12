package pages.accommodations;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservationDetailsPage {
    @FindBy(xpath="//input[@id = 'firstname']")
    private WebElement firstName;
    @FindBy(xpath="//input[@id = 'lastname']")
    private WebElement lastName;
    @FindBy(xpath="//button[text()[contains(.,'Next: Final details')]]")
    private WebElement finalDetailsButton;

    public ReservationDetailsPage() {
        PageFactory.initElements(WebDriverSingleton.getInstance(), this);
    }

    public void typeFirstAndLastNames(String first, String last) {
        firstName.clear();
        firstName.sendKeys(first);
        lastName.clear();
        lastName.sendKeys(last);
    }

    public ReservationFinalDetailsPage clickFinalDetailsButton() {
        finalDetailsButton.click();
        return new ReservationFinalDetailsPage();
    }
}
