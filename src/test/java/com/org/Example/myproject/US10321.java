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

public class US10321 {
	WebDriver driver;
	String baseUrl;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("CustAdmReqUsername");
	String password1 = guitils.getPassword("CustAdmReqPassword");
	String partner_name = guitils.getDATA("Partner_name");
	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void CreatingTPGroup() throws Exception {
		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]"))
		.click();
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.xpath("//a[contains(.,'Trading Partner Groups')]")).click();
		Thread.sleep(3000);
	
		// Creating New Trading Partner Group first 				
		driver.findElement(By.cssSelector("div[title='New']")).click();	
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		driver.findElement(By.id("txtGroupName")).sendKeys("Group First");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='slds-checkbox--faux'][1]"))
		.click();
		
		driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
		Thread.sleep(3000);
		String Message = driver.findElement(
				By.xpath("//p[@class='ng-binding']"))
				.getText();
		Assert.assertEquals(Message, "Trading partner group created successfully");
		driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		
		driver.findElement(By.linkText("Group First")).click();
		/*
// Search Trading Partner 
		driver.findElement(By.id("84:2;a")).sendKeys("Group First");
		Thread.sleep(3000);
		WebElement webElement = driver.findElement(By.id("84:2;a"));
		//webElement.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		webElement.sendKeys(Keys.ENTER);
		Thread.sleep(5000);	
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/section/div[1]/div[1]/div[5]/div[2]/div[2]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/a")).click();
		*/
		
// Set Requirement and Send TP Group Compliance
		driver.findElement(By.cssSelector("div[title='Set Requirements']")).click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		new Select(driver.findElement(By.id("RequestType0"))).selectByVisibleText("All");
		new Select(driver.findElement(By.id("DocType0"))).selectByVisibleText("California Proposition 65 Warranty");
		driver.findElement(By.name("dateid")).click();				
		//Click on date picker 
		driver.findElement(By.xpath("//input[@name='dateid']")).click();
		Thread.sleep(2000);	
		//driver.findElement(By.xpath("//button[@ng-click='nextMonth()']")).click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//span[contains(.,'26')]")).click();
		new Select(driver.findElement(By.id("RequirementType0"))).selectByVisibleText("Approval");
		driver.findElement(By.xpath("html/body/div[1]/div/div[3]/button[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();					
		System.out.println("Success: Set Requirements and Send TP Group Compliance");
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		// sent requirement 
		Thread.sleep(3000);		
		driver.findElement(By.cssSelector("div[title='Set Requirements']")).click();
		Thread.sleep(2000);	
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		Thread.sleep(2000);	
		driver.findElement(By.id("btnSend")).click();
		Thread.sleep(6000);	
		driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();
		
		Thread.sleep(6000);	
		
		
		
		
		
		driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//a[contains(.,'Trading Partner Group')]")).click();
		driver.findElement(By.linkText("Trading Partner Groups")).click();
		Thread.sleep(4000);
	
// Creating New Trading Partner Group 	
		driver.findElement(By.linkText("New")).click();
		//driver.findElement(By.cssSelector("div[title='New']")).click();	
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		driver.findElement(By.id("txtGroupName")).sendKeys("Group2");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='slds-checkbox--faux'][1]"))
		.click();
		
		driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Group2")).click();
		/*
// Search Trading Partner 
		driver.findElement(By.id("84:2;a")).sendKeys("Group2");
		Thread.sleep(3000);
		WebElement webElement1 = driver.findElement(By.id("84:2;a"));
		webElement1.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		webElement1.sendKeys(Keys.ENTER);
		Thread.sleep(3000);	
		driver.findElement(By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div[5]/div[2]/div[2]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/a"))
						.click();
						*/
		
// Set Requirement and Send TP Group Compliance
				driver.findElement(By.cssSelector("div[title='Set Requirements']")).click();
				driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
				new Select(driver.findElement(By.id("RequestType0"))).selectByVisibleText("All");
				new Select(driver.findElement(By.id("DocType0"))).selectByVisibleText("California Proposition 65 Warranty");
				driver.findElement(By.name("dateid")).click();				
				//Click on date picker 
				driver.findElement(By.xpath("//input[@name='dateid']")).click();
				Thread.sleep(2000);	
				//driver.findElement(By.xpath("//button[@ng-click='nextMonth()']")).click();
				Thread.sleep(2000);	
				driver.findElement(By.xpath("//span[contains(.,'26')]")).click();
				new Select(driver.findElement(By.id("RequirementType0"))).selectByVisibleText("Approval");
				driver.findElement(By.xpath("html/body/div[1]/div/div[3]/button[2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();					
				System.out.println("Success: Set Requirements and Send TP Group Compliance");
				driver.switchTo().defaultContent();
				Thread.sleep(3000);
				
				// sent requirement 
				Thread.sleep(3000);		
				driver.findElement(By.cssSelector("div[title='Set Requirements']")).click();
				Thread.sleep(2000);	
				driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
				Thread.sleep(2000);	
				driver.findElement(By.id("btnSend")).click();
				Thread.sleep(6000);	
				//driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();
				
		
		//CHECK REQUEST NOT SENT
		String compeny_Name = driver.findElement(
				By.xpath("//h3[@class='ng-binding']"))
				.getText();
		String Message1 = compeny_Name.substring(0, 86);
		String Message2 = compeny_Name.substring(87, 121);
		Assert.assertEquals(Message1, "Request is not sent for the following Requirements and Members as it was already sent:");
		Assert.assertEquals(Message2, "California Proposition 65 Warranty");
				//+ "<br>California Proposition 65 Warranty Requirement<br/> Nitin Uniyal Responder Org2");
		//driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();
				
				
	}
	


}

