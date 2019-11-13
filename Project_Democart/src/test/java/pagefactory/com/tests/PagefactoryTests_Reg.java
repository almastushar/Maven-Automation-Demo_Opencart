package pagefactory.com.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.com.demo.opencart.HomePage;
import pages.com.demo.opencart.RegistrationPage;
import utils.TestData;

public class PagefactoryTests_Reg {
    WebDriver driver = new ChromeDriver();
    static TestData testdata;
	
	HomePage homepage = new HomePage(driver);
	RegistrationPage regPage = new RegistrationPage(driver);
	
	
	
	String valid_fname = RandomStringUtils.randomAlphabetic(12);
	String invalid_fname = RandomStringUtils.randomAlphabetic(33, 35);
	String valid_lname = RandomStringUtils.randomAlphabetic(12);
	String invalid_lname = RandomStringUtils.randomAlphabetic(33, 35);
	String valid_email = RandomStringUtils.randomAlphabetic(12)+ "@email.com";
	String valid_email_2 = RandomStringUtils.randomAlphabetic(12)+ "@email.com";
	String invalid_email = "almas@almas.com";//testdata.property.getProperty("validUserEmail")
	String valid_phone = "011" + RandomStringUtils.randomNumeric(9);
	String invalid_phone = RandomStringUtils.randomNumeric(2);
	String valid_password = RandomStringUtils.randomAlphanumeric(5);
	String invalid_password = RandomStringUtils.randomNumeric(3);
	String invalid_repassword = RandomStringUtils.randomAlphanumeric(5);

	
	String blank_fname = "";
	String blank_lname = "";
	String blank_email = "";
	String blank_phone = "";
	String blank_password = "";
	String blank_confirmpass = "";
	
	@BeforeTest
	public void BeforeTest2() throws IOException {
		testdata = new TestData();
		driver.get(testdata.property.getProperty("baseUrl"));
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().fullscreen();
		 
	}
	
	@Test
	public void Registration_Positive_all_valid_value() {
		homepage.Registration();
		regPage.provideFirstName(valid_fname);
		regPage.provideLastName(valid_lname);
		regPage.provideEmail(valid_email);
		regPage.provideTelephone(valid_phone);
		regPage.providePassword(valid_password);
		regPage.provideConfirmPassword(valid_password);
		regPage.selectAgree();
		regPage.selectRegBtn();
	    assertEquals(driver.getTitle(), "Your Account Has Been Created!");
	    regPage.Logout();
	    
	}
	
	@Test
	public void Registration_Negative_Invalid_FirstName() {
		homepage.Registration();
		regPage.provideFirstName(invalid_fname);
		regPage.provideLastName(valid_lname);
		regPage.provideEmail(valid_email);
		regPage.provideTelephone(valid_phone);
		regPage.providePassword(valid_password);
		regPage.provideConfirmPassword(valid_password);
		regPage.selectAgree();
		regPage.selectRegBtn();
		assertEquals(regPage.verifyFailedFirstName(), "First Name must be between 1 and 32 characters!");
	}
	
	@Test
	public void Registration_Negative_Invalid_LastName() {
		homepage.Registration();
		regPage.provideFirstName(valid_fname);
		regPage.provideLastName(invalid_lname);
		regPage.provideEmail(valid_email);
		regPage.provideTelephone(valid_phone);
		regPage.providePassword(valid_password);
		regPage.provideConfirmPassword(valid_password);
		regPage.selectAgree();
		regPage.selectRegBtn();
		assertEquals(regPage.verifyFailedLastName(), "Last Name must be between 1 and 32 characters!");
	}
	
	@Test
	public void Registration_Negative_Invalid_Email() {
		homepage.Registration();
		regPage.provideFirstName(valid_fname);
		regPage.provideLastName(valid_lname);
		regPage.provideEmail(invalid_email);
		regPage.provideTelephone(valid_phone);
		regPage.providePassword(valid_password);
		regPage.provideConfirmPassword(valid_password);
		regPage.selectAgree();
		regPage.selectRegBtn();
		//assertEquals(regPage.verifyFailedEmail(), "E-Mail Address does not appear to be valid!");
	}
	
