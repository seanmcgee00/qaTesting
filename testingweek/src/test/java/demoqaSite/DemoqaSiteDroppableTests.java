package demoqaSite;


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

import saleSiteTests.SalesSiteHomePage;
import testingweek.ScreenShot;
import java.util.concurrent.TimeUnit;

public class DemoqaSiteDroppableTests {
	
	private WebDriver webDriver;
	private static final String BASE_URL="http://demoqa.com/";
    private static ExtentReports droppableTestReport;
   
    
    @BeforeClass 
    public static void init() { 
    	droppableTestReport = new ExtentReports(); 
         String fileName = "droppableTestReport" + ".html"; 
       String filePath = System.getProperty("user.dir") 
                + File.separatorChar + fileName; 
       droppableTestReport.attachReporter(new ExtentHtmlReporter(filePath)); 
    } 

	
	
	@Before
	public void setup() {
	//	System.out.println("BEFORE method");
		webDriver= new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
		
		
	}
	
	@Test
	public void droppableDefaultTest() throws IOException, InterruptedException
	{
		
		ExtentTest test = droppableTestReport.createTest("droppable_default"); 
		test.log(Status.INFO, "droppable default Test is Starting  "); 
		
		DemoqaSiteHomePage homePage = PageFactory.initElements(webDriver, DemoqaSiteHomePage.class);
		DemoqaSiteDroppablePage droppablePage = PageFactory.initElements(webDriver, DemoqaSiteDroppablePage.class);
		
		homePage.clickDroppablePage();
		
		droppablePage.defaultDragandDrop(webDriver);
		
		TimeUnit.SECONDS.sleep(1);
		
		try {
			System.out.println(droppablePage.defaultResult());
			 Assert.assertTrue("Unsuccessful test", droppablePage.defaultResult().equalsIgnoreCase("Dropped!"));
			 
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
	
	
	
	@Test
	public void droppableAcceptTest() throws IOException, InterruptedException
	{
		
		ExtentTest test = droppableTestReport.createTest("droppable_Accept"); 
		test.log(Status.INFO, "droppable Accept Test is Starting  "); 
		
		DemoqaSiteHomePage homePage = PageFactory.initElements(webDriver, DemoqaSiteHomePage.class);
		DemoqaSiteDroppablePage droppablePage = PageFactory.initElements(webDriver, DemoqaSiteDroppablePage.class);
		
		homePage.clickDroppablePage();
		
		droppablePage.clickAccept();;
		
		TimeUnit.SECONDS.sleep(1);
		
		droppablePage.acceptDragandDrop(webDriver);
		
		try {
			
			 Assert.assertTrue("Unsuccessful test", droppablePage.acceptResult().equalsIgnoreCase("Dropped!"));
			 
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
		   droppableTestReport.flush(); 
	} 

}
