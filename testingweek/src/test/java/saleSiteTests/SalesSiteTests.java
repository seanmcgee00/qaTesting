package saleSiteTests;


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

import testingweek.ScreenShot;
import java.util.concurrent.TimeUnit;

public class SalesSiteTests {
	
	
	private WebDriver webDriver;
	private static final String BASE_URL="http://automationpractice.com/index.php";
    private static ExtentReports salesTestReport;
    private String dataFileName="TestData_salesSite.xlsx";
    
    @BeforeClass 
    public static void init() { 
    	salesTestReport = new ExtentReports(); 
         String fileName = "SalesSiteReport" + ".html"; 
       String filePath = System.getProperty("user.dir") 
                + File.separatorChar + fileName; 
       salesTestReport.attachReporter(new ExtentHtmlReporter(filePath)); 
    } 

	
	
	@Before
	public void setup() {
	//	System.out.println("BEFORE method");
		webDriver= new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
		
		
	}
	
	
	
	
	@Test
	public void regTest() throws Exception 
	{
		ExtentTest test = salesTestReport.createTest("RegTest"); 
		 test.log(Status.INFO, "Registration Test Test is Starting  "); 
		 String success="http://automationpractice.com/index.php?controller=my-account";
		 SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + File.separatorChar +dataFileName);
		 
	try{ 
		 	for(int i=1; i<sheetReader.rownums("DATA_INPUT");i++) {
				List<String> row = sheetReader.readRow(i, "DATA_INPUT");
				test.log(Status.INFO,row.get(0)+" "+row.get(1) );
				
				SalesSiteHomePage homePage = PageFactory.initElements(webDriver, SalesSiteHomePage.class);
				homePage.clickAddUserPage();
				
				TimeUnit.SECONDS.sleep(1);
				SalesSiteSignPage signInPage = PageFactory.initElements(webDriver, SalesSiteSignPage.class);	
				signInPage.insertRegEmail(row.get(2));
				signInPage.selectCreate();
				
				TimeUnit.SECONDS.sleep(2);
				SalesSiteAccountCreatePage createAccPage = PageFactory.initElements(webDriver, SalesSiteAccountCreatePage.class);
				String day=""+(int)Double.parseDouble(row.get(8));
				String month=""+(int)Double.parseDouble(row.get(9));
				String year=""+(int)Double.parseDouble(row.get(10));
				String postcode=""+(int)Double.parseDouble(row.get(13));
				String mobile=""+(int)Double.parseDouble(row.get(11));
				createAccPage.selectTitle(row.get(3));
				createAccPage.setAddress(row.get(4));
				createAccPage.setCity(row.get(5));
				createAccPage.setFirstname(row.get(6));
				createAccPage.setLastname(row.get(7));
				createAccPage.setDayOfBirth(day);
				createAccPage.setMonthOfBirth(month);
				createAccPage.setYearOfBirth(year);
				createAccPage.setMobilePhone(mobile);
				createAccPage.setPassword(row.get(12));
				createAccPage.setPostcode(postcode);
				createAccPage.setState(row.get(14));
				
				createAccPage.clickRegButton();
				
			 
				
				
		    	 
				 Assert.assertTrue("Unsuccessful test", success.equals(webDriver.getCurrentUrl()));
		    	 test.pass("Passed"); 
		 		}
	    	}
	    catch (AssertionError e) { 
	    	  String details = "SAD Path!!! Failing test: " + e.getMessage(); 
	    	  test.fail(details); 
	    	  String imagePath = ScreenShot.take(webDriver, "image");  
	    	  test.addScreenCaptureFromPath(imagePath); 
	    	  throw e;
	    }
		 catch(Exception e)
		 {
			 String details = "Failure in code: " + e.getMessage(); 
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
		   salesTestReport.flush(); 
	} 
	
	
	
	
	
	
	

}