	@Test
	public void Registration_Negative_Invalid_Telephone() {
		homepage.Registration();
		regPage.provideFirstName(valid_fname);
		regPage.provideLastName(valid_lname);
		regPage.provideEmail(valid_email);
		regPage.provideTelephone(invalid_phone);
		regPage.providePassword(valid_password);
		regPage.provideConfirmPassword(valid_password);
		regPage.selectAgree();
		regPage.selectRegBtn();
		assertEquals(regPage.verifyFailedTelephone(), "Telephone must be between 3 and 32 characters!");
	}
	
	@Test
	public void Registration_Negative_Invalid_Password() {
		homepage.Registration();
		regPage.provideFirstName(valid_fname);
		regPage.provideLastName(valid_lname);
		regPage.provideEmail(valid_email);
		regPage.provideTelephone(valid_phone);
		regPage.providePassword(invalid_password);
		regPage.provideConfirmPassword(valid_password);
		regPage.selectAgree();
		regPage.selectRegBtn();
		assertEquals(regPage.verifyFailedPassword(), "Password must be between 4 and 20 characters!");
	}
	
	@Test
	public void Registration_Negative_Invalid_RePassword() {
		homepage.Registration();
		regPage.provideFirstName(valid_fname);
		regPage.provideLastName(valid_lname);
		regPage.provideEmail(valid_email);
		regPage.provideTelephone(valid_phone);
		regPage.providePassword(valid_password);
		regPage.provideConfirmPassword(invalid_password);
		regPage.selectAgree();
		regPage.selectRegBtn();
		assertEquals(regPage.verifyFailedRePassword(), "Password confirmation does not match password!");
	}
	
	@Test
	public void Registration_Negative_valid_FirstName() {
		homepage.Registration();
		regPage.provideFirstName(valid_fname);
		regPage.provideLastName(invalid_lname);
		regPage.provideEmail(invalid_email);
		regPage.provideTelephone(invalid_phone);
		regPage.providePassword(invalid_password);
		regPage.provideConfirmPassword(invalid_repassword);
		regPage.selectAgree();
		regPage.selectRegBtn();
		assertEquals(regPage.verifyFailedRegistraion(), "Warning: E-Mail Address is already registered!");
		assertEquals(regPage.verifyFailedLastName(), "Last Name must be between 1 and 32 characters!");
		assertEquals(regPage.verifyFailedTelephone(), "Telephone must be between 3 and 32 characters!");
		assertEquals(regPage.verifyFailedPassword(), "Password must be between 4 and 20 characters!");
		assertEquals(regPage.verifyFailedRePassword(), "Password confirmation does not match password!");
		
	}
	
	@Test
	public void Registration_Negative_valid_LastName() {
		homepage.Registration();
		regPage.provideFirstName(invalid_fname);
		regPage.provideLastName(valid_lname);
		regPage.provideEmail(invalid_email);
		regPage.provideTelephone(invalid_phone);
		regPage.providePassword(invalid_password);
		regPage.provideConfirmPassword(invalid_repassword);
		regPage.selectAgree();
		regPage.selectRegBtn();
		assertEquals(regPage.verifyFailedRegistraion(), "Warning: E-Mail Address is already registered!");
		assertEquals(regPage.verifyFailedFirstName(), "First Name must be between 1 and 32 characters!");
		assertEquals(regPage.verifyFailedTelephone(), "Telephone must be between 3 and 32 characters!");
		assertEquals(regPage.verifyFailedPassword(), "Password must be between 4 and 20 characters!");
		assertEquals(regPage.verifyFailedRePassword(), "Password confirmation does not match password!");
	}
	
	@Test
	public void Registration_Negative_valid_Email() {
		homepage.Registration();
		regPage.provideFirstName(invalid_fname);
		regPage.provideLastName(invalid_lname);
		regPage.provideEmail(valid_email);
		regPage.provideTelephone(invalid_phone);
		regPage.providePassword(invalid_password);
		regPage.provideConfirmPassword(invalid_repassword);
		regPage.selectAgree();
		regPage.selectRegBtn();
		assertEquals(regPage.verifyFailedFirstName(), "First Name must be between 1 and 32 characters!");
		assertEquals(regPage.verifyFailedLastName(), "Last Name must be between 1 and 32 characters!");
		assertEquals(regPage.verifyFailedTelephone(), "Telephone must be between 3 and 32 characters!");
		assertEquals(regPage.verifyFailedPassword(), "Password must be between 4 and 20 characters!");
		assertEquals(regPage.verifyFailedRePassword(), "Password confirmation does not match password!");
	}
	
