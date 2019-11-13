package pagefactory.com.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.com.demo.opencart.CartPage;
import pages.com.demo.opencart.HomePage;
import pages.com.demo.opencart.LoginPage;
import pages.com.demo.opencart.WishlistPage;
import utils.TestData;

public class PagefactoryTests_Cartlist {
	WebDriver driver = new ChromeDriver(); 
	static TestData testdata;
	
	HomePage homePage = new HomePage(driver);
	LoginPage loginPage = new LoginPage(driver);
	CartPage cartPage = new CartPage(driver);
	
	
	@BeforeTest
	public void BeforeTest() throws IOException {
		testdata = new TestData();
		driver.get(testdata.property.getProperty("baseUrl"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
	}
	

	@Test(priority = 2)
	public void Verify_AddToCartlist_After_login() throws IOException {
		testdata = new TestData();
		
		homePage.Login();
		loginPage.Provide_Email(testdata.property.getProperty("validUserEmail"));
		loginPage.Provide_Password(testdata.property.getProperty("validPassword"));
		loginPage.Click_SubmitBtn();
		loginPage.Click_HomeBtn();
		homePage.AddToCart();
		homePage.CartList();
		cartPage.Verify_Cartlist();
		cartPage.Delete_Cartlist();
		loginPage.Logout();
		
	}
	
	
	@Test(priority = 1)
	public void Verify_AddToCartlist_Before_login_and_Check_Existing_Of_Cartlist_After_Login() throws IOException {
		testdata = new TestData();
		
		homePage.AddToCart();
		homePage.CartList();
		cartPage.Verify_Cartlist();
		homePage.Login();
		loginPage.Provide_Email(testdata.property.getProperty("validUserEmail"));
		loginPage.Provide_Password(testdata.property.getProperty("validPassword"));
		loginPage.Click_SubmitBtn();
		homePage.CartList();
		cartPage.Verify_Cartlist();
		cartPage.Delete_Cartlist();
		loginPage.Logout();
		
	}
	
	@AfterClass
	public void AfterTest() {
		driver.close();
	}
	

}
