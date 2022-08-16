package pages;

import io.appium.java_client.AppiumDriver;
import jdk.nashorn.internal.ir.annotations.Ignore;

public class WaitActions extends BasePage {
    @Ignore
    public WaitActions(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Wait for the defined number of milliseconds until continuing.
     * @name Sleep
     */
    public void Sleep(int milliseconds)
    {
        sleep(milliseconds);
    }
}
