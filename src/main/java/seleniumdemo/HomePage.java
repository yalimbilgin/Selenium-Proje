package seleniumdemo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class HomePage {
	private static WebDriver driver;
	private static Logger logger;
	private By searchButton = By.className("icon-search");
	private By inputSearch = By.name("qx");
	private By cihazlar = By.xpath("//*[@title='Cihazlar']");
	private By span = By.xpath("(//span[@class='m-p-pc__title'])[2]");
	private By pasaj = By.xpath("/html/body/header/div[2]/div/nav/a[1]");
	
	public HomePage(WebDriver drv) {
		driver = drv;
		logger = LogManager.getLogger(HomePage.class);
	}
	
	public void navigate() {
		driver.get("https://www.turkcell.com.tr/");
		driver.manage().window().maximize();
		logger.debug("Navigated to turkcell.com.tr");
	}
	
	public void search() {
		
		driver.findElement(searchButton).click();
		logger.debug("Clicked the search button");
	}
	
	public void makeSearch(String str) {
		driver.findElement(inputSearch).sendKeys(str);
		logger.debug("Entered the search parameter");
		driver.findElement(inputSearch).sendKeys(Keys.ENTER);
		logger.debug("Pressed Enter");
	}
	
	public void clickCihazlar() {
		WebElement cihazlarClickable = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(cihazlar));
		cihazlarClickable.click();
		logger.debug("Clicked cihazlar button");
	}
	
	public boolean returnResult() {
		
		Boolean result = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.attributeContains(driver.findElement(span), "innerHTML", "iPhone"));
		logger.debug("Result" + result);
		return result;
	}
	
	public void clickPasaj() {
		driver.findElement(pasaj).click();
		logger.debug("Clicked the pasaj button");
	}
	
}
