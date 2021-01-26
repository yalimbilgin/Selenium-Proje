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
		//super();
		logger = LogManager.getLogger(HomePage.class);
	}
	
	public void search() {
		actions.clickElement(searchButton);
		logger.debug("Clicked the search button");
	}
	
	public void makeSearch(String str) {
		actions.setTextElement(inputSearch, str);
		logger.debug("Entered the search parameter");
		actions.pressEnter(inputSearch);
		logger.debug("Pressed Enter");
	}
	
	public void clickCihazlar() {
		actions.clickElement(cihazlar);
		logger.debug("Clicked cihazlar button");
	}
	
	public boolean returnResult() {
		logger.debug("Result is ready");
		return elementService.waitTillElementContinsText(span, "iPhone");
	}
	
	public void clickPasaj() {
		actions.clickElement(pasaj);
		logger.debug("Clicked the pasaj button");
	}
	
}
