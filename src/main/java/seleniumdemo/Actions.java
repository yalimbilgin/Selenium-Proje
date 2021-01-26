package seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Actions extends ElementService {
	
	public void clickElement(By by) {
		getElement(by).click();
	}
	
	public void setTextElement(By by, String text) {
		getElement(by).sendKeys(text);
	}
	
	public void pressEnter(By by) {
		getElement(by).sendKeys(Keys.ENTER);
	}
	
	public void scrollBottom() {
		TestBase.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
	}
}
