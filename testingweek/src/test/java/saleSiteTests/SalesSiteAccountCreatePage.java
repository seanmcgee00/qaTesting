package saleSiteTests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SalesSiteAccountCreatePage {
	
	

	@FindBy(css= "#id_gender1")
	private WebElement titleButtonM;
	@FindBy(css= "#id_gender2")
	private WebElement titleButtonF;
	
	@FindBy(css= "#customer_firstname")
	private WebElement firstname;
	
	@FindBy(css= "#customer_lastname")
	private WebElement lastname;
	
	@FindBy(css= "#passwd")
	private WebElement password;
	
	@FindBy(css= "#days")
	private WebElement dayOfBirth;
	@FindBy(css= "#months")
	private WebElement monthOfBirth;
	@FindBy(css= "#years")
	private WebElement yearOfBirth;
	
	@FindBy(css= "#address1")
	private WebElement address;
	
	@FindBy(css= "#city")
	private WebElement city;
	
	@FindBy(css= "#id_state")
	private WebElement state;
	
	@FindBy(css= "#postcode")
	private WebElement postcode;
	
	@FindBy(css= "#phone_mobile")
	private WebElement mobilePhone;
	
	@FindBy(css= "#submitAccount")
	private WebElement registerButton;
	
	
	
	
	public void selectTitle(String gender ) {
		if(gender.equalsIgnoreCase("M"))
		{titleButtonM.click();}
		else if(gender.equalsIgnoreCase("F"))
		{titleButtonF.click();}
		else
		{titleButtonM.click();}
		
		
	}
	
	public void setFirstname(String name) {
		firstname.sendKeys(name);
	}
	
	public void setLastname(String name) {
		lastname.sendKeys(name);
	}
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	
	
	public void setDayOfBirth(String day) {
		Select dropdown = new Select(dayOfBirth);
		dropdown.selectByValue(day);
		
	}
	public void setMonthOfBirth(String month) {
		Select dropdown = new Select(monthOfBirth);
		dropdown.selectByValue(month);
		
		
	}
	
	public void setYearOfBirth(String year) {
		Select dropdown = new Select(yearOfBirth);
		dropdown.selectByValue(year);
		
	}
	
	
	public void setAddress(String address) {
		this.address.sendKeys(address);
	}
	
	
	public void setCity(String city) {
		this.city.sendKeys(city);
	}
	
	public void setState(String state) {
		Select dropdown = new Select(this.state);
		dropdown.selectByVisibleText(state);
		
	}
	
	public void setPostcode(String postcode) {
		this.postcode.sendKeys(postcode);
	}
	
	public void setMobilePhone(String mobileNo) {
		this.mobilePhone.sendKeys(mobileNo);
	}
	
	public void clickRegButton() {
		registerButton.click();
	}

}
