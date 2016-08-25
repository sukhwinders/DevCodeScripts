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

public class TestRejectRequest {
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
	String RejectLink = guitils.getProperties("RejectLink");
	String RejectStatus = guitils.getProperties("RejectStatus");
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
	public void testRejectRequest() throws Exception {

		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(8000);
		guitils.LightiningView(driver);
		Thread.sleep(2000);
		
		guitils.RequestTab(driver);
		Thread.sleep(2000);
	    driver.findElement(By.linkText(RequestName)).click();
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector(RelatedList)).click();
	    Thread.sleep(5000);
	    //driver.findElement(By.cssSelector("th div .textUnderline.outputLookupLink.forceOutputLookup")).click();
	    driver.findElement(By.linkText(RequestName)).click();
	    Thread.sleep(2000);
	   // driver.findElement(By.xpath("(//a[contains(text(),'Test Automation New Request')])[2]")).click();
	  //  Thread.sleep(4000);
	    driver.findElement(By.cssSelector(WorkFlowActionDD)).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText(RejectLink)).click();
	    
	    driver.switchTo().frame(driver.findElement(By.id(IFrame)));
	
	    driver.findElement(By.name("j_id0:j_id7:j_id35:j_id51")).clear();
	    driver.findElement(By.name("j_id0:j_id7:j_id35:j_id51")).sendKeys("Rejected");
	    driver.findElement(By.name("j_id0:j_id7:j_id35:j_id53")).click();
	    Thread.sleep(2000);
	   // guitils.VerifyRequestStatus(driver,RejectStatus);

	}
	
}


