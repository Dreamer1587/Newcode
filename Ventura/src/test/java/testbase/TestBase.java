package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utilities.ExtentManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties or;
	public static FileInputStream file;
	public static Logger log = Logger.getLogger(TestBase.class);
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;

	@BeforeSuite
	public void tearup() {

		File src = new File(System.getProperty("user.dir") + "\\Datafile.properties");

		try {
			file = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		or = new Properties();
		try {
			or.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\Executeables\\chromedriver.exe");
		driver = new ChromeDriver();
		log.debug("driver path accepted");

		driver.get(or.getProperty("url"));
		log.debug("Browser open");
		driver.manage().window().maximize();
		log.debug("window maximise");

	}

	@AfterSuite
	public void teardown() {

		if (driver != null) {

			driver.quit();
		}
		log.debug("drivers closed");
	}
}
