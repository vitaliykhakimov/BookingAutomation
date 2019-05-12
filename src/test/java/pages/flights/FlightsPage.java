package pages.flights;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Helper;

import java.util.List;

public class FlightsPage {
    @FindBy(xpath="//div[@class = 'inputWrapper']//input[@name = 'origin']")
    private WebElement dispatchLocation;
    @FindBy(xpath="//div[@class = 'col-field col-airport col-destination switch']//input[@name = 'destination']")
    private WebElement destinationLocation;
    @FindBy(xpath="//div[@class = 'col-dates col-field single-date-picker']")
    private WebElement calendar;
    @FindBy(xpath="//div[@class = 'day']")
    private List<WebElement> allDates;
    @FindBy(xpath="//div[@class = 'col col-button right']//button[@title = 'Search']")
    private WebElement searchButton;

    public FlightsPage() {
        PageFactory.initElements(WebDriverSingleton.getInstance(), this);
    }

    public void enterLocations(String dispatch, String destination) {
        dispatchLocation.clear();
        dispatchLocation.sendKeys(dispatch);
        Helper.waitForTime(1);
        destinationLocation.clear();
        destinationLocation.sendKeys(destination);
    }

    public void enterPeriod(String depart, String comeback) {
        calendar.click();

        List<WebElement> all_dates = allDates;

        for (WebElement el:all_dates) {
            String date = el.getText();

            if (date.equalsIgnoreCase(depart)) {
                el.click();
                break;
            }
        }

        Helper.waitForTime(1);
        for (WebElement el:all_dates) {
            String date = el.getText();

            if (date.equalsIgnoreCase(comeback)) {
                el.click();
                break;
            }
        }
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
