package ScreenshotUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UtilityScreenshot {
	
	public static  void takeFailedTestCase(WebDriver  driver, String screenShotName) {
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File("./screenshots/"+screenShotName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static  void waitForTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void varifyTitleOfThePage(WebDriver driver) {
		String amezonExpectedTitle ="Amazon.com. Spend less. Smile more.";
		String getAmezonActualTitle = driver.getTitle();
		try {
			Assert.assertEquals(getAmezonActualTitle, amezonExpectedTitle);
			System.out.println("Title is matched: Test Pass");
		} catch (Exception e) {
			System.out.println("Title not matched: Test fail");
		}
	}
	
	
	
	
}





