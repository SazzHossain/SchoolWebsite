package testPages;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;


import baseUtil.BaseClass;

public class HomePageTest extends BaseClass {
	JavascriptExecutor js;
	
	@Test
	public void testLogoDisplay() {
		homePage.logoDisplayValidation();
	}
		
	@Test(enabled = true, priority = 1)
	public void clickLogoTest() {	
		//Intercepted Exception can be handled by JavascriptExecutor or Thread.sleep
		//js = (JavascriptExecutor) driver;
		//js.executeScript("document.querySelector('.preloader').remove();");
		homePage.clickLogo();
	}
	
	@Test
	public void clickEnrollNowTest() {
		homePage.clickEnrollNow();
	}
	
	@Test
	public void clickForgotPassTest() {
		homePage.clickLoginButton();;
		homePage.clickForgotPassword();;
	}
	
	@Test(enabled = true, priority = 2)
	public void clickCoursesTest()  {
		homePage.clickCourses();
	}
	
	@Test(enabled = true, priority = 3)
	public void LoginTest()  {
		homePage.clickLoginHeader();
		homePage.typeIncorrectUserName();
		homePage.clearUserName();
		homePage.typeUserName();
		homePage.clickPassword();
		homePage.clickLoginButton();
	}
	
	@Test
	public void navigateToBackForwardRefreshTest() throws InterruptedException {
		homePage.clickMentors();
		Thread.sleep(5000);
		homePage.clickCourses();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().forward();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(5000);		
	}
	
	@Test
	public void getMethodOfThePageTest() {
		homePage.getMethodOfThePage();
	}
	
	@Test
	public void getAttributeMethodTest() {
		homePage.clickLoginHeader();
		homePage.useOfGetAttributeMethod();
	}
	
	
	//********************************************************
	
	@Test
	public void loginToTheEnthrallItTest() {
		homePage.loginToEnthrallIT();
	}

}
