package com.org.Example.myproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TestApproveRequest {
	WebDriver driver;
	String baseUrl;
	Data_loading guitils = new Data_loading();
	private StringBuffer verificationErrors = new StringBuffer();
	//String userName1 = guitils.getUserName("CustomerAdminRequestorUsername");
	//String password1 = guitils.getPassword("CustomerAdminRequestorPassword");
	String userName1 = guitils.getUserName("StandardUserRequestorUsername");
	String password1 = guitils.getPassword("StandardUserRequestorPassword");
	
	String RequestName = guitils.getRequestName("RequestForApproval");
	String ICIX_ID = guitils.getDATA("ICIX_ID");
	
	String AppSelector = guitils.getProperties("AppSelector");
	String ICIXLink = guitils.getProperties("ICIXLink");
	String RequestsLink = guitils.getProperties("RequestsLink");
	String ListTypeDD = guitils.getProperties("ListTypeDD");
	String ListTypeAll = guitils.getProperties("ListTypeAll");
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
	public void testApproveRequest() throws Exception {

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
	    Thread.sleep(2000);

	    if ( driver.findElements(By.xpath("(//a[contains(text(),'Submitted')])")).size()>0)
	    {
	    
		    driver.findElement(By.cssSelector(WorkFlowActionDD)).click();
		    Thread.sleep(2000);
		    driver.findElement(By.linkText(ApproveLink)).click();
		    
		    driver.switchTo().frame(driver.findElement(By.id(IFrame)));
		
		    driver.findElement(By.name("j_id0:j_id40:commentBlock:j_id44")).clear();
		    driver.findElement(By.name("j_id0:j_id40:commentBlock:j_id44")).sendKeys("Approved");
		    Thread.sleep(2000);
		    driver.findElement(By.name("j_id0:j_id40:j_id46:j_id50")).click();
			
		    Thread.sleep(2000);
	    }
	    else
	    {
	    	Assert.assertEquals("0", "1");
	    }
	    
	   // guitils.VerifyRequestStatus(driver,ApproveStatus);
		

	}
	
}


