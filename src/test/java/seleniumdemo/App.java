package seleniumdemo;

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
		validations.verifyBooleanEqualsTrue(home.returnResult());
	}
	
	@Test
	public void Task2() {
		home.clickPasaj();
		pasaj.clickBasket();
		validations.verifyBooleanEqualsTrue(pasaj.returnResult());
	}
	
	@Test
	public void Task3() {
		home.clickPasaj();
		pasaj.scrollBottom();
		pasaj.clickMac();
		pasaj.clickMacPro();
		validations.verifyBooleanEqualsTrue(pasaj.returnResult1());
		validations.verifyBooleanEqualsTrue(pasaj.returnResult2());
	}
   
}
