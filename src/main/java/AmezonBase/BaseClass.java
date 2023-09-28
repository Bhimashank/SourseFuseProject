package AmezonBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ScreenshotUtils.UtilityScreenshot;

public class BaseClass {

    public WebDriver driver;
	
	@BeforeMethod
	public void setUpBrowser() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
	}
	
	
	@AfterMethod
	public void takesFailedScereenshotTasteCase(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus()) {
			UtilityScreenshot.takeFailedTestCase(driver, result.getName());
		}
		driver.quit();
	}
	
}
