package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		logo.click();
	}
	
	public void clickCourses() {
		courses.click();
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public void clickUserName() {
		username.sendKeys("testaccount@infosys.com");
	}
	
	public void clearUserName() {
		username.clear();
	}
	
	public void clickPassword() {
		password.sendKeys("Il0v536@#%^*SDRGS");
	}
	
	public void clickLoginButton() {
		loginBtn.click();
	}

}
