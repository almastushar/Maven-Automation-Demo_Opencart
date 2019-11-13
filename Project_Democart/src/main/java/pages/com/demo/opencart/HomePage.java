package pages.com.demo.opencart;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
		
		public HomePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
		
		@FindBy(linkText = "My Account")
		WebElement MyAccountButton;
		
		@FindBy(linkText = "Register" )
		WebElement RegisterButton;
		
		@FindBy(linkText = "Login")
		WebElement LoginButton;
		
		@FindBy(linkText = "Order History")
		WebElement OrderHistoryButton;
		
		@FindBy(linkText = "Transactions" )
		WebElement TransactionsButton;
		
		@FindBy(linkText = "Downloads")
		WebElement DownloadsButton;
		
		@FindBy(xpath = "//INPUT[@type='text']")
		WebElement SearchInput;
		
		@FindBy(css = "#search > span > button")
		WebElement SearchButton;
		
		@FindBy(xpath = "//DIV[@class='caption']")
		List<WebElement> SearchResult;
		
		@FindBy(xpath = "(//I[@class='fa fa-heart'])[3]")
		WebElement AddToWishListButton;
		
		@FindBy(xpath = "(//I[@class='fa fa-heart'])[1]")
		WebElement WishListButton;
		
		@FindBy(css = "#content > div.row > div:nth-child(1) > div > div.button-group > button:nth-child(1) > i")
		WebElement AddToCartButton;
		
		@FindBy(linkText = "Shopping Cart")
		WebElement CartListButton;
		
		public void Registration() {
			MyAccountButton.click();
			RegisterButton.click();
		}
		
		public void Login() {
			MyAccountButton.click();
			LoginButton.click();
		}
		
		public void Order_History() {
			MyAccountButton.click();
			OrderHistoryButton.click();
		}
		
		public void Transactions() {
			MyAccountButton.click();
			TransactionsButton.click();
		}
		
		public void Downloads() {
			MyAccountButton.click();
			DownloadsButton.click();
		}
		
		public void SearchProduct(String search) {
			SearchInput.sendKeys(search);
		}
		
		public void SearchSubmitButton() {
			SearchButton.click();
			
		}
		
		public List<String> Verify_Search_Result() {
			List<String> string = new ArrayList<String>();
			for (int i = 0; i < SearchResult.size(); i++) {
				string.add(SearchResult.get(i).getText());	
			}
			return string;	
		}
		
		public void AddToWishList() {
			AddToWishListButton.click();
			
		}
		
		public void WishList() {
			WishListButton.click();
			
		}
		
		public void AddToCart() {
			AddToCartButton.click();
			
		}
		
		public void CartList() {
			CartListButton.click();
			
		}
		

}
