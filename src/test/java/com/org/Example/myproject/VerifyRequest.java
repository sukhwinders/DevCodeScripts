package com.org.Example.myproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.utils.Data_loading;

public class VerifyRequest {

	String firstwindow;
	WebDriver driver;
	String baseUrl;
	String path;

	Data_loading guitils = new Data_loading();
//	String userName1 = guitils.getUserName("CustomerAdminRequestorUsername");
//	String password1 = guitils.getPassword("CustomerAdminRequestorPassword");
	String userName1 = guitils.getUserName("StandardUserRequestorUsername");
	String password1 = guitils.getPassword("StandardUserRequestorPassword");
	String Icixid = guitils.getDATA("icixid");
	
	
	@Test
	public void Auccount_verification() throws Exception {
		//Login to the salesforce
		guitils.loginToPortal(userName1,password1,driver);
		Thread.sleep(8000);

		// switchtoLightining();
		guitils.LightiningView(driver);

		/*driver.findElement(By.cssSelector("div.r2")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.linkText("ICIX")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.linkText("Requests")).click();
		  Thread.sleep(3000);
		  */
		Thread.sleep(5000);
		guitils.RequestTab(driver);
		
		  // New button
		
		    // if(driver.findElements(By.xpath("(//a[contains(text(),'New Request')])")).size()>0)
			if(driver.findElements(By.linkText("Test Automation New Request")).size()>0)
		     {
		    	 Assert.assertEquals(1, 1);
		     }
		     else
		     {
		    	 Assert.assertEquals(0, 1);
		     }
		     
	}

	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	


}
