package pages.accommodations;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Helper;

public class MyBookingsPage {
    @FindBy(xpath="//li[@class = 'res-actions__item res-actions__item-main']//a[text()[contains(., 'View booking')]]")
    private WebElement viewBookingButton;
    @FindBy(xpath="//a[text()[contains(., \"Cancel your booking\")]]")
    private WebElement cancelBookingButton;
    @FindBy(xpath="//input[@id = 'none_of_the_above']")
    private WebElement cancelliationReason;
    @FindBy(xpath="//input[@id = 'none_of_the_above__details']")
    private WebElement reasonDetails;
    @FindBy(xpath="//input[@id = 'cancel_sure']")
    private WebElement yesButton;
    @FindBy(xpath="//button[@title = 'Close']")
    private WebElement closeButton;
    @FindBy(xpath="//div[@class = 'myBookingButtonRow']//input[@value = 'Ok']")
    private WebElement okButton;
    @FindBy(xpath="//b[text()[contains(., 'Your booking was successfully canceled')]]")
    private WebElement cancellingInfo;

    public MyBookingsPage() {
        PageFactory.initElements(WebDriverSingleton.getInstance(), this);
    }

    public String getCancellingInfo() {
        return cancellingInfo.getText();
    }

    public void clickViewBookingButton() { viewBookingButton.click(); }

    public void clickCloseButton() { closeButton.click(); }

    public void clickCancelBookingButton() { cancelBookingButton.click(); }

    public void choosingReasonAndCancelling(String reasonText) {
        cancelliationReason.click();
        reasonDetails.sendKeys(reasonText);
        yesButton.click();
        Helper.waitForTime(2);
        okButton.click();
    }
}
