package testingweek;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitExample {
	
	private WebDriver webDriver;
	private static final String BASE_URL="https://www.qa.com";
	
	@BeforeClass
	public static void init(){
		//System.out.println("BEFORE CLASS method");
	}
	
	@Before
	public void setup() {
	//	System.out.println("BEFORE method");
		webDriver= new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
		
	}
	
	
	@Test
	public void printTest() {
		try {
			TimeUnit.MILLISECONDS.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	System.out.println("TEST method");
		
		WebElement searchbar= webDriver.findElement(By.cssSelector("#select2-chosen-2"));
		searchbar.click();
		WebElement searchbar1= webDriver.findElement(By.cssSelector("#s2id_autogen2_search"));
		searchbar1.sendKeys("The Shafeeq");
		
	}

	@After
	public void cleanUp() {
	//	System.out.println("AFTER method");
	webDriver.quit();
		
	}
	
	@AfterClass
	public static void tearDown() {
	//	System.out.println("AFTER CLASS method");
	}


}
