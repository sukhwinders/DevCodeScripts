package com.org.Example.myproject;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class US10320 {
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("CustAdmReqUsername");
	String password1 = guitils.getPassword("CustAdmReqPassword");
	//String Responder = guitils.getDATA("TPResponder");
	//String userName2 = guitils.getUserName("ResponderUsername");
	//String password2 = guitils.getPassword("ResponderPassword");
	String comment = guitils.getPassword("Comments");

	Date d = new Date(System.currentTimeMillis());
	String Reqname = "AutoTest" + d;

	String firstwindow;
	String secondwindow;
	WebElement tblAccounts;
	List<WebElement> RowsOfTable;
	WebElement ColOfTable;
	WebDriver driver;
	String baseUrl;
	String AccountName1 = "NTWKAutoBatch015";
	String AccountName2 = "NTWKAutoBatch005";

	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	@Test
	public void US() throws Exception {
		
		//Change relactionship of the existing user
		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(.,'Accounts')]")).click();
		Thread.sleep(3000);
		//driver.findElement(By.linkText(AccountName1)).click();
		//Thread.sleep(3000);
		guitils.CreateRelationship(driver,AccountName1);
		Thread.sleep(15000);		
		driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(.,'Accounts')]")).click();
		Thread.sleep(3000);
		//driver.findElement(By.linkText(AccountName2)).click();
		//Thread.sleep(3000);
		guitils.CreateRelationship(driver,AccountName2);   
		
		Thread.sleep(8000);
		//Createing TP Group
		driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).click();
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.linkText("Trading Partner Groups")).click();
		Thread.sleep(3000);					
		driver.findElement(By.linkText("New")).click();	
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		driver.findElement(By.id("txtGroupName")).sendKeys("Group First");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='tab-scoped-0']/div/div[4]/div/label/span[1]")).click();		
		driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
		Thread.sleep(3000);
		String Message = driver.findElement(By.xpath("//p[@class='ng-binding']")).getText();
		Assert.assertEquals(Message, "Trading partner group created successfully");
		driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();
		Thread.sleep(5000);		
		driver.navigate().refresh();
		Thread.sleep(8000);	
		driver.findElement(By.linkText("Group First")).click();
		
		//Set requirement after created Tp Group		
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
						Thread.sleep(5000);	
						driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();
						
						//Verify Group with group members
						Thread.sleep(6000);							
						driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).click();
						driver.findElement(By.linkText("ICIX")).click();
						driver.findElement(	By.xpath("//a[contains(.,'Trading Partner Group')]")).click();
						Thread.sleep(3000);
						driver.findElement(By.linkText("Recently Viewed")).click();
						Thread.sleep(3000);
						driver.findElement(By.linkText("All")).click();
						Thread.sleep(3000);
						driver.findElement(By.linkText("test1")).click();
						Thread.sleep(3000);
						//driver.findElement(By.linkText("Related")).click();
						driver.findElement(By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div[5]/div/div/div[2]/div[1]/div/div/div/ul/li[1]/a/span[2]")).click();
						Thread.sleep(3000);
						//driver.findElement(By.linkText("Trading Partner Group Members")).click();
						driver.findElement(By.xpath(".//*[@id='titleSK001__Partner_Group_Members__r']/a/span[2]")).click();
		
						Thread.sleep(6000);
						//Verify Rquirement for Group members						
						driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).click();
						driver.findElement(By.linkText("ICIX")).click();
						driver.findElement(	By.xpath("//a[contains(.,'Trading Partner Group')]")).click();
						Thread.sleep(3000);
						driver.findElement(By.linkText("Recently Viewed")).click();
						Thread.sleep(3000);
						driver.findElement(By.linkText("All")).click();
						Thread.sleep(3000);
						driver.findElement(By.linkText("G1")).click();
						Thread.sleep(3000);
						//driver.findElement(By.linkText("Related")).click();
						driver.findElement(By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div[5]/div/div/div[2]/div[1]/div/div/div/ul/li[1]/a/span[2]")).click();
						Thread.sleep(3000);
						//driver.findElement(By.linkText("Trading Partner Group Requirements")).click();
						driver.findElement(By.xpath(".//*[@id='titleSK001__Partner_Group_Requirements__r']/a/span[2]")).click();
						
						
	}


}
