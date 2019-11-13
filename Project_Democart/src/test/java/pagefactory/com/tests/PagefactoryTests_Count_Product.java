package pagefactory.com.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.com.demo.opencart.CartPage;
import pages.com.demo.opencart.HomePage;
import pages.com.demo.opencart.LoginPage;
import utils.TestData;

public class PagefactoryTests_Count_Product {
	
	WebDriver driver = new ChromeDriver(); 
	static TestData testdata;
	
	HomePage homePage = new HomePage(driver);
	LoginPage loginPage = new LoginPage(driver);
	CartPage cartPage = new CartPage(driver);
	
	String quantity = RandomStringUtils.randomNumeric(1, 2);
	
	
	@BeforeTest
	public void BeforeTest() throws IOException {
		testdata = new TestData();
		driver.get(testdata.property.getProperty("baseUrl"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
	}
	

	@Test(priority = 1)
	public void Verify_CountProduct_After_login() throws IOException {
		testdata = new TestData();
		
		homePage.Login();
		loginPage.Provide_Email(testdata.property.getProperty("validUserEmail"));
		loginPage.Provide_Password(testdata.property.getProperty("validPassword"));
		loginPage.Click_SubmitBtn();
		loginPage.Click_HomeBtn();
		homePage.AddToCart();
		homePage.CartList();
		cartPage.Verify_Cartlist();
		cartPage.CountInput_Cartlist(quantity);
		cartPage.CountUpdateBtn_Cartlist();
		assertEquals(cartPage.CountUpdateMsg(), "Success: You have modified your shopping cart!\n" + 
				"×");
		assertEquals(cartPage.Verify_Count(), quantity);
		cartPage.Delete_Cartlist();
		
		loginPage.Logout();
		
	}
	
	@Test(priority = 2)
	public void Verify_CountProduct_Before_login_and_Check_Existing_Of_CountProduct_After_Login() throws IOException {
		testdata = new TestData();
		
		loginPage.Click_HomeBtn();
		homePage.AddToCart();
		homePage.CartList();
		cartPage.Verify_Cartlist();
		cartPage.CountInput_Cartlist(quantity);
		cartPage.CountUpdateBtn_Cartlist();
		assertEquals(cartPage.CountUpdateMsg(), "Success: You have modified your shopping cart!\n" + 
				"×");
		homePage.Login();
		loginPage.Provide_Email(testdata.property.getProperty("validUserEmail"));
		loginPage.Provide_Password(testdata.property.getProperty("validPassword"));
		loginPage.Click_SubmitBtn();
		homePage.CartList();
		cartPage.Verify_Cartlist();
		assertEquals(cartPage.Verify_Count(), quantity);
		cartPage.Delete_Cartlist();
		
		loginPage.Logout();
		
	}
	
	@AfterClass
	public void AfterTest() {
		driver.close();
	}
	
	

}
