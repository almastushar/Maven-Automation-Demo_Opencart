package pages.com.demo.opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	 WebDriver driver;
		
		public CartPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
		
		@FindBy(xpath = "(//A[@href='https://demo.opencart.com/index.php?route=account/account'])[1]")
		WebElement MyAccountButton;
		
		@FindBy(xpath = "//A[@href='https://demo.opencart.com/index.php?route=account/login'][text()='Login']")
		WebElement LoginButton;
		
		@FindBy(xpath = "(//TABLE[@class='table table-bordered'])[2]")
		WebElement CartListTable;
		
		@FindBy(xpath = "//I[@class='fa fa-times-circle']")
		WebElement CartListDelete;
		
		@FindBy(xpath = "(//INPUT[@type='text'])[2]")
		WebElement CountInput;
		
		@FindBy(xpath = "//BUTTON[@type='submit']")
		WebElement CountUpdateBtn;
		
		@FindBy(css = "#checkout-cart > div.alert.alert-success.alert-dismissible")
		WebElement CountUpdateMsg;
		
		public void Login() {
			MyAccountButton.click();
			LoginButton.click();
		}
		
		public void Verify_Cartlist() {
			CartListTable.isDisplayed();
		}
		
		public void Delete_Cartlist() {
			CartListDelete.click();
		}
		
		public void CountInput_Cartlist(String quantity) {
			CountInput.clear();
			CountInput.sendKeys(quantity);
		}
		
		public void CountUpdateBtn_Cartlist() {
			CountUpdateBtn.click();
		}
		
		public String Verify_Count() {
			return CountInput.getAttribute("value");
		}
		
		public String CountUpdateMsg() {
			return CountUpdateMsg.getText();
		}

}
