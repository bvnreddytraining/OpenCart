package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups= {"sanity","Master"})
	public void loginOpenCart() {
		
		logger.info("********** Starting TC_002_LoginTest **************");
		try {
			
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account link in home page..........");
			hp.clickLogin(); // Click on Login link
			logger.info("Clicked on login link in home page..........");
			
			LoginPage lp = new LoginPage(driver);
//			boolean loginConfrm = lp.isLoginScreenDisplayed();
//			logger.info("Login Confirmation : "+loginConfrm);
//			if(loginConfrm == true) {
//				logger.info("Login Page is displayed.....");
//				Assert.assertTrue(true);
//			}else {
//				logger.error("Login Page is not displayed. Please check.");
//				Assert.assertTrue(false);
//			}
			
			logger.info("Login details are provided...");
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin(); // click on Login button in Login page
			
			MyAccountPage macc = new MyAccountPage(driver);
			
			boolean lblConfrm = macc.isMyAccountPageExists();
			if(lblConfrm == true) {
				logger.info("Login is successful.....");
				Assert.assertTrue(true);
			}else {
				logger.error("Login is not successful.....");
				Assert.assertTrue(false);
			}
			
			macc.clickLogout();
			logger.info("Clicked on logout link.....");
			
			LogoutPage lgp = new LogoutPage(driver);
			boolean logoutConfrm = lgp.isAccountLogOutPageExists();
			if(logoutConfrm == true) {
				logger.info("Accout Logout screen is displayed.....");
				Assert.assertTrue(true);
			}else {
				logger.info("Accout Logout screen is not displayed.....");
				Assert.assertTrue(false);
			}
			lgp.clickContinue();
			logger.info("Clicked on Continue in Accout Logout page.....");
			
			boolean logoutConfrm1 = lgp.isAccountLogOutPageExists();
			if(logoutConfrm1 == true) {
				logger.info("Logout screen is not successful.....");
				Assert.assertTrue(false);
			}else {
				logger.info("Logout is successful.....");
				Assert.assertTrue(true);
			}
			
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("*************** Finished TC_002_LoginTest ****************");
		
	}
	
}
