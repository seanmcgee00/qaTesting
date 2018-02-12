package testingweek;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class TheDemositeTest {
	
	private WebDriver webDriver;
	private static final String BASE_URL="http://thedemosite.co.uk/";
	
	
	@Before
	public void setup() {
	//	System.out.println("BEFORE method");
		webDriver= new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
		
	}
	
	
	@Test
	public void loginTest() {
	String success="";
	
		
		WebElement selectAddUser= webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)"));
		selectAddUser.click();
		WebElement enterAddUser= webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		enterAddUser.sendKeys("Sean");
		WebElement enterAddPassword= webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		enterAddPassword.sendKeys("mypassword");
		
		WebElement selectSave= webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		selectSave.click();
		
		WebElement seletLogin= webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)"));
		seletLogin.click();
		
		WebElement loginUser= webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		loginUser.sendKeys("Sean");
		WebElement loginPassword= webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		loginPassword.sendKeys("mypassword");
		WebElement  selectTestLogin= webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		
		selectTestLogin.click();
		
		WebElement getSuccess= webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));
		success=getSuccess.getText();
		Assert.assertTrue("Successful test", success.equals("**Successful Login**"));
		
		
	}
	
	@Test
	public void loginTestFail() {
	String success="";
	
		
		WebElement selectAddUser= webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)"));
		selectAddUser.click();
		WebElement enterAddUser= webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		enterAddUser.sendKeys("Sean");
		WebElement enterAddPassword= webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		enterAddPassword.sendKeys("mypassword");
		
		WebElement selectSave= webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		selectSave.click();
		
		WebElement seletLogin= webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)"));
		seletLogin.click();
		
		WebElement loginUser= webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		loginUser.sendKeys("Sean");
		WebElement loginPassword= webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		loginPassword.sendKeys("mypaword3");
		WebElement  selectTestLogin= webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		
		selectTestLogin.click();
		
		WebElement getSuccess= webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));
		success=getSuccess.getText();
		Assert.assertTrue("Unsuccessful test", success.equals("**Successful Login**"));
		
		
	}
	

	@After
	public void cleanUp() {
	//	System.out.println("AFTER method");
	webDriver.quit();
		
	}
	
	
	

}
