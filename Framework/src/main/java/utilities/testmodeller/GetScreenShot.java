package utilities.testmodeller;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class GetScreenShot {

    public static String captureAsImage(AppiumDriver driver,String screenShotName) throws IOException
    {
		if (driver == null)
			return "";
		
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = "report/"  +"/ErrorScreenshots/"+screenShotName+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);

        return "ErrorScreenshots/"+screenShotName+".png";
    }

    public static String captureAsBase64(AppiumDriver driver)
    {
		if (driver == null)
			return "";

        return "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

    public static byte[] captureAsByteArray(AppiumDriver driver)
    {
		if (driver == null)
			return null;

        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}