	@Test
	public void Registration_Negative_valid_Telephone() {
		homepage.Registration();
		regPage.provideFirstName(invalid_fname);
		regPage.provideLastName(invalid_lname);
		regPage.provideEmail(invalid_email);
		regPage.provideTelephone(valid_phone);
		regPage.providePassword(invalid_password);
		regPage.provideConfirmPassword(invalid_repassword);
		regPage.selectAgree();
		regPage.selectRegBtn();
		assertEquals(regPage.verifyFailedRegistraion(), "Warning: E-Mail Address is already registered!");
		assertEquals(regPage.verifyFailedFirstName(), "First Name must be between 1 and 32 characters!");
		assertEquals(regPage.verifyFailedLastName(), "Last Name must be between 1 and 32 characters!");
		assertEquals(regPage.verifyFailedPassword(), "Password must be between 4 and 20 characters!");
		assertEquals(regPage.verifyFailedRePassword(), "Password confirmation does not match password!");
	}
	
	@Test
	public void Registration_Negative_valid_Password() {
		homepage.Registration();
		regPage.provideFirstName(invalid_fname);
		regPage.provideLastName(invalid_lname);
		regPage.provideEmail(invalid_email);
		regPage.provideTelephone(invalid_phone);
		regPage.providePassword(valid_password);
		regPage.provideConfirmPassword(invalid_repassword);
		regPage.selectAgree();
		regPage.selectRegBtn();
		assertEquals(regPage.verifyFailedRegistraion(), "Warning: E-Mail Address is already registered!");
		assertEquals(regPage.verifyFailedFirstName(), "First Name must be between 1 and 32 characters!");
		assertEquals(regPage.verifyFailedLastName(), "Last Name must be between 1 and 32 characters!");
		assertEquals(regPage.verifyFailedTelephone(), "Telephone must be between 3 and 32 characters!");
		assertEquals(regPage.verifyFailedRePassword(), "Password confirmation does not match password!");
	}
	
	@Test
	public void Registration_Negative_valid_RePassword() {
		homepage.Registration();
		regPage.provideFirstName(invalid_fname);
		regPage.provideLastName(invalid_lname);
		regPage.provideEmail(invalid_email);
		regPage.provideTelephone(invalid_phone);
		regPage.providePassword(invalid_password);
		regPage.provideConfirmPassword(valid_password);
		regPage.selectAgree();
		regPage.selectRegBtn();
		assertEquals(regPage.verifyFailedRegistraion(), "Warning: E-Mail Address is already registered!");
		assertEquals(regPage.verifyFailedFirstName(), "First Name must be between 1 and 32 characters!");
		assertEquals(regPage.verifyFailedLastName(), "Last Name must be between 1 and 32 characters!");
		assertEquals(regPage.verifyFailedTelephone(), "Telephone must be between 3 and 32 characters!");
		assertEquals(regPage.verifyFailedPassword(), "Password must be between 4 and 20 characters!");
		assertEquals(regPage.verifyFailedRePassword(), "Password confirmation does not match password!");
	}
	
	@Test
	public void Registration_Negative_Invalid_all_value() {
		homepage.Registration();
		regPage.provideFirstName(invalid_fname);
		regPage.provideLastName(invalid_lname);
		regPage.provideEmail(invalid_email);
		regPage.provideTelephone(invalid_phone);
		regPage.providePassword(invalid_password);
		regPage.provideConfirmPassword(invalid_repassword);
		regPage.selectAgree();
		regPage.selectRegBtn();
		assertEquals(regPage.verifyFailedRegistraion(), "Warning: E-Mail Address is already registered!");
		assertEquals(regPage.verifyFailedFirstName(), "First Name must be between 1 and 32 characters!");
		assertEquals(regPage.verifyFailedLastName(), "Last Name must be between 1 and 32 characters!");
		assertEquals(regPage.verifyFailedTelephone(), "Telephone must be between 3 and 32 characters!");
		assertEquals(regPage.verifyFailedPassword(), "Password must be between 4 and 20 characters!");
		assertEquals(regPage.verifyFailedRePassword(), "Password confirmation does not match password!");
	}
	
