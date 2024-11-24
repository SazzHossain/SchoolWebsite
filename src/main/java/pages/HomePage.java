package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//We have to manually import to get access of CommonActions class.
//This is called static import
import static commonMethods.CommonActions.*;

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy
	(id = "logo-id")
	WebElement logo;
	
	@FindBy
	(xpath = "//*[text()='Courses'][1]")
	WebElement courses;
	
	@FindBy
	(id = "login-link")
	WebElement loginHeader;
	
	@FindBy
	(name = "username")
	WebElement username;
	
	@FindBy
	(xpath = "//*[@id='password']")
	WebElement password;
	
	@FindBy
	(id = "login")
	WebElement loginBtn;
	
	@FindBy
	(linkText = "Enroll Now")
	WebElement enrollNow;
	
	@FindBy
	(partialLinkText = "Forgot Pass")
	WebElement forgotPassword;
	
	@FindBy
	(css = "div.col-lg-2.col-md-2.col-sm-2.d-flex.logo-div")
	WebElement logoCss;
	
	@FindBy
	(xpath = "(//*[text() = 'Mentors'])[1]")
	WebElement mentors;
	
	
	public void clickLogo() {
		pause(2000);
		try {	
			clickElement(logo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickCourses() {
		pause(3000);
		clickElement(courses);
		
	}
	
	public void clickLoginHeader() {
		pause(3000);
		clickElement(loginHeader);
	}
	
	public void typeIncorrectUserName() {
		pause(3000);
		elementDisplayed(username);
		inputText (username, "emailKoro@gmail.com");
	}
	
	public void typeUserName() {
		pause(3000);
		elementDisplayed(username);
		inputText (username, "mtks483@gmail.com");
	}
	
	public void clearUserName() {
		pause(3000);
		clearElement(username);
	}
	
	public void clickPassword() {
		pause(3000);
		elementDisplayed(password);
		inputText(password, "Tofael@483");
	}
	
	public void clickLoginButton() {
		pause(3000);
		elementEnabled(loginBtn);
		clickElement(loginBtn);
		pause(3000);
	}
	
	public void clickEnrollNow() {
		pause(2000);
		elementEnabled(enrollNow);
		clickElement(enrollNow);
		pause(3000);
	}
	
	public void clickForgotPassword() {
		pause(2000);
		clickElement(forgotPassword);
		pause(3000);
	}
	
	
	public void logoDisplayValidation() {
		pause(2000);
		elementDisplayed(logoCss);
		pause(2000);
	}
	
	public void clickMentors() {
		pause(2000);
		clickElement(mentors);
	}
	
	public void getMethodOfThePage() {
		
		//use of getTitle() -> example: driver.getTitle();
		elementDisplayed(logo);
		String actual = driver.getTitle();
		System.out.println("Title of the Page is: " + actual);//this line is not necessary
		String expected = "Enthrall IT";
		Assert.assertEquals(actual, expected, "Title didn't match lol you dummy ->>> =)) ");
		//Q: what if the assertion passed? Still this Sring value will show ?
		//A: in the console "Title didn't match lol you dummy ->>> =)) " will show only if the Assertion (validation) 		failed.
	
		//use of getCurrentUrl() -> example: driver.getCurrentUrl()
	String currentURL = driver.getCurrentUrl(); //we use this when we are not in the homepage and  we need to 	validate our current url
	System.out.println("Our current URL is: " + currentURL);
	String expectedURL = "https://enthrallit.com/";
	Assert.assertEquals(currentURL, expectedURL, "The driver failed to direct to the correct URL"); //the 	message here inside the String will show only when the assert validation is failed.
	
	//use of getText() -> we will call it directly with webelement. example: enrollNow.getText();
	String actualText = enrollNow.getText(); //if we want to see the text of this specific webelement
	System.out.println("Text present as: " + actualText);
	String expectedText = "Enroll Now";
	Assert.assertEquals(actualText, expectedText, "Text didn't match"); //the 	message here inside the String 	will show only when the assert validation is failed.
	}
	
	
	//getAttribute() gives us the value of the attribute value.
	public void useOfGetAttributeMethod() {
		elementSelected(username);
		pause(3000);
		String ml = username.getAttribute("maxlength");
		System.out.println("The value of the maxlength is: " + ml);
		
	}
	
	
//***********************************************************************************
	public void loginToEnthrallIT() {
		elementDisplayed(loginHeader);
		pause(2000);
		clickElement(loginHeader);
		pause(2000);
		elementDisplayed(username);
		inputText(username, "emailMe@gmail.com");
		pause(3000);
		clearElement(username);
		pause(2000);
		inputText(username, "mtks483@gmail.com");
		pause(2000);
		elementDisplayed(password);
		inputText(password, "Tofael@483");
		pause(2000);
		elementEnabled(loginBtn);
		//verifyTextOfTheWebElement(loginBtn, null); Text for the login button is not available in the Enthrall 		website
		clickElement(loginBtn);
		pause(3000);
	}
	

}
