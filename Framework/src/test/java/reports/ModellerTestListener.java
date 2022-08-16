package reports;

import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.TestBase;
import utilities.reports.ExtentReportManager;
import utilities.testmodeller.TestModellerLogger;

public class ModellerTestListener  extends TestBase implements ITestListener {
    @Override
    public void onStart(ITestContext iTestContext) {
        iTestContext.setAttribute("AppiumDriver", getDriver());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();

        AppiumDriver AppiumDriver = ((TestBase) testClass).getDriver();

        TestModellerLogger.PassStepWithScreenshot(AppiumDriver, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        AppiumDriver AppiumDriver = ((TestBase) testClass).getDriver();

        TestModellerLogger.FailStepWithScreenshot(AppiumDriver, "Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }
}
