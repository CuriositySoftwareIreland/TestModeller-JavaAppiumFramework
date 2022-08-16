package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.security.krb5.internal.crypto.Des;

import java.net.MalformedURLException;
import java.net.URL;

public class CapabilityLoader
{
    private static final ThreadLocal<AppiumDriver> threadLocal = new ThreadLocal<AppiumDriver>();

    private static final ThreadLocal<DesiredCapabilities> capabilitiesThreadLocal = new ThreadLocal<DesiredCapabilities>();

    public static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = capabilitiesThreadLocal.get();

        if (desiredCapabilities == null) {
            desiredCapabilities = new DesiredCapabilities();

            capabilitiesThreadLocal.set(desiredCapabilities);
        }

        return desiredCapabilities;
    }

    public static AppiumDriver getDriver() {
        return threadLocal.get();
    }

    public static void setDriver(AppiumDriver driver) {
        threadLocal.set(driver);
    }

    public static AppiumDriver createAppiumDriver()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");

        try {
            return  new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void addCapability(String capabilityName, String value)
    {
        getDesiredCapabilities().setCapability(capabilityName, value);
    }

    public static String getCapability(String capabilityName)
    {
        return getDesiredCapabilities().getCapability(capabilityName).toString();
    }

    public static AndroidDriver createDriver(String url)
    {
        AndroidDriver driver = null;

        try {
            driver = new AndroidDriver<MobileElement>(new URL(url), getDesiredCapabilities());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        setDriver(driver);

        return driver;
    }
}
