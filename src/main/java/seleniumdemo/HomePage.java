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
public class HomePage extends TestBase {
	private static Logger logger;
	private By searchButton = By.className("icon-search");
	private By inputSearch = By.name("qx");
	private By cihazlar = By.xpath("//*[@title='Cihazlar']");
	private By span = By.xpath("(//span[@class='m-p-pc__title'])[2]");
	private By pasaj = By.xpath("/html/body/header/div[2]/div/nav/a[1]");
	
	public HomePage() {
		
		logger = LogManager.getLogger(HomePage.class);
	}
	
	public void search() {
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
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
		WebElement cihazlarClickable = wait.until(ExpectedConditions.elementToBeClickable(cihazlar));
		cihazlarClickable.click();
		logger.debug("Clicked cihazlar button");
	}
	
	public boolean returnResult() {
		
		Boolean result = wait.until(ExpectedConditions.attributeContains(driver.findElement(span), "innerHTML", "iPhone"));
		logger.debug("Result" + result);
		return result;
	}
	
	public void clickPasaj() {
		driver.findElement(pasaj).click();
		logger.debug("Clicked the pasaj button");
	}
	
}
