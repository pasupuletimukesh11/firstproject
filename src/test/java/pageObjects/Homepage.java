package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage{

	 public Homepage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement btnaccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement btnregister;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement btnlogin;
	
	public void clickaccount()
	{
		btnaccount.click();
	}
	
	public void clickregister()
	{
		btnregister.click();
	}
	
	public void clicklogin()
	{
		btnlogin.click();
	}
	
	
}
