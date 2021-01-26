package seleniumdemo;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	Actions actions;
	Validations validations;
	ElementService elementService;
	protected static WebDriver driver = new ChromeDriver();
	private static Logger logger;
	
	public TestBase() {
		actions = new Actions();
		validations = new Validations();
		elementService = new ElementService();
	}
	
	public void scrollBottom() {
		actions.scrollBottom();
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver","resources\\chromedriver.exe");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		driver.get("https://www.turkcell.com.tr/");
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.close();
	}
 	
}
