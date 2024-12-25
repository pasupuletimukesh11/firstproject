package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registrationpage extends Basepage {

	 public Registrationpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtfirstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtlastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtemail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtphonenumber;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtpassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtcnfpassword;
	@FindBy(xpath="//label[normalize-space()='Yes']") WebElement rdbtnyes;
	@FindBy(xpath="//input[@name='agree']") WebElement chkboxaccept;
	@FindBy(xpath="//input[@value='Continue']") WebElement btncontinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement Successmessage;
	
	public void personaldetails(String fname,String lname,String email,String mobnum)
	{
		txtfirstname.sendKeys(fname);
		txtlastname.sendKeys(lname);
		txtemail.sendKeys(email);
		txtphonenumber.sendKeys(mobnum);
	}
	
	public void passwordentry(String pass,String cnfpass)
	{
		txtpassword.sendKeys(pass);
		txtcnfpassword.sendKeys(cnfpass);
	}

	public void newletter()
	{
		rdbtnyes.click();
	}

	public void termsandconditions()
	{
		chkboxaccept.click();
	}
	
	public void continueclick()
	{
		btncontinue.click();
	}
	
	public String success()
	{
		try
		{
			return Successmessage.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
}
