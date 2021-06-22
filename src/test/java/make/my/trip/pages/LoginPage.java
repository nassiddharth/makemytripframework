package make.my.trip.pages;

import static make.my.trip.pageconstants.LoginConstants.Click_Next_Button;
import static make.my.trip.pageconstants.LoginConstants.Enter_Email_Address;
import static make.my.trip.pageconstants.LoginConstants.Enter_Password;
import static make.my.trip.pageconstants.LoginConstants.Login_Button;
import static make.my.trip.pageconstants.LoginConstants.Login_With_Google_Button;
import static make.my.trip.pageconstants.LoginConstants.Name_Text;
import static make.my.trip.pageconstants.LoginConstants.Use_Another_Account;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import make.my.trip.utilities.CommonUtility;
import make.my.trip.utilities.SynchronisationUtils;

public class LoginPage {

	protected WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = Login_Button)
	private WebElement loginBtn;

	@FindBy(xpath = Login_With_Google_Button)
	private WebElement loginWithGoogleBtn;

	@FindBy(xpath = Use_Another_Account)
	private WebElement useAnothAccountBtn;

	@FindBy(xpath = Enter_Email_Address)
	private WebElement enterEmail;

	@FindBy(xpath = Click_Next_Button)
	private WebElement nextBtn;

	@FindBy(xpath = Enter_Password)
	private WebElement passwordField;

	@FindBy(xpath = Name_Text)
	private WebElement name;

	public void clickLoginButton(String email, String password) throws InterruptedException {
		SynchronisationUtils.waitForElementToBeVisible(this.loginBtn, driver);
		String parentWindow = driver.getWindowHandle();
		CommonUtility.clickToElement(this.loginWithGoogleBtn, driver);
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!parentWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				SynchronisationUtils.waitForElementToBeVisible(this.enterEmail, driver);
				this.enterEmail.sendKeys(email);
				SynchronisationUtils.waitForElementToBeVisible(this.nextBtn, driver);
				this.nextBtn.click();
				SynchronisationUtils.waitForElementToBeClickable(this.passwordField, driver);
				this.passwordField.sendKeys(password);
				SynchronisationUtils.waitForElementToBeClickable(this.nextBtn, driver);
				this.nextBtn.click();
				SynchronisationUtils.staticWait(10);

			}

		}

		driver.switchTo().window(parentWindow);

	}

}
