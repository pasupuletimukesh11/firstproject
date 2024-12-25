package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Registrationpage;
import testbase.Basetest;

public class Tc_Registration extends Basetest {

	@Test
	public void registration()
	{
		Homepage hp=new Homepage(driver);
		hp.clickaccount();
		hp.clickregister();
		
		Registrationpage rp=new Registrationpage(driver);
		rp.personaldetails("Mukes21h", "Bab2u", "muke2s2h@gmail.com", "1232452678");
		rp.passwordentry("abc123", "abc123");
		rp.newletter();
		rp.termsandconditions();
		rp.continueclick();
		String msgvalidation=rp.success();
		Assert.assertEquals(msgvalidation, "Your Account Has Been Created!");	
	}
	
	
}
