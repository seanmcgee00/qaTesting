package saleSiteTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalesSiteHomePage {
	
	
	@FindBy(css= "#header > div.nav > div > div > nav > div.header_user_info > a")
	private WebElement signInButton;
	
	public void clickAddUserPage() {
		signInButton.click();
		
	}

}
