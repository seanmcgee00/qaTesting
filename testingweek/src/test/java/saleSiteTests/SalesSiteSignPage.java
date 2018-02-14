package saleSiteTests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SalesSiteSignPage {
	
	
	@FindBy(css= "#email_create")
	private WebElement regEmail;
	
	@FindBy(css= "#SubmitCreate")
	private WebElement createButton;
	
	public void insertRegEmail(String email) {
		regEmail.sendKeys(email);
		
	}
	
	public void selectCreate() {
		createButton.click();
		
	}

}
