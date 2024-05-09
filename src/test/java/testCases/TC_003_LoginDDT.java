package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC_003_LoginDDT extends BaseClass
{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String password, String expres)
	{
		logger.info("**** Starting TC_003_LoginDDT *****");
		
		try {
	
			//Home page
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin(); //Login link under MyAccount
				
			//Login page
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin(); //Login button
				
			//My Account Page
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetPage=macc.isMyAccountPageExists();
			
			if(expres.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					logger.info("Login is successful............");
					macc.clickLogout();
					logger.info("Clicked on Logout...");
					Assert.assertTrue(true);
				}
				else
				{
					logger.error("Login is not successful with valid credentials which should be successful. Hence failing the test............");
					Assert.assertTrue(false);
				}
			}
			
			if(expres.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					logger.error("Login is successful with invalid credentials which should not be successful. Hence failing the test............");
					macc.clickLogout();
					logger.info("Clicked on Logout...");
					Assert.assertTrue(false);
				}
				else
				{
					logger.error("Login is not successful with invalid credentials as expectd. Hence Passing the test............");
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
			
		logger.info("**** Finished TC_003_LoginDDT *****");
	}
	
}








