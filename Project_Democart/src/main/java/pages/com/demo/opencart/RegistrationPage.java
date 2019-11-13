package pages.com.demo.opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-firstname")
	WebElement FirstName;
	
	@FindBy(id = "input-lastname")
	WebElement LastName;
	
	@FindBy(id = "input-email")
	WebElement Email;
	
	@FindBy(id = "input-telephone")
	WebElement Telephone;
	
	@FindBy(id = "input-password")
	WebElement Password;
	
	@FindBy(id = "input-confirm")
	WebElement ConfirmPassword;
	
	@FindBy(name = "agree")
	WebElement Agree;
	
	@FindBy(xpath = "(//INPUT[@type='radio'])[2]")
	WebElement YesBtn;
	
	@FindBy(css = "#content > form > div > div > input.btn.btn-primary")
	WebElement RegBtn;
	
	@FindBy(xpath = "//DIV[@class='alert alert-danger alert-dismissible']")
	WebElement RegError;
	
	@FindBy(xpath = "//DIV[text()='First Name must be between 1 and 32 characters!']")
	WebElement FirstNameError;
	
	@FindBy(xpath = "//DIV[text()='Last Name must be between 1 and 32 characters!']")
	WebElement LastNameError;
	
	@FindBy(xpath = "//DIV[text()='E-Mail Address does not appear to be valid!']")
	WebElement EmailError;
	
	@FindBy(xpath = "//DIV[text()='Telephone must be between 3 and 32 characters!']")
	WebElement TelephoneError;
	
	@FindBy(xpath = "//DIV[text()='Password must be between 4 and 20 characters!']")
	WebElement PasswordError;
	
	@FindBy(xpath = "//DIV[text()='Password confirmation does not match password!']")
	WebElement RePasswordError;
	
	@FindBy(linkText = "My Account")
	WebElement MyAccountBtn;
	
	@FindBy(linkText = "Logout")
	WebElement LogoutBtn;
	
	
	public void provideFirstName(String fname) {
		FirstName.sendKeys(fname);
		
	}
	
	public void provideLastName(String lname) {
		LastName.sendKeys(lname);
		
	}
	
	public void provideEmail(String email) {
		Email.sendKeys(email);
		
	}
	
	public void provideTelephone(String telephone) {
		Telephone.sendKeys(telephone);
		
	}
	
	public void providePassword(String password) {
		Password.sendKeys(password);
		
	}
	
	public void provideConfirmPassword(String confirmpassword) {
		ConfirmPassword.sendKeys(confirmpassword);
		
	}
	
	public void selectAgree() {
		Agree.click();
		
	}
	
	public void selectYesBtn() {
		YesBtn.click();
		
	}
	
	public void selectRegBtn() {
		RegBtn.click();
		
	}
	
	public String verifyFailedRegistraion() {
		return RegError.getText();
		
	}
	
	public String verifyFailedFirstName() {
		return FirstNameError.getText();
		
	}
	
	public String verifyFailedLastName() {
		return LastNameError.getText();
		
	}
	
	public String verifyFailedEmail() {
		return EmailError.getText();
		
	}
	
	public String verifyFailedTelephone() {
		return TelephoneError.getText();
		
	}
	
	public String verifyFailedPassword() {
		return PasswordError.getText();
		
	}
	
	public String verifyFailedRePassword() {
		return RePasswordError.getText();
		
	}
	
	public void Logout() {
		MyAccountBtn.click();
		LogoutBtn.click();
		
	}

}
