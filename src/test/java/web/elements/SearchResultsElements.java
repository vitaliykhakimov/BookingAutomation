package web.elements;
import element.GenericElement;
import org.openqa.selenium.By;

public class SearchResultsElements {
    public static GenericElement SEARCH_RESULT = new GenericElement("Search result", By.xpath("//div[@class = 'sr_header ']//h1"));
    public static GenericElement HOTEL_URL = new GenericElement("Hotel URL", By.xpath("//a[@class = 'hotel_name_link url']//span"));
    public static GenericElement FILTERS = new GenericElement("Filter", By.xpath("//div[@class = 'bui-checkbox__label filter_item css-checkbox']//span"));
}
