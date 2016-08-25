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

public class TestSearchAndConnect {

	WebDriver driver;
	String baseUrl;
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("CustomerAdminRequestorUsername");
	String password1 = guitils.getPassword("CustomerAdminRequestorPassword");
	//String userName1 = guitils.getUserName("StandardUserRequestorUsername");
	//String password1 = guitils.getPassword("StandardUserRequestorPassword");
	String Partner = guitils.getDATA("CompenyName");
	String ICIX_ID = guitils.getDATA("icixid");
	String IFrame = guitils.getProperties("IFrame");
	
	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void testSearchByIcixId() throws Exception {
		guitils.loginToPortal(userName1, password1, driver);
		
		guitils.LightiningView(driver);
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Accounts")).click();
		Thread.sleep(3000);
		// New button
		driver.findElement(By.linkText("New")).click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));

		driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(
				ICIX_ID);
		driver.findElement(
				By.cssSelector("button.slds-button.slds-button--brand"))
				.click();
		driver.findElement(
				By.cssSelector("button.slds-button.slds-button--brand.slds-button--large.ng-scope"))
				.click();
		
	    driver.findElement(By.id("tab-PartnerRelationship-1__item")).click();

	   
	    Thread.sleep(3000);
	  //  driver.findElement(By.id("cb_UURelationship_Tag3")).click();
	    driver.findElement(By.xpath("//span[@class='slds-checkbox--faux'][1]")).click();
	    driver.findElement(By.id("btn_UPRelationship_Save")).click();
	    Thread.sleep(3000);
		String AccountMessage = driver.findElement(By.cssSelector("div.row.ng-binding")).getText();
		Assert.assertEquals(AccountMessage, "Trading Partner connected successfully.");
	    
	    
		//String compeny_Name = driver.findElement(
		//		By.xpath("//h1[@class='slds-text-heading--small ng-binding']"))
		///		.getText();
		//Assert.assertEquals(compeny_Name, Partner, "Name is not matched");

	}
}

