package seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class App 
{
	protected static WebDriver driver = new ChromeDriver();
	private HomePage home = new HomePage(driver);
	private Pasaj pasaj = new Pasaj(driver);
	
	@Test
	public void Task1() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Desktop\\chromedriver.exe"); 
		home.navigate();
		home.search();
		home.makeSearch("iPhone");
		home.clickCihazlar();
		Assert.assertEquals(home.returnResult(), true);
	}
	
	@Test
	public void Task2() {
		home.navigate();
		home.clickPasaj();
		pasaj.clickBasket();
		Assert.assertEquals(pasaj.returnResult(), true);
	}
	
	@Test
	public void Task3() {
		home.navigate();
		home.clickPasaj();
		pasaj.scrollBottom();
		pasaj.clickMac();
		pasaj.clickMacPro();
		Assert.assertEquals(pasaj.returnResult1(), true);
		Assert.assertEquals(pasaj.returnResult2(), true);
		driver.close();
	}
   
}
