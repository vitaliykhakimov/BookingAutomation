package tests;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import util.Helper;
import pages.main.MainPage;
import pages.carrentals.CarRentalsPage;
import pages.login.SignInPage;

import java.io.IOException;

public class CarRentalsTest {

    @Test
    public void searchCar() {
        WebDriver driver = WebDriverSingleton.getInstance();
        MainPage mainPage = new MainPage();
        mainPage.enterMainPage();
        SignInPage signInPage = mainPage.clickSignInButton();
        signInPage.typeUsername("test_booking_auto@mail.ru");
        signInPage.clickNextButton();
        signInPage.typePassword("456842456842Aa");
        signInPage.clickSignInButton();
        CarRentalsPage carRentalsPage = mainPage.goToCarRentalPage();
        Helper.switchToCurrentWindow();
        carRentalsPage.enterPickupLocation("Minsk");
        carRentalsPage.clickOnCalendar();
        carRentalsPage.choosingPeriod("11");
        carRentalsPage.enterAge("25");
        carRentalsPage.clickSearchButton();
        Assert.assertTrue(driver.getTitle().equals("Car hire Minsk, Belarus at discounted rates with Booking.com"));
    }

    @AfterMethod
    public void shutDown() throws IOException {
        Helper.closeBrowser();
    }
}
