package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	WebElement login;
	
	@FindBy
	(name = "username")
	WebElement username;
	
	@FindBy
	(xpath = "//*[@id='password']")
	WebElement password;
	
	@FindBy
	(id = "login")
	WebElement loginBtn;
	
	
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
	
	public void clickLogin() {
		pause(3000);
		clickElement(login);
	}
	
	public void typeIncorrectUserName() {
		pause(3000);
		inputText (username, "emailKoro@gmail.com");
	}
	
	public void typeUserName() {
		pause(3000);
		inputText (username, "mtks483@gmail.com");
	}
	
	public void clearUserName() {
		pause(3000);
		clearElement(username);
	}
	
	public void clickPassword() {
		pause(3000);
		inputText(password, "Tofael@483");
	}
	
	public void clickLoginButton() {
		pause(3000);
		clickElement(login);
		pause(3000);
	}

}
