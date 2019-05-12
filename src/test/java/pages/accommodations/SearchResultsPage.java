package pages.accommodations;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {
    @FindBy(xpath="//a[@class = 'hotel_name_link url']//span")
    private List<WebElement> hotelURL;
    @FindBy(xpath="//div[@class = 'bui-checkbox__label filter_item css-checkbox']//span ")
    private List<WebElement> filters;

    public SearchResultsPage() {
        PageFactory.initElements(WebDriverSingleton.getInstance(), this);
    }

    public HotelPage choosingRightHotel(String hotelName) {
        List <WebElement> all_urls = hotelURL;

        for (WebElement el:all_urls) {
            String hotel = el.getText();

            if (hotel.equalsIgnoreCase(hotelName)) {
                el.click();
                break;
            }
        }
        return new HotelPage();
    }

    public void choosingFilterValue(String starsValue) {
        List <WebElement> all_filters = filters;

        for (WebElement el:all_filters) {
            String stars = el.getText();

            if (stars.equalsIgnoreCase(starsValue)) {
                el.click();
                break;
            }
        }
    }
}
