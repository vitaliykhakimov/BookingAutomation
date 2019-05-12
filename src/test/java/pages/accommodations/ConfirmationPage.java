package pages.accommodations;


import driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
    @FindBy(xpath="//span[text()[contains(.,\"Your Account\")]]")
    private WebElement yourAccount;
    @FindBy (xpath="//a[text()[contains(.,\"Bookings\")]]")
    private WebElement bookings;
    @FindBy (xpath="//button[@title = 'Close']")
    private WebElement closeButton;


    private WebDriver getDriver() { return WebDriverSingleton.getInstance(); }

    public ConfirmationPage() {
        PageFactory.initElements(WebDriverSingleton.getInstance(), this);
    }

    public String getBookingTitle() {
        return getDriver().findElement(By.xpath("//div//a[text()[contains(.,'Hotel Minsk')]]")).getText();
    }

    public void goToMyBookingsPage() {
        yourAccount.click();
        bookings.click();
    }

    public void clickCloseButton() {
        closeButton.click();
    }
}
