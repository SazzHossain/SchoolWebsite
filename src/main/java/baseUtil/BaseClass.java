package baseUtil;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;

public class BaseClass {
	
	public WebDriver driver;
	public HomePage homePage;
	
	@BeforeMethod
	public void starting() {
		System.setProperty("webdriver.chorome.driver", "C:\\Users\\msazz\\eclipse-workspace\\schoolWebsite\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.enthrallit.com/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		homePage = new HomePage(driver);
	}
	
	@AfterMethod
	public void ending() {
		driver.quit();
	}

}
