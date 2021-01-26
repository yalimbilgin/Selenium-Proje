package seleniumdemo;

import org.openqa.selenium.By;
import org.testng.Assert;

public class Validations extends ElementService {
	
	public void verifyElementTextEqualsToText(By by, String text) {
		Assert.assertEquals(getElement(by).getText(), text);
	}
	
	public void verifyBooleanEqualsTrue(boolean bool) {
		Assert.assertEquals(bool, true);
	}
}
