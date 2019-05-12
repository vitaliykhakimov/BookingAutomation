package pages.carrentals;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Helper;
import java.util.List;

public class CarRentalsPage {
    @FindBy(xpath="//input[@id = 'ss_origin']")
    private WebElement pickupLocation;
    @FindBy(xpath="//div[@class = 'xp__dates-inner']//button[@aria-label = \"Open calendar\"]")
    private WebElement calendar;
    @FindBy(xpath="//table[@class = 'c2-month-table']//td")
    private List<WebElement> allDates;
    @FindBy(xpath="//input[@class = 'xp__input xp__driver-age-input']")
    private WebElement age;
    @FindBy(xpath="//button//span[text()[contains(., \"Search\")]]")
    private WebElement searchButton;
    @FindBy(xpath="//span//b[text()[contains(., \"Minsk International Airport\")]]")
    private WebElement minskAirport;

    private WebDriver driver = WebDriverSingleton.getInstance();

    public CarRentalsPage() {
        PageFactory.initElements(WebDriverSingleton.getInstance(), this);
    }

    public void enterPickupLocation(String location) {
        pickupLocation.clear();
        pickupLocation.sendKeys(location);
        Helper.waitForTime(2);
        minskAirport.click();
    }

    public void clickOnCalendar() {
        calendar.click();
    }

    public void choosingPeriod (String period) {
        List<WebElement> all_dates = allDates;

        for (WebElement el:all_dates) {
            String date = el.getText();

            if (date.equalsIgnoreCase(period)) {
                el.click();
                break;
            }
        }
    }

    public void enterAge(String years) {
        age.clear();
        age.sendKeys(years);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
