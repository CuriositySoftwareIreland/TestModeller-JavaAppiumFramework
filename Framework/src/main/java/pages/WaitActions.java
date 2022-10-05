package pages;

import ie.curiositysoftware.testmodeller.TestModellerIgnore;
import io.appium.java_client.AppiumDriver;

public class WaitActions extends BasePage {
    @TestModellerIgnore
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
