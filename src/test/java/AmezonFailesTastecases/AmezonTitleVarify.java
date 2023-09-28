package AmezonFailesTastecases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import AmezonBase.BaseClass;
import ScreenshotUtils.UtilityScreenshot;

public class AmezonTitleVarify extends BaseClass {

	@Test(priority = 1)
	public   void varifyTitle() throws InterruptedException {
		UtilityScreenshot.waitForTime(3000);
		UtilityScreenshot.varifyTitleOfThePage(driver);
	}

	@Test(priority = 2)
	public void inputSearchText() throws InterruptedException {
		WebElement	searchProduct = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		UtilityScreenshot.waitForTime(3000);
		searchProduct.click();
		UtilityScreenshot.waitForTime(3000);
		searchProduct.sendKeys("iphones");

	}
}
