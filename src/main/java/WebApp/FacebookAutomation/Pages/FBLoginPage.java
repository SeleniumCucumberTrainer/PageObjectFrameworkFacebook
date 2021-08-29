package WebApp.FacebookAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FBLoginPage {
	
	
	@FindBy(id="email")
	public WebElement EmailId;
	@FindBy(id="pass")
	public WebElement Password;
	@FindBy(name="login")
	public WebElement LoginButton;
	@FindBy(xpath="//div[text()='Wrong Credentials']")
	public WebElement WrongCredentialMsg;
	
	
	
	
	
	public WebDriver driver;
	
     public FBLoginPage(WebDriver driver){
    	 
    	 this.driver= driver;
    	 PageFactory.initElements(driver, this);
     }
	
	
	public void LoginFacebook(){
		
		EmailId.sendKeys("akhileshg50@gmail.com");
		Password.sendKeys("asaas");
		LoginButton.click();
		
		
	}
	
	public void verifyInvalidLogin(){
		
		boolean IsWrongCredeDisplayed = WrongCredentialMsg.isDisplayed();
		Assert.assertTrue(IsWrongCredeDisplayed);
	}

}
