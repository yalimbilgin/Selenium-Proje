package seleniumdemo;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pasaj {
	private static WebDriver driver;
	private static Logger logger;
	private By sepet = By.className("o-p-header__my-basket");
	private By text = By.xpath("//*[@id=\"basket\"]/div/div/form/div[1]/div/div/h3");
	private By mac = By.xpath("/html/body/footer/div[1]/div/nav/div/div[3]/ul/li[11]/a");
	private By macPro = By.xpath("//*[@id=\"all-devices-section\"]/div[26]/a/div[1]/div/div[1]/div/div[1]/figure");
	private By price = By.className("a-price-val");
	private By price6 = By.xpath("//*[@id=\"product-detail\"]/div[1]/div/div/div[2]/form/div[2]/label/div[2]/a[1]");
	private By price9 = By.xpath("//*[@id=\"product-detail\"]/div[1]/div/div/div[2]/form/div[2]/label/div[2]/a[2]");
	
	public Pasaj(WebDriver drv) {
		driver = drv;
		logger = LogManager.getLogger(Pasaj.class);
	}
	
	public void clickBasket() {
		driver.findElement(sepet).click();
		logger.debug("Clicked the sepet button");
	}
	
	public boolean returnResult() {
		Boolean result = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.attributeContains(driver.findElement(text), "innerHTML", "Sepetinizde ürün bulunmamaktadır."));
		logger.debug("Result" + result);
		return result;
	}
	
	public double format(String str) {
		return Double.parseDouble(str.charAt(0) + str.substring(2, 5) +"." + str.substring(7));
	}
	
	public void scrollBottom() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		logger.debug("Scrolled bottom");
	}
	
	public void clickMac() {
		driver.findElement(mac).click();
		logger.debug("Clicked the Macbook button");
	}
	
	public void clickMacPro() {
		driver.findElement(macPro).click();
		logger.debug("Clicked the Macbook Pro element");
	}
	
	public boolean returnResult1() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		Boolean result = format(driver.findElement(price).getAttribute("innerHTML").toString()) >= 1000;
		logger.debug("Result" + result);
		return result;
	}
	
	public boolean returnResult2() {
		Boolean result = format(driver.findElement(price6).getAttribute("data-price").toString()) > format(driver.findElement(price9).getAttribute("data-price").toString());
		logger.debug("Result" + result);
		return result;
	}
}
