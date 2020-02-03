package utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testbase.TestBase;

public class Capturescreenshots extends TestBase {
	
	public static String screenshotName;

	public static void screenShot() throws IOException {

		Date date = new Date();
		String screenshotName = date.toString().replace(":", "_").replace(" ", "_") + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File(System.getProperty("user.dir") + "\\FailedScreenShots\\error.png_" + screenshotName));

	}

}
