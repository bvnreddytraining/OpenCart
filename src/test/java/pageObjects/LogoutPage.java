package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LogoutPage extends BasePage {
	
	
	public LogoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h1[text()='Account Logout']")
	WebElement lblAccountLogOut;
	
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement btnContinue;
	
	public boolean isAccountLogOutPageExists()   //Account LogOut Page heading display status
	{
		try {
			return (lblAccountLogOut.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickContinue() {
		btnContinue.click();

	}
	
}
