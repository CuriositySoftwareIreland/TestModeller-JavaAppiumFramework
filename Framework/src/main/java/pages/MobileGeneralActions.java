package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.openqa.selenium.By;
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

    }

    /**
     * @name Element Name Should Be
     */
    public void elementNameShouldBe(String locator, String value)
    {

    }

    /**
     * Verifies that element identified with locator is disabled.
     * @name Element Should Be Disabled
     */
    public void elementShouldBeDisabled(String locator)
    {

    }

    /**
     * Verifies that element identified with locator is enabled.
     * @name Element Should Be Enabled
     */
    public void elementShouldBeEnabled(String locator)
    {

    }

    /**
     * Verifies that element identified with locator is visible.
     * @name Element Should Be Visible
     */
    public void elementShouldBeVisible(String locator)
    {

    }

    /**
     * Verifies element identified by locator contains text expected.
     * @name Element Should Contain Text
     */
    public void elementShouldContainText(String locator, String text)
    {

    }

    /**
     * Verifies element identified by locator does not contain text expected.
     * @name Element Should Not Contain Text
     */
    public void elementShouldNotContainText(String locator, String text)
    {

    }

    /**
     * Verifies element identified by locator exactly contains text expected.
     * @name Element Text Should Be
     */
    public void elementTextShouldBe(String locator, String text)
    {

    }

    /**
     * @name Element Value Should Be
     */
    public void elementValueShouldBe(String locator, String text)
    {

    }

    /**
     * Execute ADB shell commands
     * @name Execute Adb Shell
     */
    public void executeAdbShell(String command)
    {

    }

    /**
     * Inject a snippet of Async-JavaScript into the page for execution in the context of the currently selected frame (Web context only).
     * @name Execute Async Script
     */
    public void executeAsyncScript(String script)
    {

    }

    /**
     * Inject a snippet of JavaScript into the page for execution in the context of the currently selected frame (Web context only).
     * @name Execute Script
     */
    public void executeScript(String script)
    {

    }

    /**
     * Returns the current session ID as a reference
     * @name Get Appium SessionId
     */
    public String getAppiumSessionId()
    {
        return "";
    }

    /**
     * Gets the timeout in seconds that is used by various keywords.
     * @name Get Appium Timeout
     */
    public int getAppiumTimeout()
    {
        return 0;
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
     * Get available contexts.
     * @name Get Contexts
     */
    public String getContexts()
    {
        return "";
    }

    /**
     * Get current context.
     * @name Get Current Context
     */
    public String getCurrentContext()
    {
        return "";
    }

    /**
     * Get element attribute using given attribute: name, value,...
     * @name Get Element Attribute
     */
    public void getElementAttribute(String locator, String attribute)
    {

    }

    /**
     * Get element location
     * @name Get Element Location
     */
    public void getElementLocation(String locator)
    {

    }

    /**
     * Get element size
     * @name Get Element Size
     */
    public void getElementSize(String locator)
    {

    }

    /**
     * Returns number of elements matching xpath
     * @name Get Matching Xpath Count
     */
    public int getMatchingXpathCount(String xpath)
    {
        return 0;
    }

    /**
     * Returns the entire source of the current page.
     * @name Get Source
     */
    public String getSource()
    {
        return "";
    }

    /**
     * Get element text (for hybrid and mobile browser use xpath locator, others might cause problem)
     * @name Get Text
     */
    public void getText(String locator)
    {

    }

    /**
     * Returns the first WebElement object matching locator.
     * @name Get Webelement
     */
    public void getWebelement(String locator)
    {

    }

    /**
     * Returns list of WebElement objects matching locator.
     * @name Get Webelements
     */
    public void getWebelements(String locator)
    {

    }

    /**
     * Get current device height.
     * @name Get Window Height
     */
    public int getWindowHeight()
    {
        return 0;
    }

    /**
     * Get current device width.
     * @name Get Window Width
     */
    public int getWindowWidth()
    {
        return 0;
    }

    /**
     * Goes one step backward in the browser history.
     * @name Go Back
     */
    public void goBack()
    {

    }

    /**
     * Opens URL in default web browser.
     * @name Go To Url
     */
    public void goToUrl(String url)
    {

    }

    /**
     * Hides the software keyboard on the device.
     * @name Hide Keyboard
     */
    public void hideKeyboard()
    {

    }

    /**
     * Types the given password into text field identified by locator.
     * @name Input Password
     */
    public void inputPassword(String locator, String pswd)
    {

    }

    /**
     * Types the given text into text field identified by locator.
     * @name Input Text
     */
    public void inputText(String locator, String text)
    {

    }

    /**
     * Sets the given value into text field identified by locator. This is an IOS only keyword, input value makes use of set_value
     * @name Input Value
     */
    public void inputValue(String locator, String value)
    {

    }

    /**
     * Install App via Appium
     * @name Install App
     */
    public void installApp(String applicationPath, String applicationPackage)
    {

    }

    /**
     * Return true if Android keyboard is displayed or False if not displayed No parameters are used.
     * @name Is Keyboard Shown
     */
    public Boolean isKeyboardShown()
    {
        return false;
    }

    /**
     * Set the device orientation to LANDSCAPE
     * @name Landscape
     */
    public void landscape()
    {

    }

    /**
     * Launch application. Application can be launched while Appium session running. This keyword can be used to launch application during test case or between test cases.
     * @name Launch Application
     */
    public void launchApplication()
    {

    }

    /**
     * Lock the device for a certain period of time. iOS only.
     * @name Lock
     */
    public void lock()
    {

    }

    /**
     * Long press the element with optional duration
     * @name Long Press
     */
    public void longPress(String locator)
    {

    }

    /**
     * Sends a long press of keycode to the device.
     * @name Long Press Keycode
     */
    public void longPressKeycode(String locator, String keycode)
    {

    }

    /**
     * Opens a new application to given Appium server. Capabilities of appium server,
     * @name Open Application
     */
    public void openApplication(String remote_url)
    {
        setDriver(CapabilityLoader.createDriver(remote_url));
    }

    /**
     * Verifies that current page contains locator element.
     * @name Page Should Contain Element
     */
    public void pageShouldContainElement(String locator)
    {

    }

    /**
     * Verifies that current page contains text.
     * @name Page Should Contain Text
     */
    public void pageShouldContainText(String text)
    {

    }

    /**
     * Verifies that current page not contains locator element.
     * @name Page Should Not Contain Element
     */
    public void pageShouldNotContainElement(String locator)
    {

    }

    /**
     * Verifies that current page not contains text.
     * @name Page Should Not Contain Text
     */
    public void pageShouldNotContainText(String text)
    {

    }

    /**
     * Pinch in on an element a certain amount.
     * @name Pinch
     */
    public void pinch(String locator)
    {

    }

    /**
     * Set the device orientation to PORTRAIT
     * @name Portrait
     */
    public void portrait()
    {

    }

    /**
     * Sends a press of keycode to the device.
     * @name Press Keycode
     */
    public void pressKeycode(String keycode)
    {

    }

    /**
     * Quit application. Application can be quit while Appium session is kept alive. This keyword can be used to close application during test case or between test cases.
     * @name Quit Application
     */
    public void quitApplication()
    {

    }

    /**
     * Removes the application that is identified with an application id
     * @name Remove Application
     */
    public void removeApplication()
    {

    }

    /**
     * Reset application. Open Application can be reset while Appium session is kept alive.
     * @name Reset Application
     */
    public void resetApplication()
    {

    }

    /**
     * Scrolls from one element to another Key attributes for arbitrary elements are id and name.
     * @name Scroll
     */
    public void scroll(String startLocator, String endLocator)
    {

    }

    /**
     * Scrolls down to element
     * @name Scroll Down
     */
    public void scrollDown(String locator)
    {

    }

    /**
     * Scrolls up to element
     * @name Scroll Up
     */
    public void scrollUp(String locator)
    {

    }

    /**
     * Sets the timeout in seconds used by various keywords.
     * @name Set Appium Timeout
     */
    public void setAppiumTimeout(int seconds)
    {

    }

    /**
     * Set location
     * @name Set Location
     */
    public void setLocation(String latitude, String longitude, String altitude)
    {

    }

    /**
     * Sets the network connection Status.
     * @name Set Network Connection Status
     */
    public void setNetworkConnectionStatus(int status)
    {

    }

    /**
     * Shake the device
     * @name Shake
     */
    public void shake()
    {

    }

    /**
     * Swipe from one point to another point, for an optional duration.
     * @name Swipe
     */
    public void swipe(int start_x, int start_y, int offset_x, int offset_y, int duration)
    {

    }

    /**
     * Swipe from one percent of the screen to another percent, for an optional duration. Normal swipe fails to scale for different screen resolutions, this can be avoided using percent.
     * @name Swipe By Percent
     */
    public void swipeByPercent(int start_x, int start_y, int end_x, int end_y, int duration)
    {

    }

    /**
     * Switches the active application by index or alias.
     * @name Switch Application
     */
    public void switchApplication(int index)
    {

    }

    /**
     * Switch to a new context
     * @name Switch To Context
     */
    public void switchToContext(String context_name)
    {

    }

    /**
     * Tap element identified by locator.
     * @name Tap
     */
    public void tap(String locator)
    {

    }

    /**
     * Sends one or more taps with one or more touch points.iOS only.
     * @name Tap With Number Of Taps
     */
    public void tapWithNumberOfTaps(String locator, int noTaps)
    {

    }

    /**
     * Verifies that element identified with text is visible.
     * @name Text Should Be Visible
     */
    public void textShouldBeVisible(String text)
    {

    }

    /**
     * Waits until element specified with locator is visible.
     * @name Wait Until Element Is Visible
     */
    public void waitUntilElementIsVisible(String locator)
    {

    }

    /**
     * Waits until text appears on current page.
     * @name Wait Until Page Contains Text
     */
    public void waitUntilPageContains(String text)
    {

    }

    /**
     * Waits until element specified with locator appears on current page.
     * @name Wait Until Page Contains Element
     */
    public void waitUntilPageContainsElement(String locator)
    {

    }

    /**
     * Waits until text disappears from current page.
     * @name Wait Until Page Does Not Contain Text
     */
    public void waitUntilPageDoesNotContain(String text)
    {

    }

    /**
     * Waits until element specified with locator disappears from current page.
     * @name Wait Until Page Does Not Contain Element
     */
    public void waitUntilPageDoesNotContainElement(String locator)
    {

    }

    /**
     * Zooms in on an element a certain amount.
     * @name Zoom
     */
    public void zoom(String locator)
    {

    }

    private MobileElement getElementByLocator(String locator)
    {
        MobileElement elem =  (MobileElement) m_Driver.findElement(By.xpath(locator));

        if (elem == null)
            failStep("Element not found with locator " + locator);

        return elem;
    }
}
