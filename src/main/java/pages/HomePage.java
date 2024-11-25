package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//We have to manually import to get access of CommonActions class.
//This is called static import
import static commonMethods.CommonActions.*;

import java.util.List;
import java.util.Set;

public class HomePage {
	
	public WebDriver driver;
	public Select select;

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
	
	@FindBy
	(linkText = "Automation")
	WebElement automationBtn;
	
	@FindBy
	(xpath = "//*[@class='automation-main-btn']")
	WebElement mouseHoverActionBtn;
	
	@FindBy
	(linkText = "Enroll Now")
	WebElement enrollNowInsideMouseHover;
	
	@FindBy
	(xpath = "//*[text() = 'Please enter your personal and contact information.'] ")
	WebElement childWindowHeader;
	
	@FindBy
	(xpath = "//*[@name='f_name']")
	WebElement fName;
	
	@FindBy
	(xpath = "//*[@name='m_name']")
	WebElement mName;
	
	@FindBy
	(xpath = "//*[@name='l_name']")
	WebElement lName;
	
	@FindBy
	(xpath = "//*[@name='i_am']")
	WebElement imDropDown;
	
	@FindBy
	(xpath = "//*[@id='id_course_wish_to_enroll']")
	WebElement courseWishToEnroll;
	
	@FindBy
	(xpath = "//*[@name='phone']")
	WebElement phoneNumber;
	
	@FindBy
	(xpath = "//*[@name='email']")
	WebElement emailInput;
	
	@FindBy
	(xpath = "//*[@name='password']")
	WebElement passwordInput;
	
	
	@FindBy
	(xpath = "//*[@id='id_birth_year']")
	WebElement birthYear;
	
	@FindBy
	(xpath = "//*[@name='birth_year']/option")
	List <WebElement> birthYearList;
	
	@FindBy
	(xpath = "//*[@id='id_gender']")
	WebElement gender;
	
	
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
	
	public void useOfMouseHoverOver() {
		pause(3000);
		clickElement(loginHeader);
		inputText(username, "mtks483@gmail.com");
		inputText(password, "Tofael@483");
		clickElement(loginBtn);
		//Avobe actions are just for login to the website.
		clickElement(automationBtn);
		Actions actions = new Actions(driver);
		actions.moveToElement(mouseHoverActionBtn).build().perform();
		pause(3000);
		clickElement(enrollNowInsideMouseHover);
		pause(3000);
	}
	
	public void switchBetweenWindows() {
		pause(3000);
		clickElement(loginHeader);
		inputText(username, "mtks483@gmail.com");
		inputText(password, "Tofael@483");
		clickElement(loginBtn);
		clickElement(automationBtn);
		Actions actions = new Actions(driver);
		actions.moveToElement(mouseHoverActionBtn).build().perform();
		pause(3000);
		clickElement(enrollNowInsideMouseHover); // a child window will open
		pause(3000);
		//avobe actions are just to go to the different window
		//getWindowHandle() method can handle only one window
		//getWindowHandles() method can handle more than one window
		Set<String> allWindowHandles =  driver.getWindowHandles(); //we have to keep it under set or list. since 		we don't want duplicate we well use 	set
		//Extract Parent and child window from all window handles
		String parent = (String) allWindowHandles.toArray()[0];
		String child = (String) allWindowHandles.toArray()[1];
		driver.switchTo().window(child);
		pause(3000);
		verifyTextOfTheWebElement(childWindowHeader, "Please enter your personal and contact information.");
		pause(3000);
	}
	
	public void registration() {
		pause(3000);
		clickElement(loginHeader);
		inputText(username, "mtks483@gmail.com");
		inputText(password, "Tofael@483");
		clickElement(loginBtn);
		clickElement(automationBtn);
		/*
		 * Actions actions = new Actions(driver);
		 * actions.moveToElement(mouseHoverActionBtn).build().perform(); pause(3000);
		 * clickElement(enrollNowInsideMouseHover); // a child window will open
		 * pause(3000);
		 */
		//avobe actions are just to go to the different window
		//getWindowHandle() method can handle only one window
		//getWindowHandles() method can handle more than one window
		/*
		 * Set<String> allWindowHandles = driver.getWindowHandles(); //we have to keep
		 * it under set or list. since we don't want duplicate we well use set //Extract
		 * Parent and child window from all window handles String parent = (String)
		 * allWindowHandles.toArray()[0]; String child = (String)
		 * allWindowHandles.toArray()[1]; driver.switchTo().window(child); pause(3000);
		 *///avobe actions are just to move to the Enroll Now window
		switchToChildWindow(driver, mouseHoverActionBtn, enrollNowInsideMouseHover);
		inputText(fName, "Ana");
		pause(2000);
		inputText(mName, "Marizun");
		pause(2000);
		inputText(lName, "Khatimun");
		pause(2000);
		
		//clickElement(imDropDown);
		//use of dropdown -> select by value
		select = new Select(imDropDown);
		select.selectByValue("Staff");//pass String value //we have to make sure to select value. (not text)
		pause(3000);
		
		//select by index. (not used much in the industry)
		select = new Select(courseWishToEnroll);
		select.selectByIndex(1); //for choosing python, we took index 1, here index 0 is for the CourseWishToEnroll;
		pause(3000);
		
		inputText(phoneNumber, "5165165167");
		pause(2000);
		inputText(emailInput, "emailKoro@gmail.com");
		pause(2000);
		inputText(passwordInput, "Scanner#6!3#234%&Okay*");
		pause(2000);
		
		selectDropdown(gender, "Other"); //select by visible text from commonActions
		
		//select by visible text.
		select = new Select(birthYear);
		select.selectByVisibleText("1965"); //String type //make sure to select the text. (not value)
		pause(5000);
		
		//select from dropdown one by one... method from commonActions
		//selectElelementFromDropdownOnebyOne(birthYear, birthYearList); it takes very long time to execute. thats why we comment out this. i already tested it. it passed.`
		pause(5000);	
	}
	
	public void useOfKeyboardKeys() {
		pause(3000);
		clickElement(loginHeader);
		pause(3000);
		//inputText(username, "mtks483@gmail.com");
		inputTextThenClickTab(username, "mtks483@gmail.com");
		pause(3000);
		inputTextThenClickEnter(password, "Tofael@483");
		//inputTextThenClickReturn(password, "Tofael@483");//Keys.RETURN and Keys.ENTER both works as same
		pause(3000);

		

	}
	

}
