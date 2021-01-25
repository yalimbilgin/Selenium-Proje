package seleniumdemo;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	private final int DEFAULT_WAIT = 20;
	public WebDriverWait wait= new WebDriverWait(driver, DEFAULT_WAIT);
	protected static WebDriver driver = new ChromeDriver();
	private static Logger logger;
	
	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Desktop\\chromedriver.exe");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		wait = new WebDriverWait(driver, DEFAULT_WAIT);
		driver.get("https://www.turkcell.com.tr/");
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.close();
	}
 	
}
