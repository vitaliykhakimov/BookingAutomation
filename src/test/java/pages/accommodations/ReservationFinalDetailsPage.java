package pages.accommodations;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReservationFinalDetailsPage {
    @FindBy(xpath="//input[@id = 'phone']")
    private WebElement telephone;
    @FindBy(xpath="//button//ins//span[text()[contains(.,'Complete booking')]]")
    private WebElement completeReservationButton;
    @FindBy(xpath="//select[@id = 'cc_type']")
    private WebElement cardType;
    @FindBy(xpath="//input[@id = 'cc_number']")
    private WebElement cardNumber;
    @FindBy(xpath="//select[@id = 'cc_month']")
    private WebElement expirationMonth;
    @FindBy(xpath="//select[@id = 'ccYear']")
    private WebElement expirationYear;
    @FindBy(xpath="//input[@id = 'cc_cvc']")
    private WebElement cvcCode;
    @FindBy(xpath="//p[contains(., 'Please fill in a valid card number')]")
    private WebElement invalidCardNumberMessage;
    @FindBy(xpath="//p[contains(., \"Please enter an expiration date that's valid during your booking dates\")]")
    private WebElement invalidExpirationDateMessage;
    @FindBy(xpath="//p[contains(., \"Enter the 3-digit security code located on the back of your card\")]")
    private WebElement invalidCVCMessage;

    public ReservationFinalDetailsPage() {
        PageFactory.initElements(WebDriverSingleton.getInstance(), this);
    }

    public String getInvalidCardNumberMessage() { return invalidCardNumberMessage.getText(); }

    public String getInvalidExpirationDateMessage() { return invalidExpirationDateMessage.getText(); }

    public String getInvalidCVCMessage() { return invalidCVCMessage.getText(); }

    public void typeTelephoneNumber(String number) {
        telephone.clear();
        telephone.sendKeys(number);
    }

    public void typeCardInfo(String type, String number, String month, String year, String cvc) {
        Select typeSelect = new Select(cardType);
        typeSelect.selectByVisibleText(type);

        cardNumber.sendKeys(number);

        Select monthSelect = new Select(expirationMonth);
        monthSelect.selectByVisibleText(month);

        Select yearSelect = new Select(expirationYear);
        yearSelect.selectByVisibleText(year);

        cvcCode.sendKeys(cvc);
    }

    public ConfirmationPage clickCompleteReservationButton() {
        completeReservationButton.click();
        return new ConfirmationPage();
    }
}
