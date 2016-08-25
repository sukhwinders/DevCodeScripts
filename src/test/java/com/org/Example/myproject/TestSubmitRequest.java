package com.org.Example.myproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TestSubmitRequest {
	WebDriver driver;
	String baseUrl;
	Data_loading guitils = new Data_loading();
	private StringBuffer verificationErrors = new StringBuffer();
	//String userName1 = guitils.getUserName("CustomerAdminResponderUsername");
	//String password1 = guitils.getPassword("CustomerAdminResponderPassword");
	String userName1 = guitils.getUserName("StandardUserResponderUsername");
	String password1 = guitils.getPassword("StandardUserResponderPassword");
	
	String RequestName = guitils.getRequestName("RequestForApproval");
	String ICIX_ID = guitils.getDATA("ICIX_ID");
	
	
	
	String RelatedList = guitils.getProperties("RelatedList");
	String WorkFlowActionDD = guitils.getProperties("WorkFlowActionDD");
	String ApproveLink = guitils.getProperties("ApproveLink");
	String ApproveStatus = guitils.getProperties("ApproveStatus");
	String IFrame = guitils.getProperties("IFrame");
		
	
	
	
	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    Assert.assertEquals(verificationErrorString, "");
	  }
	
	@Test
	public void testSubmitRequest() throws Exception {

		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(8000);
		guitils.LightiningView(driver);
		Thread.sleep(5000);
		
		
		guitils.RequestTab(driver);
	    Thread.sleep(2000);
	    driver.findElement(By.linkText(RequestName)).click();
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector(RelatedList)).click();
	    Thread.sleep(5000);
	    //driver.findElement(By.cssSelector("th div .textUnderline.outputLookupLink.forceOutputLookup")).click();
	    driver.findElement(By.linkText(RequestName)).click();
	    Thread.sleep(5000);

	    driver.findElement(By.cssSelector("div[title=\"Submit\"]")).click();
	    Thread.sleep(20000);
	    
	   // guitils.VerifyRequestStatus(driver,ApproveStatus);
		

	}
	
}



