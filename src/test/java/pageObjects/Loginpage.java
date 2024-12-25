package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage{
	
	public Loginpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='email']") WebElement txtemail;
	@FindBy(xpath="//input[@name='password']") WebElement txtpassword;
	@FindBy(xpath="//input[@value='Login']") WebElement btnlogin;
	
	public void loginwithcredentials(String uname,String pswd)
	{
		txtemail.sendKeys(uname);
		txtpassword.sendKeys(pswd);
		btnlogin.click();
	}

}
