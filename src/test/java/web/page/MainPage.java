package web.page;

import driver.WebDriverSingleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.elements.MainPageElements;
import util.Helper;

import java.util.List;

public class MainPage {
    private WebDriver driver = WebDriverSingleton.getInstance();

    public void enterMainPage() { driver.get(MainPageElements.URL); }

    public void enterPlaceField(String place) {
        MainPageElements.WHERE_TO_GO_INPUT.sendKeys(place);
    }

    public void clickOnCalendar() {
        MainPageElements.CALENDAR.click();
    }

    public void choosingPeriod (String from, String to) {
        List <WebElement> all_dates = driver.findElements(MainPageElements.ALL_DATES.getBy());

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

    public void clickSearchButton() {
        MainPageElements.SEARCH_BTN.click();
    }
}
