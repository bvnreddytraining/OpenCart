package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"regression","Master"})
	public void verify_account_registration()
	{
		
		logger.info("************* Starting TC_001_AccountRegistrationTest **************");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Cliked on My Account link..");
		hp.clickRegister();
		logger.info("Clicked on Register link...");
		
		logger.info("Entering customer details in Register Account page");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString());
		regpage.setLastName(randomeString());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		
		regpage.setPrivacyPolicy();
		logger.info("Checked on privacy policy");
		regpage.clickContinue();
		logger.info("Clicked on Continue....");
		
		String confmsg=regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!")) {
			logger.info("Validated the message 'Your Account Has Been Created!' ");
			AssertJUnit.assertEquals(confmsg, "Your Account Has Been Created!");
		}else {
			logger.error("test case is failed........");
			AssertJUnit.fail();
		}
		
	}
	
	
	
	
}








