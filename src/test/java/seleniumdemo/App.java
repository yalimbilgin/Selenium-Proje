package seleniumdemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class App extends TestBase
{
	private HomePage home = new HomePage();
	private Pasaj pasaj = new Pasaj();
 	
	@Test
	public void Task1() {
		home.search();
		home.makeSearch("iPhone");
		home.clickCihazlar();
		Assert.assertEquals(home.returnResult(), true);
	}
	
	@Test
	public void Task2() {
		home.clickPasaj();
		pasaj.clickBasket();
		Assert.assertEquals(pasaj.returnResult(), true);
	}
	
	@Test
	public void Task3() {
		home.clickPasaj();
		pasaj.scrollBottom();
		pasaj.clickMac();
		pasaj.clickMacPro();
		Assert.assertEquals(pasaj.returnResult1(), true);
		Assert.assertEquals(pasaj.returnResult2(), true);
	}
   
}
