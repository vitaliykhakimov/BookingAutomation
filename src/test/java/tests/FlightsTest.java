package tests;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import util.Helper;
import pages.flights.FlightsPage;
import pages.login.SignInPage;
import pages.main.MainPage;

import java.io.IOException;

public class FlightsTest {

    @Test
    public void searchFlights() {
        WebDriver driver = WebDriverSingleton.getInstance();
        MainPage mainPage = new MainPage();
        mainPage.enterMainPage();
        SignInPage signInPage = mainPage.clickSignInButton();
        signInPage.typeUsername("test_booking_auto@mail.ru");
        signInPage.clickNextButton();
        signInPage.typePassword("456842456842Aa");
        signInPage.clickSignInButton();
        FlightsPage flightsPage = mainPage.goToFlightsPage();
        Helper.waitForTime(2);
        Helper.switchToCurrentWindow();
        flightsPage.enterLocations("Moscow",  "New York");
        Helper.waitForTime(3);
        flightsPage.enterPeriod("18", "19");
        flightsPage.clickSearchButton();
        Assert.assertTrue(driver.getTitle().equals("MOW to NYC, 11/5 — 19/5"));
    }

    @AfterMethod
    public void shutDown() throws IOException {
        Helper.closeBrowser();
    }
}
