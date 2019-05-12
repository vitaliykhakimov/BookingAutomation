package pages.taxis;

import driver.WebDriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Helper;

import java.util.List;

public class TaxisPage {
    @FindBy(xpath="//input[@id = 'pickupLocation']")
    private WebElement pickupLocation;
    @FindBy(xpath="//input[@id = 'dropoffLocation']")
    private WebElement dropoffLocation;
    @FindBy(xpath="//h4[contains(., \"Minsk National Airport, Minsk, Belarus\")]")
    private WebElement minskAirport;
    @FindBy(xpath="//h4[contains(., \"vulica Valhahradskaja, Minsk, Belarus\")]")
    private WebElement street;
    @FindBy(xpath="//button[@aria-label = 'pickup date input field']")
    private WebElement pickupDate;
    @FindBy(xpath="//div[@class = 'rw-c-date-picker']//td")
    private List<WebElement> allDates;
    @FindBy(xpath="//button[@name = 'searchButton']")
    private WebElement searchButton;

    public TaxisPage() {
        PageFactory.initElements(WebDriverSingleton.getInstance(), this);
    }

    public void enterLocations(String pickup, String dropoff) {
        pickupLocation.clear();
        pickupLocation.sendKeys(pickup);
        minskAirport.click();
        pickupLocation.clear();
        dropoffLocation.sendKeys(dropoff);
        street.click();
    }

    public void chooseDate(String day) {
        pickupDate.click();
        Helper.waitForTime(1);
        List <WebElement> all_dates = allDates;

        for (WebElement el:all_dates) {
            String date = el.getText();

            if (date.equalsIgnoreCase(day)) {
                el.click();
                break;
            }
        }
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
