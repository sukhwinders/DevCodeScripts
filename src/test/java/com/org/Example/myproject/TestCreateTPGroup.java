package com.org.Example.myproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TestCreateTPGroup {
	WebDriver driver;
	String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("CustomerAdminRequestorUsername");
	String password1 = guitils.getPassword("CustomerAdminRequestorPassword");
	String TPGroupName = guitils.getProperties("TPGroupName"); 
	String FormName = guitils.getProperties("FormName"); 
	
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
	public void CreatingTPGroup() throws Exception {
		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		
		Thread.sleep(3000);	
		guitils.CreateTPGroup(driver);
		
		Thread.sleep(3000);
		// Search Trading Partner 
		driver.findElement(By.id("84:2;a")).sendKeys(TPGroupName);
		Thread.sleep(3000);
		WebElement webElement = driver.findElement(By.id("84:2;a"));
		webElement.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		webElement.sendKeys(Keys.ENTER);
		Thread.sleep(3000);	
		driver.findElement(By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div[5]/div[2]/div[2]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/a")).click();
		
		// Set Requirement and Send TP Group Compliance
		Thread.sleep(2000);	
		driver.findElement(By.cssSelector("div[title='Set Requirements']")).click();
		Thread.sleep(2000);	
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		Thread.sleep(2000);	
		
		new Select(driver.findElement(By.id("RequestType0"))).selectByVisibleText("All");
		new Select(driver.findElement(By.id("DocType0"))).selectByVisibleText(FormName);
		Thread.sleep(2000);	
		driver.findElement(By.name("dateid")).click();
		
		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[1]/div[4]/section/div/div/slds-datepicker/div/div[2]/table/tbody/tr[5]/td[7]/span")).click();
		Thread.sleep(2000);	
		new Select(driver.findElement(By.id("RequirementType0"))).selectByVisibleText("Approval");
		Thread.sleep(2000);	
		driver.findElement(By.xpath("html/body/div[1]/div/div[3]/button[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();
		//driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();	
		
		System.out.println("Success: Set Requirements and Save TP Group Compliance");
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);		
		driver.findElement(By.cssSelector("div[title='Set Requirements']")).click();
		Thread.sleep(2000);	
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		Thread.sleep(2000);	
		driver.findElement(By.id("btnSend")).click();
		Thread.sleep(10000);	
		/*
		// View and Edit TP Group Compliance
		driver.findElement(By.xpath("//span[contains(.,'Related')]")).click();
		driver.findElement(By.xpath("//span[contains(.,'Trading Partner Group Requirements')]")).click();
		driver.findElement(By.xpath("//table[@class='forceRecordLayout uiVirtualDataGrid--default uiVirtualDataGrid forceVirtualGrid']/tbody/tr/th/a"))
			.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@title='Edit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")).click();
		System.out.println("Success: View and Edit TP Group Compliance");
		Thread.sleep(4000);
		*/
		// Delete TP Group Compliance
	/*	driver.findElement(By.xpath("//div[@title='Delete']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		System.out.println("Success: Delete TP Group Compliance");
		*/
	}
}
