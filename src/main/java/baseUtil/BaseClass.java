package baseUtil;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import commonMethods.CommonActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import pages.HomePage;

public class BaseClass {
	
	public WebDriver driver;
	public HomePage homePage;
	
	@BeforeMethod
	public void starting() {
		//1st way
		//System.setProperty("webdriver.chorome.driver", "C:\\Users\\msazz\\eclipse-workspace\\schoolWebsite\\driver\\chromedriver.exe");
		
		//2nd way
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		//driver = new ChromeDriver();
			
		//for firefor driver
		//System.setProperty("webdriver.chrome.driver", "./driver/geckodriver.exe");
		//driver = new FirefoxDriver();
		
		//for Edge driver
		//System.setProperty("webdriver.chrome.driver", "./driver/msedgedriver.exe");
		//driver = new EdgeDriver();
		
		//3rd way
		//we need to add WebDriverManager dependency in the pom.xml file
		//we don't need any physical driver for webdriver manager
		//when webdriver manager used, the most updated version of the browser will be initialized.
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//To specify the browser version, this way we can do it.(unnecessary)
		//WebDriverManager.chromedriver().driverVersion(129.0.6422.78).setup();
		//driver = new ChromeDriver();
		
		//for firefox
		//WebDriverManager.firefoxdriver().setup();
		//driver = new FirefoxDriver();
		
		//for edge
		//WebDriverManager.edgedriver().setup();
		//driver = new EdgeDriver();
		
		
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
