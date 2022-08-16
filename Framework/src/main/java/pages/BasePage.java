package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import utilities.reports.ExtentReportManager;
import utilities.testmodeller.TestModellerLogger;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Ignore
public class BasePage {
    protected AppiumDriver m_Driver;

    protected WebDriverWait jsWait;

    protected JavascriptExecutor jsExec;


    public BasePage(AppiumDriver driver)
    {
        setDriver(m_Driver);
    }

    public void setDriver(AppiumDriver driver)
    {
        this.m_Driver = driver;

        if (m_Driver != null) {
        jsWait = new WebDriverWait(this.m_Driver, 10);
//
        jsExec = (JavascriptExecutor) this.m_Driver;
        }
    }

    protected void failStep(String msg, String details)
    {
        ExtentReportManager.failStepWithScreenshot(m_Driver, msg, details);

        TestModellerLogger.FailStepWithScreenshot(m_Driver, msg, details);

        Assert.fail(msg);
    }

    protected void failStep(String msg)
    {
        ExtentReportManager.failStepWithScreenshot(m_Driver, msg);
        TestModellerLogger.FailStepWithScreenshot(m_Driver, msg);

        Assert.fail(msg);
    }

    protected void passStep(String msg)
    {
        ExtentReportManager.passStep(msg);
        TestModellerLogger.PassStep(msg);
    }

    protected void passStepWithScreenshot(String msg)
    {
        ExtentReportManager.passStepWithScreenshot(m_Driver, msg);
        TestModellerLogger.PassStepWithScreenshot(m_Driver, msg);
    }

    protected RemoteWebElement expandRootElement(WebElement element) {
        RemoteWebElement ele = (RemoteWebElement) ((JavascriptExecutor) m_Driver).executeScript("return arguments[0].shadowRoot", element);

        return ele;
    }

    protected void sleep (Integer milliSeconds) {
        long secondsLong = (long) milliSeconds;
        try {
            Thread.sleep(secondsLong);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
