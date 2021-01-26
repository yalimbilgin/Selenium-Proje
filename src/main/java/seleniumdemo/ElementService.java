package seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementService {
	
	private final int DEFAULT_WAIT = 20;
	public WebDriverWait wait;
	
	public ElementService() {
		wait= new WebDriverWait(TestBase.driver, DEFAULT_WAIT);
	}
	
	public WebElement getElement(By by) {
		return waitTillVisible(by);
	}
	
	public WebElement waitTillVisible(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public boolean waitTillElementContinsText(By by, String text) {
		return wait.until(ExpectedConditions.attributeContains(TestBase.driver.findElement(by), "innerHTML", text));
	}
}
