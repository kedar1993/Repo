package TestScenarios;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;


import TestObjectRepository.Homepage;
import UserDefinedLibraries.DriverSetup;
import UserDefinedLibraries.ExcelReadWrite;
import UserDefinedLibraries.ScreenShot;
import UserDefinedLibraries.*;



public class NavigationCommand  {
	
	private static final String Assert = null;
	private static final String ExpectedTitle = null;
	public static WebDriver driver;
	
	public static void main(String args[]) {
		testdriverconfig();
		
		try {
			testsetValue();
		} catch (Exception e) { // TODO Auto-generated catch
			e.printStackTrace();
		}
		readTestData();
		testnavigateForward();

	}
	
	@Test
	public static void testdriverconfig()
    
    {
    	driver=DriverSetup.driverInstantiate("chrome");   
    }
    
   
	@Test
	public void testcaseRexl() throws IOException, FileNotFoundException
    {
    	ExcelReadWrite.readexcel();    	
    }
	
	
	@Test
	public static  void testsetValue() throws Exception {
    	
    	WebElement element=Homepage.googleSearchBar(driver);
    	String data=readTestData();
    	System.out.println(element.getText());
//    	element.sendKeys("Selenium Automation");
    	element.sendKeys(data,Keys.ENTER);
    	//element.sendKeys(Keys.Enter);
    	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    	WebDriverWait wait=new WebDriver(driver,15);
    	String actualTitle=driver.getTitle();
    	System.out.println("1.actual:"+actualTitle);
    	String expectedTitle="Selenium Automation - Google Search";
    	System.out.println("1.expected:"+expectedTitle);
    	org.junit.Assert.assertEquals(actualTitle,ExpectedTitle);
    }

   private static String readTestData() {
		// TODO Auto-generated method stub
		return "Selenium Automation";
	}

@Test
public  void testScreenShot() throws IOException
    {
    	ScreenShot.getScreenShot(driver);
    }
    
    @Test
	public  void testnavigateBackward() {
    	driver.navigate().back();
    	//driver.manage()timeouts().implicitlyWait(2,TimeUnit.SECONDS);
    	String actualTitle=driver.getTitle();
    	System.out.println("2.actual:"+actualTitle);
    	String ExpectedTitle="Google";
    	System.out.println("2.expected:"+actualTitle);
    	org.junit.Assert.assertEquals(actualTitle,ExpectedTitle);
    }
    
  @Test
public static  void testnavigateForward() {
  	driver.navigate().forward();
  	//driver.manage()timeouts().implicitlyWait(2,TimeUnit.SECONDS);
  	String actualTitle=driver.getTitle();
  	System.out.println("3.actual:"+actualTitle);
  	String ExpectedTitle="Google";
  	System.out.println("3.expected:"+ExpectedTitle);
  	junit.framework.Assert.assertEquals(actualTitle,ExpectedTitle);
  }
  
}
  


  
  /*@AfterClass
   * public static void closeBrowser() {
  
  	driverClose();    
  }  */
  
    