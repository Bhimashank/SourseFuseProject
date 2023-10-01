package AmezonFailesTastecases;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import AmezonBase.BaseClass;
import ScreenshotUtils.UtilityScreenshot;

public class AmezonTitleVarify extends BaseClass  {

	@Test(priority = 1)
	public   void varifyTitle() throws InterruptedException {
		UtilityScreenshot.waitForTime(3000);
		UtilityScreenshot.varifyTitleOfThePage(driver);
		logger.info("*** Amezon title verified successfully ***");
	}   

	@Test(priority = 2)
	public void inputSearchText() throws InterruptedException {
		WebElement	searchProduct = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		UtilityScreenshot.waitForTime(3000);
		searchProduct.click();
		UtilityScreenshot.waitForTime(3000);
		searchProduct.sendKeys("iphones");
		logger.info("*** Amezon text entered in textbox successfully ***");
		UtilityScreenshot.takeFailedTestCase(driver,"Entered Text Field");
	}
	
	@Test(priority = 3)
	public void ckickOnAll() {
		UtilityScreenshot.waitForTime(2000);
		driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']//parent::div[@class='nav-left']")).click();
		UtilityScreenshot.waitForTime(3000);
		logger.info("*** Amezon All Link clicked successfully ***");
		UtilityScreenshot.takeFailedTestCase(driver,"clicked All Link");	
	}
}
