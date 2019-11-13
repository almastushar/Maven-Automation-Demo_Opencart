package pagefactory.com.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.com.demo.opencart.HomePage;
import pages.com.demo.opencart.LoginPage;
import utils.TestData;

public class PagefactoryTests_OrderHistory_Transaction_Download {
	
	WebDriver driver = new ChromeDriver(); 
	static TestData testdata;
	
	HomePage homePage = new HomePage(driver);
	LoginPage loginPage = new LoginPage(driver);
	
	@BeforeTest
	public void BeforeTest() throws IOException {
		testdata = new TestData();
		driver.get(testdata.property.getProperty("baseUrl"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
	}
	
	@Test
	public void Verify_Order_History_Page() throws IOException {
		testdata = new TestData();
		homePage.Login();
		loginPage.Provide_Email(testdata.property.getProperty("validUserEmail"));
		loginPage.Provide_Password(testdata.property.getProperty("validPassword"));
		loginPage.Click_SubmitBtn();
		assertEquals(driver.getTitle(), "My Account");
		homePage.Order_History();
		assertEquals(driver.getTitle(), "Order History");
		loginPage.Logout();
		
	}
	
	@Test
	public void Verify_Transaction_Page() throws IOException {
		testdata = new TestData();
		homePage.Login();
		loginPage.Provide_Email(testdata.property.getProperty("validUserEmail"));
		loginPage.Provide_Password(testdata.property.getProperty("validPassword"));
		loginPage.Click_SubmitBtn();
		assertEquals(driver.getTitle(), "My Account");
		homePage.Transactions();
		assertEquals(driver.getTitle(), "Your Transactions");
		loginPage.Logout();
		
	}
	
	@Test
	public void Verify_Download_Page() throws IOException {
		testdata = new TestData();
		homePage.Login();
		loginPage.Provide_Email(testdata.property.getProperty("validUserEmail"));
		loginPage.Provide_Password(testdata.property.getProperty("validPassword"));
		loginPage.Click_SubmitBtn();
		assertEquals(driver.getTitle(), "My Account");
		homePage.Downloads();
		assertEquals(driver.getTitle(), "Account Downloads");
		loginPage.Logout();
		
	}
	
	@AfterClass
	public void AfterTest() {
		driver.close();
	}

}
