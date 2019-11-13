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

public class PagefactoryTests_AddCart_From_Wishlist {
	
	WebDriver driver = new ChromeDriver(); 
	static TestData testdata;
	
	HomePage homePage = new HomePage(driver);
	LoginPage loginPage = new LoginPage(driver);
	WishlistPage wishPage = new WishlistPage(driver);
	CartPage cartPage = new CartPage(driver);
	
	
	@BeforeTest
	public void BeforeTest() throws IOException {
		testdata = new TestData();
		driver.get(testdata.property.getProperty("baseUrl"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
	}
	
	@Test(priority = 1)
	public void Verify_AddToCartFromWishlist_Before_login() throws IOException {
		testdata = new TestData();
		
		homePage.AddToWishList();
		homePage.WishList();
		loginPage.Provide_Email(testdata.property.getProperty("validUserEmail"));
		loginPage.Provide_Password(testdata.property.getProperty("validPassword"));
		loginPage.Click_SubmitBtn();
		wishPage.Verify_Wishlist();
		wishPage.AddToCartFromWishList();
		homePage.CartList();
		cartPage.Verify_Cartlist();
		cartPage.Delete_Cartlist();
		loginPage.Logout();
		
	}
	
	@Test(priority = 2)
	public void Verify_AddToCartFromWishlist_After_login() throws IOException {
		testdata = new TestData();
		
		homePage.Login();
		loginPage.Provide_Email(testdata.property.getProperty("validUserEmail"));
		loginPage.Provide_Password(testdata.property.getProperty("validPassword"));
		loginPage.Click_SubmitBtn();
		loginPage.Click_HomeBtn();
		homePage.AddToWishList();
		homePage.WishList();
		wishPage.Verify_Wishlist();
		wishPage.AddToCartFromWishList();
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
