package pages.accommodations;

import driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelPage {
    @FindBy(id="hp_hotel_name")
    private WebElement hotelTitle;
    @FindBy (xpath="//div[@id = 'wrap-hotelpage-top']//button//span[text()[contains(.,'Reserve')]]")
    private WebElement reserveButton;
    @FindBy (xpath="//div[@class = 'hprt-reservation-cta']//button")
    private WebElement iWillReserveButton;

    public HotelPage() {
        PageFactory.initElements(WebDriverSingleton.getInstance(), this);
    }

    public String getHotelTitle() {
        return hotelTitle.getText();
    }

    public void clickReserveButton() {
        reserveButton.click();
    }

    public ReservationDetailsPage clickIWillReserveButton() {
        iWillReserveButton.click();
        return new ReservationDetailsPage();
    }
}
