package AmezonBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ScreenshotUtils.UtilityScreenshot;

public class BaseClass {

    public WebDriver driver;
    public  Logger logger;
    
           ExtentTest test;
	public ExtentReports extent ;

	@BeforeSuite
	public void starttestCase() throws InterruptedException {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/extent_report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter); 
	}
	
    @BeforeClass	
	public void logGenerator() {
    	logger= Logger.getLogger("My selenium projects");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("***** Test Case Starting ****** ");
	}
    
	@BeforeMethod
	public void setUpBrowser() {
		//System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		logger.info("*** Amezon Page opened successfully ***");
		UtilityScreenshot.takeFailedTestCase(driver,"AmezonHomePage");
	}
	
	
	@AfterMethod
	public void takesFailedScereenshotTasteCase(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus()) {
			UtilityScreenshot.takeFailedTestCase(driver, result.getName());
		}
		driver.quit();
		logger.info("*** chromeBrowser closed successfully: Test case ended ***");
	}
	
	@AfterSuite
	public void endtestCase() {
		extent.flush();
	}
}
