package tests;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.MobileGeneralActions;
import utilities.CapabilityLoader;

public class ExampleTest extends TestBase{

    @Test
    public void exampleTest ()
    {
        MobileGeneralActions generalActions = new MobileGeneralActions(getDriver());
        generalActions.addCapability("platformName", "Android");
        generalActions.openApplication("http://192.168.0.125:4723/wd/hub");

//        getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc=\"Messaging\"]")).click();
    }
}
