package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {

    private static WebDriver webDriver;

    public static WebDriver getInstance() {
        if (webDriver == null) {
            System.setProperty("webdriver.chrome.driver", "lib/driver/chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        }
        return webDriver;
    }

    public static void destroyInstance() { webDriver = null; }
}
