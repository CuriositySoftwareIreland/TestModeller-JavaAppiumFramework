package reports;

import io.appium.java_client.AppiumDriver;
import tests.TestBase;
import utilities.reports.ExtentReportManager;
import utilities.testmodeller.GetScreenShot;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestListener extends TestBase implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        iTestContext.setAttribute("AppiumDriver", getDriver());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentReportManager.extentReport.flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        AppiumDriver AppiumDriver = ((TestBase) testClass).getDriver();
        ExtentReportManager.passStepWithScreenshot(AppiumDriver, "Test Passed");

//        ExtentReportManager.getCurrentTest().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        AppiumDriver AppiumDriver = ((TestBase) testClass).getDriver();
        ExtentReportManager.failStepWithScreenshot(AppiumDriver, "Test Failure");

        //ExtentReports log and screenshot operations for failed tests.
//        ExtentReportManager.getCurrentTest().log(Status.FAIL, iTestResult.getThrowable());

        ExtentReportManager.extentReport.flush();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }
}