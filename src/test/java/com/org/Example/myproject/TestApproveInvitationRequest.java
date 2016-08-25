package com.org.Example.myproject;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TestApproveInvitationRequest{
	Data_loading guitils = new Data_loading();
	private StringBuffer verificationErrors = new StringBuffer();
	//String userName1 = guitils.getUserName("RequestorUsername");
	//String password1 = guitils.getPassword("RequestorPassword");
	String Responder = guitils.getDATA("TPResponder");
	String userName2 = guitils.getUserName("ResponderUsername");
	String password2 = guitils.getPassword("ResponderPassword");
	String comment = guitils.getPassword("Comments");
	String InvitationRequest = guitils.getRequestName("InvitationRequest");
	
	
	Date d = new Date(System.currentTimeMillis());
	String Reqname = "AutoTest" + d;

	String firstwindow;
	String secondwindow;
	WebElement tblAccounts;
	List<WebElement> RowsOfTable;
	WebElement ColOfTable;
	WebDriver driver;
	String baseUrl;

	@BeforeClass
	public void beforeClass() {		
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		 String verificationErrorString = verificationErrors.toString();
		    Assert.assertEquals(verificationErrorString, "");
	}

	@Test
	public void Approve_Request() throws Exception {
		guitils.loginToPortal(userName2, password2, driver);
		guitils.LightiningView(driver);
		Thread.sleep(5000);
		
		guitils.RequestTab(driver);
		
		driver.findElement(By.linkText(InvitationRequest)).click();
		Thread.sleep(2000);	
		/*driver.findElement(By.linkText("Related")).click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath(".textUnderline.outputLookupLink.forceOutputLookup")).click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath(".forceIconDeprecated.forceIcon")).click();		
		Thread.sleep(2000);	
		driver.findElement(By.xpath(".uiMenuItem>a")).click();		
		Thread.sleep(2000);	*/
		 driver.findElement(By.cssSelector("span.title")).click();
		   // driver.findElement(By.xpath("(//a[contains(text(),'Trading Partner Relationship Invitation from NTWKAutoBatch023')])[2]")).click();
		 driver.findElement(By.linkText(InvitationRequest)).click();
		    driver.findElement(By.cssSelector("span.forceIconDeprecated.forceIcon")).click();
		    driver.findElement(By.linkText("Approve")).click();
		    driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		  
		    driver.findElement(By.name("j_id0:j_id40:commentBlock:j_id44")).clear();
		    driver.findElement(By.name("j_id0:j_id40:commentBlock:j_id44")).sendKeys("Approved");
		    driver.findElement(By.name("j_id0:j_id40:j_id46:j_id50")).click();
		
		}
}