	@Test
	public void Registration_Negative_Blank_all_value() {
		homepage.Registration();
		regPage.provideFirstName(blank_fname);
		regPage.provideLastName(blank_lname);
		regPage.provideEmail(blank_email);
		regPage.provideTelephone(blank_phone);
		regPage.providePassword(blank_password);
		regPage.provideConfirmPassword(blank_password);
		regPage.selectAgree();
		regPage.selectRegBtn();
		assertEquals(regPage.verifyFailedEmail(), "E-Mail Address does not appear to be valid!");
		assertEquals(regPage.verifyFailedFirstName(), "First Name must be between 1 and 32 characters!");
		assertEquals(regPage.verifyFailedLastName(), "Last Name must be between 1 and 32 characters!");
		assertEquals(regPage.verifyFailedTelephone(), "Telephone must be between 3 and 32 characters!");
		assertEquals(regPage.verifyFailedPassword(), "Password must be between 4 and 20 characters!");
	}
	
	@Test
	public void Registration_Negative_Different_Password_Repassword() {
		homepage.Registration();
		regPage.provideFirstName(valid_fname);
		regPage.provideLastName(valid_lname);
		regPage.provideEmail(valid_email);
		regPage.provideTelephone(valid_phone);
		regPage.providePassword(valid_password);
		regPage.provideConfirmPassword(invalid_password);
		regPage.selectAgree();
		regPage.selectRegBtn();
		assertEquals(regPage.verifyFailedRePassword(), "Password confirmation does not match password!");
	}
	
	@Test
	public void Registration_Negative_Without_Click_Agree() {
		homepage.Registration();
		regPage.provideFirstName(valid_fname);
		regPage.provideLastName(valid_lname);
		regPage.provideEmail(valid_email);
		regPage.provideTelephone(valid_phone);
		regPage.providePassword(valid_password);
		regPage.provideConfirmPassword(valid_password);
		regPage.selectRegBtn();
		assertEquals(regPage.verifyFailedRegistraion(), "Warning: You must agree to the Privacy Policy!");
	}
	
	@Test
	public void Registration_Positive_Click_Yes_Button_with_Valid_Value() {
		homepage.Registration();
		regPage.provideFirstName(valid_fname);
		regPage.provideLastName(valid_lname);
		regPage.provideEmail(valid_email_2);
		regPage.provideTelephone(valid_phone);
		regPage.providePassword(valid_password);
		regPage.provideConfirmPassword(valid_password);
		regPage.selectYesBtn();
		regPage.selectAgree();
		regPage.selectRegBtn();
		assertEquals(driver.getTitle(), "Your Account Has Been Created!");
	    regPage.Logout();
	}
	
	@Test
	public void Registration_Negative_Click_Yes_Button_with_Invalid_Value() {
		homepage.Registration();
		regPage.provideFirstName(invalid_fname);
		regPage.provideLastName(invalid_lname);
		regPage.provideEmail(invalid_email);
		regPage.provideTelephone(invalid_phone);
		regPage.providePassword(invalid_password);
		regPage.provideConfirmPassword(invalid_repassword);
		regPage.selectYesBtn();
		regPage.selectAgree();
		regPage.selectRegBtn();
		assertEquals(regPage.verifyFailedRegistraion(), "Warning: E-Mail Address is already registered!");
		assertEquals(regPage.verifyFailedFirstName(), "First Name must be between 1 and 32 characters!");
		assertEquals(regPage.verifyFailedLastName(), "Last Name must be between 1 and 32 characters!");
		assertEquals(regPage.verifyFailedTelephone(), "Telephone must be between 3 and 32 characters!");
		assertEquals(regPage.verifyFailedPassword(), "Password must be between 4 and 20 characters!");
		assertEquals(regPage.verifyFailedRePassword(), "Password confirmation does not match password!");
	}
	
	@AfterClass
	public void AfterTest() {
		driver.close();
	}


}
