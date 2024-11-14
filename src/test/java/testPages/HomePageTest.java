package testPages;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import baseUtil.BaseClass;

public class HomePageTest extends BaseClass {
	JavascriptExecutor js;
		
	@Test(enabled = true, priority = 1)
	public void clickLogoTest() throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("logo-id"))));	
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("logo-id")));	
		js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.preloader').remove();");
	
		homePage.clickLogo();
		Thread.sleep(3000);	
	}
	
	@Test(enabled = true, priority = 2)
	public void clickCoursesTest() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.preloader').remove();");
		
		homePage.clickCourses();
		Thread.sleep(5000);
	}
	
	@Test(enabled = true, priority = 3)
	public void LoginTest() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.preloader').remove();");
		
		Thread.sleep(2000);
		homePage.clickLogin();;
		Thread.sleep(2000);
		homePage.clickUserName();
		Thread.sleep(3000);
		homePage.clearUserName();
		Thread.sleep(2000);
		homePage.clickUserName();
		Thread.sleep(3000);
		homePage.clickPassword();
		Thread.sleep(3000);
		homePage.clickLoginButton();
		Thread.sleep(3000);
	}

}
