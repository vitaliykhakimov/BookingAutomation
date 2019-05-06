package element;

import driver.WebDriverSingleton;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.List;

public class GenericElement extends By {
    private String name;
    private By by;
    WebDriver driver = WebDriverSingleton.getInstance();

    public GenericElement(String name, By by) {
        this.name = name;
        this.by = by;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public By getBy() { return by; }

    public void setBy(By by) { this.by = by; }

    public WebElement getWebElement() { return WebDriverSingleton.getInstance().findElement(by); }

    public List<WebElement> getWebelements() { return WebDriverSingleton.getInstance().findElements(by); }

    public Boolean isElementPresent() {
        try{
            getWebElement();
            return true;
        }
        catch (NoSuchElementException ex) {
            return false;
        }
    }

    public Boolean isElementsPresent() {
        try{
            getWebelements();
            return true;
        }
        catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void assertPresenceElement() {
        Assert.assertTrue(isElementPresent(), "Element " + name + "does not exist on this page");
    }

    public void assertPresenceElements() {
        Assert.assertTrue(isElementsPresent(), "Elements " + name + "do not exist on this page");
    }

    public void click() {
        assertPresenceElement();
        getWebElement().click();
    }

    public void sendKeys(String str) {
        assertPresenceElement();
        getWebElement().sendKeys(str);
    }

    public void choosingPeriod(int from, int to) {
        assertPresenceElements();

    }

    public List<WebElement> findElements(SearchContext searchContext) {
        return null;
    }
}
