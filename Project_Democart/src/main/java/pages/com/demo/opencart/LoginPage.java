package pages.com.demo.opencart;

import java.awt.Color;
import java.util.StringTokenizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "My Account")
	WebElement MyAccountBtn;

	@FindBy(linkText = "Your Store")
	WebElement HomeBtn;

	@FindBy(linkText = "Logout")
	WebElement LogoutBtn;

	@FindBy(id = "input-email")
	WebElement Login_Email;

	@FindBy(id = "input-password")
	WebElement Login_Password;

	@FindBy(xpath = "//INPUT[@type='submit']")
	WebElement Login_SubmitBtn;

	@FindBy(xpath = "//DIV[@class='alert alert-danger alert-dismissible']")
	WebElement error_msg_failed_login;
	
	@FindBy(xpath = "//div[@class=\"form-group\"]//a[text()=\"Forgotten Password\"]")
	WebElement Forget_Pass;

	public String Provide_ColorOfForgetPass() {
		String colorString = Forget_Pass.getCssValue("color");
		System.out.println(colorString);
		String[] numbers = colorString.replace("rgba(", "").replace(")", "").split(",");
		int r = Integer.parseInt(numbers[0].trim());
		int g = Integer.parseInt(numbers[1].trim());
		int b = Integer.parseInt(numbers[2].trim());
		int a = Integer.parseInt(numbers[3].trim());
		String hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b) ;
		//String arrColor = colorString.split("#");
		return hex;
	}
	
	public void Provide_Email(String email) {
		Login_Email.sendKeys(email);
	}

	public void Provide_Password(String password) {
		Login_Password.sendKeys(password);
	}

	public void Click_SubmitBtn() {
		Login_SubmitBtn.click();;
	}

	public String Verify_Failed_Login() {
		return error_msg_failed_login.getText();
	}

	public void Logout() {
		MyAccountBtn.click();
		LogoutBtn.click();

	}

	public void Click_HomeBtn() {
		HomeBtn.click();;
	}


}
