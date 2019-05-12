package util;

import driver.WebDriverSingleton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Helper {

    public static void waitForTime(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForTimeInMilliseconds(long timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void closeBrowser() throws IOException {
        WebDriverSingleton.getInstance().quit();
        WebDriverSingleton.destroyInstance();
    }

    public static void switchToCurrentWindow() {
        for (String handle : WebDriverSingleton.getInstance().getWindowHandles()) {
            if (!handle.equals(WebDriverSingleton.getInstance().getWindowHandle())) {
                WebDriverSingleton.getInstance().switchTo().window(handle);
                break;
            }
        }
    }

    public static void switchToWindow(int i) {
        ArrayList<String> tabs = new ArrayList<String>(WebDriverSingleton.getInstance().getWindowHandles());
        WebDriverSingleton.getInstance().switchTo().window(tabs.get(i));
    }
}
