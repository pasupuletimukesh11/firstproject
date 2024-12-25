package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import testbase.Basetest;
import utilities.Dataproviderclass;

public class Tc_Login_DDT extends Basetest
{
	
	@Test(dataProvider="excel",dataProviderClass=Dataproviderclass.class)
	public void login_validation(String uname,String pass,String res)
	{
		Homepage hp=new Homepage(driver);
		hp.clickaccount();
		hp.clicklogin();
		
		Loginpage lp=new Loginpage(driver);
		lp.loginwithcredentials(uname,pass);
		
		Myaccountpage myp=new Myaccountpage(driver);
		Assert.assertTrue(myp.msgcheck());
		
		myp.logout();
		
	}
}
