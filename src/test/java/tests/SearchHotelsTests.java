package tests;

import driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import web.elements.HotelPageElements;
import web.elements.MainPageElements;
import web.page.MainPage;
import util.Helper;
import web.elements.SearchResultsElements;
import java.io.IOException;
import java.util.ArrayList;

import web.page.SearchResultsPage;

public class SearchHotelsTests {
    private WebDriver driver = WebDriverSingleton.getInstance();
    private MainPageElements mpe = new MainPageElements();
    private MainPage mp = new MainPage();
    private SearchResultsElements sre = new SearchResultsElements();
    private SearchResultsPage srp = new SearchResultsPage();
    String currentWindow = driver.getWindowHandle();

    @Test
    public void searchHotelsTest() throws IOException {
        mp.enterMainPage();
        mp.enterPlaceField("Minsk");
        mp.clickOnCalendar();
        mp.choosingPeriod("11", "12");
        mp.clickSearchButton();
        srp.choosingFilterValue("4 stars");
        Helper.waitForTime(3);
        srp.choosingRightHotel("Hotel Minsk");
        Helper.waitForTime(3);
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(currentWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        Assert.assertTrue(driver.findElement(HotelPageElements.HOTEL_TITLE.getBy()).getText().equalsIgnoreCase("Hotel Hotel Minsk"));
    }

    @Test
    public void searchAndChooseRightHotel() throws IOException {
        mp.enterMainPage();
        mp.enterPlaceField("Minsk");
        mp.clickOnCalendar();
        mp.choosingPeriod("11", "12");
        mp.clickSearchButton();
        srp.choosingRightHotel("Hotel Minsk");
    }

    @AfterMethod
    public void shutDown() throws IOException {
        Helper.closeBrowser();
    }
}
