package pagefactory.com.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.com.demo.opencart.HomePage;
import pages.com.demo.opencart.LoginPage;
import pages.com.demo.opencart.RegistrationPage;
import utils.TestData;

public class PagefactoryTests_Login {
	
	WebDriver driver = new ChromeDriver(); 
	static TestData testdata;
	
	HomePage homePage = new HomePage(driver);
	LoginPage loginPage = new LoginPage(driver);
	
	String invalid_email = RandomStringUtils.randomAlphabetic(8);
	String Blank_email = "";
	String invalid_pass = RandomStringUtils.randomAlphabetic(8);
	String Blank_pass = "";
	
	@BeforeTest
	public void BeforeTest() throws IOException {
		testdata = new TestData();
		driver.get(testdata.property.getProperty("baseUrl"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
	}
	
	@Test
	public void login_positive_all_valid_value() throws IOException {
		testdata = new TestData();
		homePage.Login();
		loginPage.Provide_Email(testdata.property.getProperty("validUserEmail"));
		loginPage.Provide_Password(testdata.property.getProperty("validPassword"));
		loginPage.Click_SubmitBtn();
		assertEquals(driver.getTitle(), "My Account");
		loginPage.Logout();
		
	}
	
	@Test
	public void login_negative_all_invalid_value() {
		homePage.Login();
		loginPage.Provide_Email(invalid_email);
		loginPage.Provide_Password(invalid_pass);
		loginPage.Click_SubmitBtn();
		assertEquals(loginPage.Verify_Failed_Login(), "Warning: No match for E-Mail Address and/or Password.");
	}
	
	@Test
	public void login_negative_blank_value() {
		homePage.Login();
		loginPage.Provide_Email(Blank_email);
		loginPage.Provide_Password(Blank_pass);
		loginPage.Click_SubmitBtn();
		assertEquals(loginPage.Verify_Failed_Login(), "Warning: No match for E-Mail Address and/or Password.");
	}
	
	@AfterClass
	public void AfterTest() {
		driver.close();
	}

}
