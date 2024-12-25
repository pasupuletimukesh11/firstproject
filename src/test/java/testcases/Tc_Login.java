package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import testbase.Basetest;


public class Tc_Login extends Basetest {
	
	@Test
	public void login_validation()
	{
		Homepage hp=new Homepage(driver);
		hp.clickaccount();
		hp.clicklogin();
		
		Loginpage lp=new Loginpage(driver);
		lp.loginwithcredentials(p.getProperty("email"), p.getProperty("password"));
		
		Myaccountpage myp=new Myaccountpage(driver);
		Assert.assertTrue(myp.msgcheck());
		
	}
	

}
