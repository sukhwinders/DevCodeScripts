//Amrender
package com.org.Example.myproject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class US10319 {

	WebDriver driver;
	String baseUrl;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("CustAdmReqUsername");
	String password1 = guitils.getPassword("CustAdmReqPassword");
	String TPGroupName = guitils.getProperties("TPGroupName"); 
	String FormName = guitils.getProperties("FormName"); 
	String TagName0="GFSI Certified";
	String TagName1="Single Source";
	String UserName="NTWKAutoBatch015";
	String GfsiXPath="/html/body/div/partner-connect/div[2]/div/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/div[1]/label/span";
	
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
		String ListTypeDD = guitils.getProperties("ListTypeDD"); 
		String ListTypeAll = guitils.getProperties("ListTypeAll");
		String AppSelector = guitils.getProperties("AppSelector");
		String TPGroupTab = guitils.getProperties("TPGroupTab");
		
		
		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		
		driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).click();
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.xpath("//a[contains(.,'Trading Partner Group')]")).click();
		Thread.sleep(2000);
		
		
		// Creating New Trading Partner Group 				
				driver.findElement(By.cssSelector("div[title='New']")).click();	
				Thread.sleep(5000);
				driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));		
				driver.findElement(By.id("txtGroupName")).sendKeys(TPGroupName);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[contains(.,'"+TagName0+"')]")).click();
				Thread.sleep(2000);
				//driver.findElement(By.xpath("//span[contains(.,'"+TagName1+"')]")).click();
				//Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@id='tab-scoped-1__item']")).click();
				new Select(driver.findElement(By.id("ddlAttrStatus"))).selectByVisibleText("Pending");		
				Thread.sleep(2000);
				driver.findElement(By.xpath(".//*[@id='tab-scoped-2__item']")).click();
				new Select(driver.findElement(By.id("ddlAttrType"))).selectByVisibleText("Agent");
				Thread.sleep(2000);
				
				driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
				Thread.sleep(3000);
				driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();
				driver.switchTo().defaultContent();
				Thread.sleep(3000);
				
		// Search Trading Partner Group
				driver.findElement(By.id("84:2;a")).sendKeys(TPGroupName);
				Thread.sleep(3000);
				WebElement webElement = driver.findElement(By.id("84:2;a"));
				//webElement.sendKeys(Keys.TAB);
				Thread.sleep(3000);
				webElement.sendKeys(Keys.ENTER);
				Thread.sleep(5000);				
				driver.findElement(By.xpath("/html/body/div[5]/div[1]/section/div[1]/div[1]/div[5]/div[2]/div[2]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/a")).click();
				
		// Set Requirement and Send TP Group Compliance						
				driver.findElement(By.cssSelector("div[title='Set Requirements']")).click();
				driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
				new Select(driver.findElement(By.id("RequestType0"))).selectByVisibleText("All");
				new Select(driver.findElement(By.id("DocType0"))).selectByVisibleText(FormName);
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
				
				
				// Edit tp group					 
			/*	Thread.sleep(3000);	
				driver.findElement(By.linkText("ICIX")).click();
				Thread.sleep(3000);	
				driver.findElement(By.xpath(TPGroupTab)).click();
			    Thread.sleep(3000);
				driver.findElement(By.cssSelector(ListTypeDD)).click();	
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(ListTypeAll)).click();
				Thread.sleep(2000);				
				driver.findElement(By.linkText(TPGroupName)).click();				
				driver.findElement(By.cssSelector("div[title='Edit']")).click();	
				Thread.sleep(5000);
				driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));		
				//driver.findElement(By.id("txtGroupName")).sendKeys(TPGroupName);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[contains(.,'Single Source')]")).click();
				Thread.sleep(2000);				
				driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
				Thread.sleep(5000);
				
				*/
				Thread.sleep(5000);
				//Change user  relationship   
				driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).click();				
				driver.findElement(By.linkText("ICIX")).click();
				Thread.sleep(2000);
				driver.findElement(By.linkText("Accounts")).click();
				Thread.sleep(1000);
				driver.findElement(By.linkText("Recently Viewed")).click();
				Thread.sleep(3000);
				driver.findElement(By.linkText("All Accounts")).click();	
				Thread.sleep(3000);
				driver.findElement(By.linkText(UserName)).click();	
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='titleamResponderOrg__Trading_Partner_Relationships_Responder__r']/a/span[2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.linkText("NTWKAutoBatch015")).click();
				Thread.sleep(3000);
				driver.findElement(By.linkText("Edit")).click();
				Thread.sleep(3000);
				driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
				Thread.sleep(3000);
				driver.findElement(By.id("tab-PartnerRelationship-1__item")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(GfsiXPath)).click();
				Thread.sleep(3000);
				driver.findElement(By.id("btn_UPRelationship_Save")).click();
			    Thread.sleep(5000);
			    driver.findElement(By.xpath("//message-dialog/div[2]/div/div/div[3]/button")).click();			    
			    Thread.sleep(5000);
				
			    
			    //verifying workflow & request
			    
				String RequestsLink = "Requests";
				//String ListTypeDD = "div.triggerLinkTextAndIconWrapper";
				//String ListTypeAll = ".slds-dropdown__item.has-icon--left.forceListViewPickerAutocompleteOption > a";
				driver.findElement(By.linkText("App Launcher")).click();
					
					Thread.sleep(2000);
					driver.findElement(By.linkText("ICIX")).click();
					Thread.sleep(2000);
					driver.findElement(By.linkText(RequestsLink)).click();
					Thread.sleep(5000);					
					driver.findElement(By.cssSelector(ListTypeDD)).click();	
					Thread.sleep(2000);
					driver.findElement(By.cssSelector(ListTypeAll)).click();
					 Thread.sleep(3000);
					 List<WebElement> listInputTable = driver.findElements(By.tagName("th"));
					    String strAttributeSpan = "";
					    String strAttributeTable = "";
					    System.out.println("I am here size" + listInputTable.size());
					    //for click on created date for dec sorting
					    for(int i=0;i<listInputTable.size();i++)
					    {
					    	strAttributeTable = listInputTable.get(i).getAttribute("class");
					    		if((strAttributeTable.contains("initialSortDesc sortable descending"))) 	{
					    			System.out.println("Got class inner " + listInputTable.get(i).getText());
					    			if(listInputTable.get(i).getText().equalsIgnoreCase("Created Date")){
					    				Thread.sleep(1000);
						    			System.out.println("Got class inner " + strAttributeTable);
						    			listInputTable.get(i).click();
					    			}
					    			
					    		}	  
					    }

					    Thread.sleep(4000);
					    Date date = new Date();
					    String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
					    String strAttributeAnchor = "";
					    List<WebElement> listInput = driver.findElements(By.tagName("a"));
					  //for request find and click with modify date
					    for(int i=0;i<listInput.size();i++)
					    {
					    	strAttributeAnchor = listInput.get(i).getAttribute("class");
					    		if((strAttributeAnchor.contains(" outputLookupLink forceOutputLookup"))) 	{
					    			System.out.println("Got class inner11 " + listInput.get(i).getText());
					    			if(listInput.get(i).getText().contains(FormName)){
					    				Thread.sleep(1000);
						    			System.out.println("Got class inner2222 " + strAttributeAnchor);
						    			listInput.get(i).click();
					    			}
					    			
					    		}	  
					    }
					    List<WebElement> listInputSpan = driver.findElements(By.tagName("span"));
						//  
					    for(int i=0;i<listInputSpan.size();i++)
					    {
					    	strAttributeSpan = listInputSpan.get(i).getAttribute("class");
					    		if((strAttributeSpan.contains("title"))) 	{
					    			System.out.println("Got class inner33 " + listInputSpan.get(i).getText());
					    			if(listInputSpan.get(i).getText().equalsIgnoreCase("Related")){
					    				Thread.sleep(1000);
						    			System.out.println("Got class inner333 " + strAttributeSpan);
						    			listInputSpan.get(i).click();
					    			}
					    			
					    		}	  
					    
					    }
					    if(driver.findElements(By.xpath("(//a[contains(text(),'"+FormName+"')])")).size()>0)
					       {
					    	System.out.println("true");
					        Assert.assertEquals(1, 1);
					       }
					       else
					       {
					    	   System.out.println("False");
					        Assert.assertEquals(0, 1);
					       }
				
				
			    
			    /*String RequestsLink = "Requests";
				//String ListTypeDD = "div.triggerLinkTextAndIconWrapper";
				//String ListTypeAll = ".slds-dropdown__item.has-icon--left.forceListViewPickerAutocompleteOption > a";
				driver.findElement(By.linkText("App Launcher")).click();
					
					Thread.sleep(2000);
					driver.findElement(By.linkText("ICIX")).click();
					Thread.sleep(2000);
					driver.findElement(By.linkText(RequestsLink)).click();
					Thread.sleep(3000);					
					driver.findElement(By.cssSelector(ListTypeDD)).click();	
					Thread.sleep(2000);
					driver.findElement(By.cssSelector(ListTypeAll)).click();
					 Thread.sleep(3000);
					 List<WebElement> listInputTable = driver.findElements(By.tagName("th"));
					    String strAttributeSpan = "";
					    String strAttributeTable = "";
					    System.out.println("I am here size" + listInputTable.size());
					    for(int i=0;i<listInputTable.size();i++)
					    {
					    	strAttributeTable = listInputTable.get(i).getAttribute("class");
					    		if((strAttributeTable.contains("initialSortDesc sortable descending"))) 	{
					    			System.out.println("Got class inner " + listInputTable.get(i).getText());
					    			if(listInputTable.get(i).getText().equalsIgnoreCase("Created Date")){
					    				Thread.sleep(1000);
						    			System.out.println("Got class inner " + strAttributeTable);
						    			listInputTable.get(i).click();
					    			}
					    			
					    		}	  
					    }

					    Thread.sleep(4000);
					    Date date = new Date();
					    String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
					    String strAttributeAnchor = "";
					    List<WebElement> listInput = driver.findElements(By.tagName("a"));
					  
					    for(int i=0;i<listInput.size();i++)
					    {
					    	strAttributeAnchor = listInput.get(i).getAttribute("class");
					    		if((strAttributeAnchor.contains(" outputLookupLink forceOutputLookup"))) 	{
					    			System.out.println("Got class inner11 " + listInput.get(i).getText());
					    			if(listInput.get(i).getText().contains(FormName + modifiedDate)){
					    				Thread.sleep(1000);
						    			System.out.println("Got class inner2222 " + strAttributeAnchor);
						    			listInput.get(i).click();
					    			}
					    			
					    		}	  
					    }
					    List<WebElement> listInputSpan = driver.findElements(By.tagName("span"));
						  
					    for(int i=0;i<listInputSpan.size();i++)
					    {
					    	strAttributeSpan = listInputSpan.get(i).getAttribute("class");
					    		if((strAttributeSpan.contains("title"))) 	{
					    			System.out.println("Got class inner33 " + listInputSpan.get(i).getText());
					    			if(listInputSpan.get(i).getText().equalsIgnoreCase("Related")){
					    				Thread.sleep(1000);
						    			System.out.println("Got class inner333 " + strAttributeSpan);
						    			listInputSpan.get(i).click();
					    			}
					    			
					    		}	  
					    
					    }
					    if(driver.findElements(By.xpath("(//a[contains(text(),"+FormName+")])")).size()>0)
					       {
					    	System.out.println("true");
					        Assert.assertEquals(1, 1);
					       }
					       else
					       {
					    	   System.out.println("False");
					        Assert.assertEquals(0, 1);
					       }
				
*/		
	}
}
	

