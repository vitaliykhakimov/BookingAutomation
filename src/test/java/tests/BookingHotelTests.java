package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.accommodations.*;
import util.Helper;
import pages.login.SignInPage;
import pages.main.MainPage;

import java.io.IOException;

public class BookingHotelTests {

    @Test (dependsOnMethods={"searchHotel"})
    public void reservationHotel() {
        MainPage mainPage = new MainPage();
        mainPage.enterMainPage();
        SignInPage signInPage = mainPage.clickSignInButton();
        signInPage.typeUsername("test_booking_auto@mail.ru");
        signInPage.clickNextButton();
        signInPage.typePassword("456842456842Aa");
        mainPage = signInPage.clickSignInButton();
        mainPage.enterPlaceField("Minsk");
        mainPage.clickOnCalendar();
        mainPage.choosingPeriod("18", "19");
        SearchResultsPage searchResultsPage = mainPage.clickSearchButton();
        searchResultsPage.choosingFilterValue("4 stars");
        Helper.waitForTime(3);
        HotelPage hotelPage = searchResultsPage.choosingRightHotel("Hotel Minsk");
        Helper.waitForTime(3);
        Helper.switchToCurrentWindow();
        hotelPage.clickReserveButton();
        Helper.waitForTime(2);
        ReservationDetailsPage reservationDetailsPage = hotelPage.clickIWillReserveButton();
        reservationDetailsPage.typeFirstAndLastNames("Hello", "Booking");
        ReservationFinalDetailsPage reservationFinalDetailsPage = reservationDetailsPage.clickFinalDetailsButton();
        reservationFinalDetailsPage.typeTelephoneNumber("+375291112233");
        ConfirmationPage confirmationPage = reservationFinalDetailsPage.clickCompleteReservationButton();
        Helper.waitForTime(10);
        confirmationPage.clickCloseButton();
        confirmationPage.goToMyBookingsPage();
        Assert.assertTrue(confirmationPage.getBookingTitle().equalsIgnoreCase("Hotel Minsk"));
    }

    @Test (dependsOnMethods={"reservationHotel"})
    public void cancelingReservation() {
        MainPage mainPage = new MainPage();
        mainPage.enterMainPage();
        SignInPage signInPage = mainPage.clickSignInButton();
        signInPage.typeUsername("test_booking_auto@mail.ru");
        signInPage.clickNextButton();
        signInPage.typePassword("456842456842Aa");
        signInPage.clickSignInButton();
        MyBookingsPage myBookingsPage = mainPage.goToMyBookingsPage();
        myBookingsPage.clickViewBookingButton();
        myBookingsPage.clickCloseButton();
        myBookingsPage.clickCancelBookingButton();
        myBookingsPage.choosingReasonAndCancelling("Remind, sorry");
        Helper.waitForTime(2);
        Assert.assertTrue(myBookingsPage.getCancellingInfo().equalsIgnoreCase("Your booking was successfully canceled"));
    }

    @Test
    public void searchHotel() {
        MainPage mainPage = new MainPage();
        mainPage.enterMainPage();
        mainPage.enterPlaceField("Minsk");
        mainPage.clickOnCalendar();
        mainPage.choosingPeriod("11", "12");
        SearchResultsPage searchResultsPage = mainPage.clickSearchButton();
        searchResultsPage.choosingFilterValue("4 stars");
        Helper.waitForTime(3);
        HotelPage hotelPage = searchResultsPage.choosingRightHotel("Hotel Minsk");
        Helper.waitForTime(3);
        Helper.switchToCurrentWindow();
        Assert.assertTrue(hotelPage.getHotelTitle().equalsIgnoreCase("Hotel Hotel Minsk"));
    }

    @Test (dependsOnMethods={"cancelingReservation"})
    public void bookHotelWithWrongBankCard() {
        MainPage mainPage = new MainPage();
        mainPage.enterMainPage();
        SignInPage signInPage = mainPage.clickSignInButton();
        signInPage.typeUsername("test_booking_auto@mail.ru");
        signInPage.clickNextButton();
        signInPage.typePassword("456842456842Aa");
        mainPage = signInPage.clickSignInButton();
        mainPage.enterPlaceField("Minsk");
        mainPage.clickOnCalendar();
        mainPage.choosingPeriod("28", "29");
        SearchResultsPage searchResultsPage = mainPage.clickSearchButton();
        searchResultsPage.choosingFilterValue("2 stars");
        Helper.waitForTime(3);
        HotelPage hotelPage = searchResultsPage.choosingRightHotel("IT Time Hotel");
        Helper.waitForTime(3);
        Helper.switchToCurrentWindow();
        hotelPage.clickReserveButton();
        Helper.waitForTime(2);
        ReservationDetailsPage reservationDetailsPage = hotelPage.clickIWillReserveButton();
        reservationDetailsPage.typeFirstAndLastNames("Hello", "Booking");
        ReservationFinalDetailsPage reservationFinalDetailsPage = reservationDetailsPage.clickFinalDetailsButton();
        reservationFinalDetailsPage.typeTelephoneNumber("+375291112233");
        reservationFinalDetailsPage.typeCardInfo("Visa", "5555 1111 2222 3333", "01 - Jan", "2019", "1234");
        reservationFinalDetailsPage.clickCompleteReservationButton();
        Assert.assertEquals(reservationFinalDetailsPage.getInvalidCardNumberMessage(), "Please fill in a valid card number");
        Assert.assertEquals(reservationFinalDetailsPage.getInvalidExpirationDateMessage(), "Please enter an expiration date that's valid during your booking dates");
        Assert.assertEquals(reservationFinalDetailsPage.getInvalidCVCMessage(), "Enter the 3-digit security code located on the back of your card");
    }

    @AfterMethod
    public void shutDown() throws IOException {
        Helper.closeBrowser();
    }
}
