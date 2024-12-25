package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage extends Basepage {

	public Myaccountpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement Accountmsg;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement btnlogout;
	
	public boolean msgcheck()
	{
		return Accountmsg.isDisplayed();
	}
	
	public void logout()
	{
		btnlogout.click();
	}
}
