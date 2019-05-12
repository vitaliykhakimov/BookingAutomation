package pages.main;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.accommodations.MyBookingsPage;
import pages.carrentals.CarRentalsPage;
import pages.login.SignInPage;
import pages.taxis.TaxisPage;
import util.Helper;
import pages.accommodations.SearchResultsPage;
import pages.flights.FlightsPage;

import java.util.List;

public class MainPage {
    @FindBy (xpath="//input[@id = 'ss']")
    private WebElement whereToGoInput;
    @FindBy (xpath="//button[@class = 'sb-searchbox__button  ']")
    private WebElement searchButton;
    @FindBy (xpath="//span[@class = 'sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']")
    private WebElement calendar;
    @FindBy (xpath="//table[@class = 'bui-calendar__dates']//td")
    private List<WebElement> allDates;
    @FindBy (xpath="//div[@class = 'header-wrapper']//li[@id = 'current_account']")
    private WebElement sighInButton;
    @FindBy (xpath="//span[text()[contains(.,\"Your Account\")]]")
    private WebElement yourAccount;
    @FindBy (xpath="//a[text()[contains(.,\"Bookings\")]]")
    private WebElement bookings;
    @FindBy (xpath="//span[text()[contains(., \"Car Rentals\")]]")
    private WebElement carRental;
    @FindBy (xpath="//span[text()[contains(., \"Flights\")]]")
    private WebElement flights;
    @FindBy (xpath="//span[text()[contains(., \"Airport Taxis\")]]")
    private WebElement airportTaxis;

    private  String url = "https://www.booking.com";
    private WebDriver getDriver() { return WebDriverSingleton.getInstance(); }

    public MainPage() {
        PageFactory.initElements(WebDriverSingleton.getInstance(), this);
    }

    public void enterMainPage() { getDriver().get(url); }

    public void enterPlaceField(String place) {
        whereToGoInput.clear();
        whereToGoInput.sendKeys(place);
    }

    public void clickOnCalendar() {
        calendar.click();
    }

    public void choosingPeriod (String from, String to) {
        List <WebElement> all_dates = allDates;

        for (WebElement el:all_dates) {
            String date = el.getText();

            if (date.equalsIgnoreCase(from)) {
                el.click();
                break;
            }
        }

        Helper.waitForTime(1);
        for (WebElement el:all_dates) {
            String date = el.getText();

            if (date.equalsIgnoreCase(to)) {
                el.click();
                break;
            }
        }
    }

    public SearchResultsPage clickSearchButton() {
        searchButton.click();
        return new SearchResultsPage();
    }

    public SignInPage clickSignInButton() {
        sighInButton.click();
        return new SignInPage();
    }

    public MyBookingsPage goToMyBookingsPage() {
        yourAccount.click();
        bookings.click();
        return new MyBookingsPage();
    }

    public CarRentalsPage goToCarRentalPage() {
        carRental.click();
        return new CarRentalsPage();
    }

    public FlightsPage goToFlightsPage() {
        flights.click();
        return new FlightsPage();
    }

    public TaxisPage goToTaxisPage() {
        airportTaxis.click();
        return new TaxisPage();
    }

}
