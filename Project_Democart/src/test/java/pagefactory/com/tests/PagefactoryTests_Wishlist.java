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
import pages.com.demo.opencart.WishlistPage;
import utils.TestData;

public class PagefactoryTests_Wishlist {
	
	WebDriver driver = new ChromeDriver(); 
	static TestData testdata;
	
	HomePage homePage = new HomePage(driver);
	LoginPage loginPage = new LoginPage(driver);
	WishlistPage wishPage = new WishlistPage(driver);
	
	
	@BeforeTest
	public void BeforeTest() throws IOException {
		testdata = new TestData();
		driver.get(testdata.property.getProperty("baseUrl"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
	}
	
	@Test(priority = 1)
	public void Verify_AddToWishlist_Before_login() throws IOException {
		testdata = new TestData();
		
		homePage.AddToWishList();
		homePage.WishList();
		loginPage.Provide_Email(testdata.property.getProperty("validUserEmail"));
		loginPage.Provide_Password(testdata.property.getProperty("validPassword"));
		loginPage.Click_SubmitBtn();
		wishPage.Verify_Wishlist();
		wishPage.Delete_Wishlist();
		loginPage.Logout();
		
	}
	
	@Test(priority = 2)
	public void Verify_AddToWishlist_After_login() throws IOException {
		testdata = new TestData();
		
		homePage.Login();
		loginPage.Provide_Email(testdata.property.getProperty("validUserEmail"));
		loginPage.Provide_Password(testdata.property.getProperty("validPassword"));
		loginPage.Click_SubmitBtn();
		loginPage.Click_HomeBtn();
		homePage.AddToWishList();
		homePage.WishList();
		wishPage.Verify_Wishlist();
		wishPage.Delete_Wishlist();
		loginPage.Logout();
		
	}
	
	@AfterClass
	public void AfterTest() {
		driver.close();
	}
	

}
