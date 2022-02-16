package pageObjectPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverPackage.PageDriver;
import utilitiesPackage.CommonMethods;
import utilitiesPackage.Timeout;

public class P002_SignInpage extends CommonMethods{
	public P002_SignInpage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	Timeout timer = new Timeout();

	@FindBy(id = "email_create")
	public WebElement emailInputField;

	@FindBy(id = "SubmitCreate")
	public WebElement createAccountButton;

	@FindBy(id = "email")
	public WebElement emailLoginField;

	@FindBy(id = "passwd")
	public WebElement passwordLoginField;

	@FindBy(id = "SubmitLogin")
	public WebElement signInButton;

	public void createAccountWithEmail(String email) {
		sendText(emailInputField, email);
		createAccountButton.click();
		timer.waitForPageLoad();
	}

	public void loginwithEmailPassword(String email, String password) {
		sendText(emailLoginField, email);
		sendText(passwordLoginField, password);
		signInButton.click();
		timer.waitForPageLoad();
	}
}
