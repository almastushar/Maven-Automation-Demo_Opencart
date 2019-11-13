package pages.com.demo.opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {
   WebDriver driver;
	
	public WishlistPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//DIV[@class='table-responsive']")
	WebElement WishListTable;
	
	@FindBy(xpath = "//A[@href='https://demo.opencart.com/index.php?route=account/wishlist&remove=40']")
	WebElement WishListDelete;
	
	@FindBy(css = "#content > div.table-responsive > table > tbody > tr > td:nth-child(6) > button")
	WebElement AddToCartFromWishListBtn;
	
	public void Verify_Wishlist() {
		WishListTable.isDisplayed();
	}
	
	public void Delete_Wishlist() {
		WishListDelete.click();
	}
	
	public void AddToCartFromWishList() {
		AddToCartFromWishListBtn.click();
	}
	

}
