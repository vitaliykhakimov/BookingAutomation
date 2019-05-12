package tests;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.login.SignInPage;
import pages.main.MainPage;
import pages.taxis.TaxisPage;
import util.Helper;

import java.io.IOException;

public class TaxisTest {

    @Test
    public void searchTaxis() {
        WebDriver driver = WebDriverSingleton.getInstance();
        MainPage mainPage = new MainPage();
        mainPage.enterMainPage();
        SignInPage signInPage = mainPage.clickSignInButton();
        signInPage.typeUsername("test_booking_auto@mail.ru");
        signInPage.clickNextButton();
        signInPage.typePassword("456842456842Aa");
        signInPage.clickSignInButton();
        TaxisPage taxisPage = mainPage.goToTaxisPage();
        Helper.switchToCurrentWindow();
        taxisPage.enterLocations("Minsk National Airport (MSQ)", "vulica Valhahradskaja, Minsk, Belarus");
        taxisPage.chooseDate("18");
        taxisPage.clickSearchButton();
        Assert.assertTrue(driver.getTitle().equals("Search Results | Booking.com"));
    }

    @AfterMethod
    public void shutDown() throws IOException {
        Helper.closeBrowser();
    }
}
