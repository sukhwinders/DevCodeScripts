package com.org.Example.myproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class VerifyTestApproveRequest {
	WebDriver driver;
	String baseUrl;
	Data_loading guitils = new Data_loading();
	//String userName1 = guitils.getUserName("CustomerAdminRequestorUsername");
	//String password1 = guitils.getPassword("CustomerAdminRequestorPassword");
	String userName1 = guitils.getUserName("StandardUserRequestorUsername");
	String password1 = guitils.getPassword("StandardUserRequestorPassword");
	
	String ApproveStatus = guitils.getProperties("ApproveStatus");
	
	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();	  
	  }
	
	@Test
	public void testApproveRequest() throws Exception {

		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(8000);
		guitils.LightiningView(driver);
		Thread.sleep(5000);
		guitils.VerifyRequestStatus(driver,ApproveStatus);
	}
	
	
}
