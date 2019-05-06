package web.page;

import driver.WebDriverSingleton;
import element.GenericElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Helper;
import web.elements.SearchResultsElements;

import java.util.List;

public class SearchResultsPage {
    private WebDriver driver = WebDriverSingleton.getInstance();

    public void choosingRightHotel(String hotelName) {
        List <WebElement> all_urls = driver.findElements(SearchResultsElements.HOTEL_URL.getBy());

        for (WebElement el:all_urls) {
            String hotel = el.getText();

            if (hotel.equalsIgnoreCase(hotelName)) {
                el.click();
                break;
            }
        }
    }

    public void choosingFilterValue(String starsValue) {
        List <WebElement> all_filters = driver.findElements(SearchResultsElements.FILTERS.getBy());

        for (WebElement el:all_filters) {
            String stars = el.getText();

            if (stars.equalsIgnoreCase(starsValue)) {
                el.click();
                break;
            }
        }
    }
}
