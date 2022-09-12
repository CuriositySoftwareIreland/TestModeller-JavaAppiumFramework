package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CapabilityLoader;

import java.time.Duration;

public class MobileGeneralActions extends BasePage {
    @Ignore
    public MobileGeneralActions(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Puts the application in the background on the device for a certain duration.
     * @name Move App to Background
     */
    public void backgroundApp(int seconds)
    {
        m_Driver.runAppInBackground(Duration.ofSeconds(seconds));

        passStep("Background app for " + seconds + " seconds");
    }

    /**
     * Takes a screenshot of the current page and embeds it into the log.
     * @name Capture Page Screenshot
     */
    public void capturePageScreenshot()
    {
        passStep("Capture screenshot");
    }

    /**
     * Clears the text field identified by locator.
     * @name Clear Text
     */
    public void clearText(String locator)
    {
        MobileElement mobileElement = getElementByLocator(locator);

        mobileElement.clear();

        passStepWithScreenshot("Clear text");
    }

    /**
     * Click on a point
     * @name Click A Point
     */
    public void clickAPoint(int x, int y)
    {
        TouchAction action= new TouchAction(m_Driver);
        action.press(new PointOption().withCoordinates(x, y)).perform();

        passStepWithScreenshot("Click point x: '" + x + "', y: '" + y + "'");
    }

    /**
     * Click element identified by locator.
     * @name Click Element
     */
    public void clickElement(String locator)
    {
        MobileElement mobileElement = getElementByLocator(locator);

        mobileElement.click();

        passStepWithScreenshot("Click element with locator '" + locator + "'");

    }

    /**
     * Click element at a certain coordinate
     * @name Click Element At Coordinates
     */
    public void clickElementAtCoordinates(int x, int y)
    {
        TouchAction action= new TouchAction(m_Driver);
        action.press(new PointOption().withCoordinates(x, y)).release().perform();

        passStepWithScreenshot("Click element at point x: '" + x + "', y: '" + y + "'");
    }

    /**
     * Closes the current application.
     * @name Close Application
     */
    public void closeApplication()
    {
        m_Driver.closeApp();

        passStepWithScreenshot("Application closed");
    }

    /**
     * Verify that an attribute of an element matches the expected criteria.
     * @name Element Attribute Should Match
     */
    public void elementAttributeShouldMatch(String locator, String attr_name, String value)
    {
        MobileElement elem = getElementByLocator(locator);

        if (elem.getAttribute(attr_name) == null)
            failStep("Element '" + locator + "' does not contain attribute '" + attr_name + "'");

        if (!elem.getAttribute(attr_name).equals(value))
            failStep("Element '" + locator + "' attribute '" + attr_name + "' is of value '" + elem.getAttribute(attr_name) + "'. Expected value '" + value + "'.");

        passStep("Element '" + locator + "' has value '" + value + "' for attribute '" + attr_name + "'.");
    }
    /**
     * Verifies that element identified with locator is disabled.
     * @name Element Should Be Disabled
     */
    public void elementShouldBeDisabled(String locator)
    {
        MobileElement elem = getElementByLocator(locator);

        if (elem.isEnabled())
            failStep("The element '" + locator + "' is enabled.");

        passStep("The element '" + locator + "' is disabled.");
    }

    /**
     * Verifies that element identified with locator is enabled.
     * @name Element Should Be Enabled
     */
    public void elementShouldBeEnabled(String locator)
    {
        MobileElement elem = getElementByLocator(locator);

        if (!elem.isEnabled())
            failStep("The element '" + locator + "' is disabled.");

        passStep("The element '" + locator + "' is enabled.");
    }

    /**
     * Verifies that element identified with locator is visible.
     * @name Element Should Be Visible
     */
    public void elementShouldBeVisible(String locator)
    {
        MobileElement elem = getElementByLocator(locator);

        if (!elem.isDisplayed())
            failStep("The element '" + locator + "' is not visible.");

        passStep("The element '" + locator + "' is visible.");
    }

    /**
     * Verifies element identified by locator contains text expected.
     * @name Element Should Contain Text
     */
    public void elementShouldContainText(String locator, String text)
    {
        MobileElement elem = getElementByLocator(locator);

        if (!elem.getText().contains(text))
            failStep("The element '" + locator + "' does not contain text '" + text + "'. Found '" + elem.getText() + "'");

        passStep("The element contains text '" + text + "'");
    }

    /**
     * Verifies element identified by locator does not contain text expected.
     * @name Element Should Not Contain Text
     */
    public void elementShouldNotContainText(String locator, String text)
    {
        MobileElement elem = getElementByLocator(locator);

        if (elem.getText().contains(text))
            failStep("The element '" + locator + "' contains text '" + text + "'. Found '" + elem.getText() + "'");

        passStep("The element '" + locator + "' contains text '" + text + "'");
    }

    /**
     * Verifies element identified by locator exactly contains text expected.
     * @name Element Text Should Be
     */
    public void elementTextShouldBe(String locator, String text)
    {
        MobileElement elem = getElementByLocator(locator);

        if (!elem.getText().equals(text))
            failStep("The element '" + locator + "' text is '" + elem.getText() + "'. Expected '" + text + "'");

        passStep("The element '" + locator + "' text is '" + text + "'");
    }

    /**
     * Execute ADB shell commands
     * @name Execute Adb Shell
     */
    public void executeAdbShell(String command)
    {
        m_Driver.execute(command);

        passStep("Executing adb shell command '" + command + "'");
    }

    /**
     * Inject a snippet of Async-JavaScript into the page for execution in the context of the currently selected frame (Web context only).
     * @name Execute Async Script
     */
    public void executeAsyncScript(String script)
    {
        m_Driver.executeAsyncScript(script);

        passStep("Executing async script '" + script + "'");
    }

    /**
     * Inject a snippet of JavaScript into the page for execution in the context of the currently selected frame (Web context only).
     * @name Execute Script
     */
    public void executeScript(String script)
    {
        m_Driver.executeScript(script);

        passStep("Executing script '" + script + "'");
    }

    /**
     * Returns the current session ID as a reference
     * @name Get Appium SessionId
     */
    public String getAppiumSessionId()
    {
        return m_Driver.getSessionId().toString();
    }

    /**
     * Return the desired capability value by desired capability name
     * @name Get Capability
     */
    public String getCapability(String capability)
    {
        return CapabilityLoader.getCapability(capability);
    }

    /**
     * Add a desired capability value by desired capability name
     * @name Add Capability
     */
    public void addCapability(String capabilityName, String value)
    {
        CapabilityLoader.addCapability(capabilityName, value);
    }

    /**
     * Get element attribute using given attribute: name, value,...
     * @name Get Element Attribute
     */
    public String getElementAttribute(String locator, String attribute)
    {
        MobileElement elem = getElementByLocator(locator);

        return elem.getAttribute(attribute);
    }

    /**
     * Get element location
     * @name Get Element Location
     */
    public Point getElementLocation(String locator)
    {
        MobileElement elem = getElementByLocator(locator);

        return elem.getLocation();
    }

    /**
     * Get element size
     * @name Get Element Size
     */
    public Dimension getElementSize(String locator)
    {
        MobileElement elem = getElementByLocator(locator);

        return elem.getSize();
    }

    /**
     * Returns number of elements matching xpath
     * @name Get Matching Xpath Count
     */
    public int getMatchingXpathCount(String xpath)
    {
        return m_Driver.findElements(By.xpath(xpath)).size();
    }

    /**
     * Returns the entire source of the current page.
     * @name Get Source
     */
    public String getSource()
    {
        return m_Driver.getPageSource();
    }

    /**
     * Get element text (for hybrid and mobile browser use xpath locator, others might cause problem)
     * @name Get Text
     */
    public String getText(String locator)
    {
        MobileElement elem = getElementByLocator(locator);

        return elem.getText();
    }

    /**
     * Get current device height.
     * @name Get Window Height
     */
    public int getWindowHeight()
    {
        return m_Driver.manage().window().getSize().height;
    }

    /**
     * Get current device width.
     * @name Get Window Width
     */
    public int getWindowWidth()
    {
        return m_Driver.manage().window().getSize().width;
    }

    /**
     * Hides the software keyboard on the device.
     * @name Hide Keyboard
     */
    public void hideKeyboard()
    {
        m_Driver.hideKeyboard();

        passStep("Hide keyboard");
    }

    /**
     * Types the given text into text field identified by locator.
     * @name Input Text
     */
    public void inputText(String locator, String text)
    {
        MobileElement elem = getElementByLocator(locator);

        elem.sendKeys(text);

        passStep("Input text '" + text + "' into element '" + locator + "'");
    }

    /**
     * Sets the given value into text field identified by locator. This is an IOS only keyword, input value makes use of set_value
     * @name Input Value
     */
    public void inputValue(String locator, String value)
    {
        MobileElement elem = getElementByLocator(locator);

        elem.setValue(value);

        passStep("Ser value '" + value + "' into element '" + locator + "'");
    }

    /**
     * Start Activity App via Appium
     * @name Start Activity
     */
    public void startActivity(String applicationPackage, String applicationActivity)
    {
        ((AndroidDriver) m_Driver).startActivity(new Activity(    applicationPackage, applicationActivity));

        passStep("Start activity '" + applicationActivity + "' from package '" + applicationPackage + "'");
    }

    /**
     * Install App via Appium
     * @name Install App
     */
    public void installApp(String applicationPath)
    {
        m_Driver.installApp(applicationPath);
    }

    /**
     * Set the device orientation to LANDSCAPE
     * @name Landscape
     */
    public void landscape()
    {
        m_Driver.rotate(ScreenOrientation.LANDSCAPE);

        passStep("Set orientation to landscape");
    }

    /**
     * Lock the device for a certain period of time. iOS only.
     * @name Lock
     */
    public void lock()
    {
        ((IOSDriver) m_Driver).lockDevice();

        passStep("Device locked");
    }

    /**
     * Long press the element with optional duration
     * @name Long Press
     */
    public void longPress(String locator)
    {
        TouchActions action = new TouchActions(m_Driver);
        action.longPress(getElementByLocator(locator));
        action.perform();

        passStep("Long press element '" + locator + "'");
    }

    /**
     * Opens a new application to given Appium server with the Capabilities defined previously.
     * @name Connect Appium
     */
    public void connectAppium(String remote_url)
    {
        setDriver(CapabilityLoader.createDriver(remote_url));
    }

    /**
     * Opens a new application to given SauceLabs US server via Appium.
     * @name Connect SauceLabs (US Server)
     */
    public void connectSauceLabsUS(String username, String accessKey)
    {
        setDriver(CapabilityLoader.createSauceLabsDriver(username, accessKey, "us"));
    }

    /**
     * Opens a new application to given SauceLabs EU server via Appium.
     * @name Connect SauceLabs (EU Server)
     */
    public void connectSauceLabsEU(String username, String accessKey)
    {
        setDriver(CapabilityLoader.createSauceLabsDriver(username, accessKey, "eu"));
    }

    /**
     * Verifies that current page contains locator element.
     * @name Page Should Contain Element
     */
    public void pageShouldContainElement(String locator)
    {
        MobileElement elem =  (MobileElement) m_Driver.findElement(By.xpath(locator));

        if (elem == null)
            failStep("Element not found with locator " + locator);

        passStep("Element found with locator '" + locator + "'");
    }

    /**
     * Verifies that current page not contains locator element.
     * @name Page Should Not Contain Element
     */
    public void pageShouldNotContainElement(String locator)
    {
        MobileElement elem =  (MobileElement) m_Driver.findElement(By.xpath(locator));

        if (elem != null)
            failStep("Element found with locator " + locator);

        passStep("Element not found with locator '" + locator + "'");
    }

    /**
     * Set the device orientation to PORTRAIT
     * @name Portrait
     */
    public void portrait()
    {
        m_Driver.rotate(ScreenOrientation.PORTRAIT);

        passStep("Set orientation to portrait");
    }

    /**
     * Quit application. Application can be quit while Appium session is kept alive. This keyword can be used to close application during test case or between test cases.
     * @name Quit Application
     */
    public void quitApplication()
    {
        m_Driver.closeApp();

        passStep("Close application");
    }

    /**
     * Reset application. Open Application can be reset while Appium session is kept alive.
     * @name Reset Application
     */
    public void resetApplication()
    {
        m_Driver.resetApp();

        passStep("Reset application");
    }

    /**
     * Scrolls to element
     * @name Scroll to Element
     */
    public void scrollToElement(String locator)
    {
        TouchActions action = new TouchActions(m_Driver);
        action.scroll(getElementByLocator(locator), 0, 0);
        action.perform();

        passStep("Scroll to element '" + locator + "'");
    }

    /**
     * Swipe from one point to another point, for an optional duration.
     * @name Swipe
     */
    public void swipe(int start_x, int start_y, int offset_x, int offset_y, int duration)
    {
        new TouchAction(m_Driver)
                .press(PointOption.point(start_x, start_y))
                // a bit more reliable when we add small wait
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                .moveTo(PointOption.point(offset_x, offset_y))
                .release().perform();

        passStep("Swipe action");
    }

    /**
     * Tap element identified by locator.
     * @name Tap
     */
    public void tap(String locator)
    {
        TouchActions action = new TouchActions(m_Driver);
        action.singleTap(getElementByLocator(locator));
        action.perform();

        passStep("Tap element '" + locator + "'");
    }

    /**
     * Waits until element specified with locator is visible.
     * @name Wait Until Element Is Visible
     */
    public void waitUntilElementIsVisible(String locator)
    {
        WebDriverWait wait = new WebDriverWait(m_Driver, 10);
        wait.until(ExpectedConditions.visibilityOf(getElementByLocator(locator)));
    }

    /**
     * Waits until element specified with locator appears on current page.
     * @name Wait Until Page Contains Element
     */
    public void waitUntilPageContainsElement(String locator)
    {
        WebDriverWait wait = new WebDriverWait(m_Driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
    }

    private MobileElement getElementByLocator(String objectLocator)
    {
        By locator = null;
        if (objectLocator.startsWith("id:")) {
            locator = By.id(objectLocator.replace("id:", ""));
        } else if (objectLocator.startsWith("class:")) {
            locator = By.className(objectLocator.replace("class:", ""));
        } else if (objectLocator.startsWith("xpath:")) {
            locator = By.xpath(objectLocator.replace("xpath:", ""));
        } else if (objectLocator.startsWith("css:")) {
            locator = By.cssSelector(objectLocator.replace("css:", ""));
        } else if (objectLocator.startsWith("accessibilityId:")) {
            locator = MobileBy.AccessibilityId(objectLocator.replace("accessibilityId:", ""));
        } else {
            locator = By.xpath(objectLocator);
        }

        MobileElement elem = (MobileElement) m_Driver.findElement(locator);

        if (elem == null)
            failStep("Element not found with locator " + locator);

        return elem;
    }
}
