package testingweek;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import com.aventstack.extentreports.ExtentReports; 
import com.aventstack.extentreports.ExtentTest; 
import com.aventstack.extentreports.Status; 
import com.aventstack.extentreports.reporter.ExtentHtmlReporter; 



public class TheDemositeTest {
	
	private WebDriver webDriver;
	private static final String BASE_URL="http://thedemosite.co.uk/";
    private static ExtentReports report;
    private String dataFileName="testingData.xlsx";
    
    
    @BeforeClass 
    public static void init() { 
        report = new ExtentReports(); 
         String fileName = "MyReport" + ".html"; 
       String filePath = System.getProperty("user.dir") 
                + File.separatorChar + fileName; 
        report.attachReporter(new ExtentHtmlReporter(filePath)); 
    } 

	
	
	@Before
	public void setup() {
	//	System.out.println("BEFORE method");
		webDriver= new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
		
	}
	
	
	@Test
	public void loginTest() {
	String success="";
	
	 ExtentTest test = report.createTest("MyFirstTest"); 
	 
	 test.log(Status.INFO, "My First Test is Starting Happy Path "); 
	  SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + File.separatorChar +dataFileName);
	  List<String> row = sheetReader.readRow(1, "DATA_INPUT");
	  
	
	
		DemositeHomePage homePage = PageFactory.initElements(webDriver, DemositeHomePage.class);
		homePage.clickAddUserPage();
		
		DemositeAddUserPage userPage = PageFactory.initElements(webDriver, DemositeAddUserPage.class);
		userPage.addUserName(row.get(2));
		userPage.addPassword(row.get(3));
		test.log(Status.DEBUG,"User Name on add user="+userPage.getUserName());
		test.log(Status.DEBUG,"Password on add user="+userPage.getPassword());
		System.out.println("The password is "+userPage.getPassword());
		
		userPage.clickSave();
		userPage.clickPage();
		
		DemoSiteLoginPage loginPage = PageFactory.initElements(webDriver, DemoSiteLoginPage.class);
		loginPage.addLoginUserName(row.get(4));
		loginPage.addLoginPassword(row.get(5));
		test.log(Status.DEBUG,"User Name on Login="+loginPage.getUserName());
		test.log(Status.DEBUG,"Password on Login="+loginPage.getPassword());
		
		
		loginPage.clickLogin();

		success=loginPage.getResult();
		 List<String> results = sheetReader.readRow(1, "EXPECTED_RESULT");
		Assert.assertTrue("Successful test", success.equals(results.get(1)));
		 test.pass(success);
	
		
	}
	
	
	@Test
	public void loginTestFail() throws IOException {
	String success="";
	ExtentTest test = report.createTest("MySecondTest"); 

	 test.log(Status.INFO, "My Second Test is Starting SAD Path "); 
	 SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + File.separatorChar +dataFileName);
	  List<String> row = sheetReader.readRow(2, "DATA_INPUT");
		
		DemositeHomePage homePage = PageFactory.initElements(webDriver, DemositeHomePage.class);
		homePage.clickAddUserPage();
		
		DemositeAddUserPage userPage = PageFactory.initElements(webDriver, DemositeAddUserPage.class);
		userPage.addUserName(row.get(2));
		userPage.addPassword(row.get(3));
		test.log(Status.DEBUG,"User Name on add user="+userPage.getUserName());
		test.log(Status.DEBUG,"Password on add user="+userPage.getPassword());
		System.out.println("The password is "+userPage.getPassword());
		
		userPage.clickSave();
		userPage.clickPage();

		
		DemoSiteLoginPage loginPage = PageFactory.initElements(webDriver, DemoSiteLoginPage.class);
		loginPage.addLoginUserName(row.get(4));
		loginPage.addLoginPassword(row.get(5));
		test.log(Status.DEBUG,"User Name on Login="+loginPage.getUserName());
		test.log(Status.DEBUG,"Password on Login="+loginPage.getPassword());
		
		
		loginPage.clickLogin();
		success=loginPage.getResult();

	    try{ 
	    	 List<String> results = sheetReader.readRow(1, "EXPECTED_RESULT");
	 		Assert.assertTrue("Unsuccessful test", success.equals(results.get(1)));
	    	 test.pass("Passed"); 
	    	}
	    catch (AssertionError e) { 
	    	  String details = "SAD Path!!! Failing test: " + e.getMessage(); 
	    	  test.fail(details); 
	    	  String imagePath = ScreenShot.take(webDriver, "image");  
	    	  test.addScreenCaptureFromPath(imagePath); 
  
	    	            throw e; 
	    	         } 

		
	}
	

	@After
	public void tearDown() {
	//	System.out.println("AFTER method");
	webDriver.quit();
		
	}
	
	   @AfterClass 
	public static void cleanUp() { 
	report.flush(); 
	} 

	
	
	

}
