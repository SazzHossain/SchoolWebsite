package baseUtil;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import io.github.bonigarcia.wdm.WebDriverManager;

import pages.HomePage;
import utils.Configuration;
import static utils.IConstant.*;
public class BaseClass {
	
	public WebDriver driver;
	public HomePage homePage;
	 public Configuration configuration;
	
	@BeforeMethod
	public void starting() {
		configuration = new Configuration();
		initDriver();
		driver.manage().window().maximize();
		driver.get(configuration.getProperties(URL));
		driver.manage().deleteAllCookies();
		long pageLoadWait = Long.parseLong(configuration.getProperties(PGELOAD_WAIT));
		long implicitlyWait =	Long.parseLong(configuration.getProperties(IMPLICITLY_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));	
		initClass();
	}
	
	public void initDriver() {
	String browserName =	configuration.getProperties(BROWSER);

	
	switch (browserName) {
	case CHROME:
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
		break;
		
		case FIREFOX:
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();	
		break;
		
		case EDGE:
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;
		
	default:
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
		break;
	}
	}
	
	public void initClass() {
		homePage = new HomePage(driver);
	}
	
	@AfterMethod
	public void ending() {
		driver.quit();
	}

}
