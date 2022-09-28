package pages;

import io.appium.java_client.AppiumDriver;

public class WaitActions extends BasePage {
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
