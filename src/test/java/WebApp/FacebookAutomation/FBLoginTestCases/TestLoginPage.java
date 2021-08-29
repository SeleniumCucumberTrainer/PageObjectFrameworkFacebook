package WebApp.FacebookAutomation.FBLoginTestCases;

import org.testng.annotations.Test;

import WebApp.FacebookAutomation.BaseClass.WebBaseTest;
import WebApp.FacebookAutomation.Pages.FBLoginPage;

public class TestLoginPage extends WebBaseTest{
	
	
	@Test
	public void testFacebookInvalidLogin(){
		
		FBLoginPage loginPage = new FBLoginPage(driver);
		loginPage.LoginFacebook();
		loginPage.verifyInvalidLogin();
		
		
	}

}
