package testingweek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoSiteLoginPage {
	

	@FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
	private WebElement enterUser;
	
	@FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
	private WebElement enterPassword;
	
	
	
	@FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
	private WebElement loginButton;
	
	@FindBy(css="body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b")
	private WebElement result;
	

	
	public void addLoginUserName(String name)
	{
		enterUser.sendKeys(name);
	}
	
	
	public void addLoginPassword(String pass)
	{
		enterPassword.sendKeys(pass);
	}
	
	public void clickLogin() {
		loginButton.click();
		
	}
	
	public String getResult() {
		
		return result.getText();
		
	}
	
	
	public String getPassword()
	{
		
		return enterPassword.getAttribute("value");
	}
	
	public String getUserName()
	{
		
		return enterUser.getAttribute("value");
	}

}
