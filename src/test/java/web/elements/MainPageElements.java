package web.elements;

import element.GenericElement;
import org.openqa.selenium.By;

public class MainPageElements {
    public static String URL = "https://www.booking.com";

    public static GenericElement LOGO = new GenericElement("Logo", By.xpath("//img[@id = 'logo_no_globe_new_logo']"));
    public static GenericElement WHERE_TO_GO_INPUT = new GenericElement("Where to go", By.xpath("//input[@id = 'ss']"));
    public static GenericElement SEARCH_BTN = new GenericElement("Search", By.xpath("//button[@class = 'sb-searchbox__button  ']"));
    public static GenericElement CALENDAR = new GenericElement("Calendar", By.xpath("//span[@class = 'sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']"));
    public static GenericElement ALL_DATES = new GenericElement("All dates", By.xpath("//table[@class = 'bui-calendar__dates']//td"));
    public static GenericElement CALENDAR_TABLE = new GenericElement("Calendar table", By.xpath("//table[@class = 'bui-calendar__dates']"));
    public static GenericElement AVIATICKETS = new GenericElement("AviaTickets", By.xpath("//div[@class = 'cross-product-bar__wrapper ']//a[@class = \"xpb__link\"]"));
}
