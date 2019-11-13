package pagefactory.com.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.com.demo.opencart.HomePage;
import pages.com.demo.opencart.LoginPage;
import pages.com.demo.opencart.RegistrationPage;
import utils.TestData;

public class PagefactoryTests_Search {
	
	WebDriver driver = new ChromeDriver(); 
	static TestData testdata;
	
	HomePage homePage = new HomePage(driver);
	LoginPage loginPage = new LoginPage(driver);
	
	String invalid_search = RandomStringUtils.randomAlphabetic(8);
	String blank_search = "";
	
	@BeforeTest
	public void BeforeTest() throws IOException {
		testdata = new TestData();
		driver.get(testdata.property.getProperty("baseUrl"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
	}
	
	@Test
	public void search_valid_value_without_login() throws IOException {
		testdata = new TestData();
		homePage.SearchProduct(testdata.property.getProperty("validSearch"));
		homePage.SearchSubmitButton();
		
		for (String word : homePage.Verify_Search_Result()) {

			String [] words = word.split("\\s");
			for (int i = 0; i < words.length; i++) {
				if (testdata.property.getProperty("validSearch").equals(words[i])) {
					assertEquals(words[i], testdata.property.getProperty("validSearch"));
				}
				
				
			}
            
        }
		
		
	}
	
	@Test
	public void search_invalid_value_without_login() throws IOException {
		homePage.SearchProduct(invalid_search);
		homePage.SearchSubmitButton();
		
		for (String word : homePage.Verify_Search_Result()) {

			String [] words = word.split("\\s");
			for (int i = 0; i < words.length; i++) {
				if (invalid_search.equals(words[i])) {
					assertEquals(words[i], "");
				}
				
				
			}
            
        }
		
		
	}
	
	@Test
	public void search_blank_value_without_login() throws IOException {
		homePage.SearchProduct(blank_search);
		homePage.SearchSubmitButton();
		
		for (String word : homePage.Verify_Search_Result()) {

			String [] words = word.split("\\s");
			for (int i = 0; i < words.length; i++) {
				if (blank_search.equals(words[i])) {
					assertEquals(words[i], "");
				}
				
				
			}
            
        }
		
		
	}
	
	@Test
	public void search_valid_value_with_login() throws IOException {
		testdata = new TestData();
		homePage.Login();
		loginPage.Provide_Email(testdata.property.getProperty("validUserEmail"));
		loginPage.Provide_Password(testdata.property.getProperty("validPassword"));
		loginPage.Click_SubmitBtn();
		assertEquals(driver.getTitle(), "My Account");
		homePage.SearchProduct(testdata.property.getProperty("validSearch"));
		homePage.SearchSubmitButton();
		
		for (String word : homePage.Verify_Search_Result()) {

			String [] words = word.split("\\s");
			for (int i = 0; i < words.length; i++) {
				if (testdata.property.getProperty("validSearch").equals(words[i])) {
					assertEquals(words[i], testdata.property.getProperty("validSearch"));
				}
				
				
			}
            
        }
		loginPage.Logout();
	}
	
	@Test
	public void search_invalid_value_with_login() throws IOException {
		testdata = new TestData();
		homePage.Login();
		loginPage.Provide_Email(testdata.property.getProperty("validUserEmail"));
		loginPage.Provide_Password(testdata.property.getProperty("validPassword"));
		loginPage.Click_SubmitBtn();
		assertEquals(driver.getTitle(), "My Account");
		homePage.SearchProduct(invalid_search);
		homePage.SearchSubmitButton();
		
		for (String word : homePage.Verify_Search_Result()) {

			String [] words = word.split("\\s");
			for (int i = 0; i < words.length; i++) {
				if (invalid_search.equals(words[i])) {
					assertEquals(words[i], "");
				}
				
				
			}
            
        }
		loginPage.Logout();
	}
	
	@Test
	public void search_blank_value_with_login() throws IOException {
		testdata = new TestData();
		homePage.Login();
		loginPage.Provide_Email(testdata.property.getProperty("validUserEmail"));
		loginPage.Provide_Password(testdata.property.getProperty("validPassword"));
		loginPage.Click_SubmitBtn();
		assertEquals(driver.getTitle(), "My Account");
		homePage.SearchProduct(blank_search);
		homePage.SearchSubmitButton();
		
		for (String word : homePage.Verify_Search_Result()) {

			String [] words = word.split("\\s");
			for (int i = 0; i < words.length; i++) {
				if (blank_search.equals(words[i])) {
					assertEquals(words[i], "");
				}
				
				
			}
            
        }
		loginPage.Logout();
	}
	
	@AfterClass
	public void AfterTest() {
		driver.close();
	}

}
