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
		//js = (JavascriptExecutor) driver;
		//js.executeScript("document.querySelector('.preloader').remove();");	
		homePage.clickCourses();
	}
	
	@Test(enabled = true, priority = 3)
	public void LoginTest()  {
		//js = (JavascriptExecutor) driver;
		//js.executeScript("document.querySelector('.preloader').remove();");		
		homePage.clickLogin();
		homePage.typeIncorrectUserName();
		homePage.clearUserName();
		homePage.typeUserName();
		homePage.clickPassword();
		homePage.clickLoginButton();
		//This is just Day01. There will be lots of new changes in coming days.
	}

}
