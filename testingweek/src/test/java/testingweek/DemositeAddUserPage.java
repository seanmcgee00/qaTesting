package testingweek;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class DemositeAddUserPage {
	
	
	@FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
	private WebElement enterAddUser;
	
	@FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
	private WebElement enterAddPassword;
	
	@FindBy(css="body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")
	private WebElement navButton;
	
	@FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
	private WebElement saveButton;
	
	
	public void clickPage() {
		navButton.click();
		
	}
	
	public void addUserName(String name)
	{
		enterAddUser.sendKeys(name);
	}
	
	public String getPassword()
	{
		String result = enterAddPassword.getAttribute("value");
		return result;
	}
	
	public String getUserName()
	{
		String result = enterAddUser.getAttribute("value");
		return result;
	}
	
	
	public void addPassword(String pass)
	{
		enterAddPassword.sendKeys(pass);
	}
	
	public void clickSave() {
		saveButton.click();
		
	}
	
}
