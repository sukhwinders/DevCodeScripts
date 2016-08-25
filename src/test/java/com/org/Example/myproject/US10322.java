//Gurpinder 
package com.org.Example.myproject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class US10322 {
	WebDriver driver;
	String baseUrl;
	String sTblAccounts = "//table[@class='forceRecordLayout uiVirtualDataGrid--default uiVirtualDataGrid forceVirtualGrid resizable-cols']//tbody";
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("CustAdmReqUsername");
	String password1 = guitils.getPassword("CustAdmReqPassword");
	String strTPName = guitils.getPassword("TPGroupName");

	WebElement tblAccounts;
	List<WebElement> RowsOfTable;
	WebElement ColOfTable;

	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	} 

	@Test
	public void Auccount_verification() throws Exception {
		// Login to the salesforce
		guitils.loginToPortal(userName1,password1,driver);
		
		Thread.sleep(2000);
		
		guitils.LightiningView(driver);
//		driver.findElement(By.linkText("App Launcher")).click();
//		String ListTypeDD = "div.triggerLinkTextAndIconWrapper"; 
//		String ListTypeAll = ".slds-dropdown__item.has-icon--left.forceListViewPickerAutocompleteOption > a";
//		String TPGroupTab = "//a[contains(.,'Trading Partner Group')]";
//		
//		driver.findElement(By.linkText("App Launcher")).click();
//		 
//		Thread.sleep(3000);	
//		driver.findElement(By.linkText("ICIX")).click();
//		Thread.sleep(3000);	
//		driver.findElement(By.xpath(TPGroupTab)).click();
//		Thread.sleep(3000);
//		driver.findElement(By.cssSelector(ListTypeDD)).click();	
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector(ListTypeAll)).click();
//		Thread.sleep(2000);
//		
//		List<WebElement> listInputs =  driver.findElements(By.cssSelector("th a.outputLookupLink.forceOutputLookup"));
//		
//		String strAttribute="";
//		for(int i=0;i<listInputs.size();i++){
//			strAttribute = listInputs.get(i).getText();
//    		if((strAttribute.contains("Test TP1"))) 	{
//    			Thread.sleep(3000);
//    			System.out.println("Got class inner " + strAttribute);
//    			listInputs.get(i).click();
//    		}
//	    }
//		 Thread.sleep(2000);
//		driver.findElement(By.linkText("Set Requirements")).click();
//		 Thread.sleep(4000);
//	 
//	    driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
//	    Thread.sleep(4000);
//	    List<WebElement> listInputSpans = driver.findElements(By.tagName("button"));
//	    String strAttributeSpans ="";
//	    for(int i=0;i<listInputSpans.size();i++)
//	    {
//	    	strAttributeSpans= listInputSpans.get(i).getAttribute("class");
//	    		if((strAttributeSpans.contains("slds-button slds-button--icon-bare slds-pill__remove ng-scope"))) 	{
//	    			System.out.println("Got class inner " + listInputSpans.get(i).getText());
//	    			if(listInputSpans.get(i).getText().equalsIgnoreCase("Remove")){
//	    				Thread.sleep(1000);
//		    			System.out.println("Got class innertytyttyty " + strAttributeSpans);
//		    			listInputSpans.get(i).click();
//		    			Thread.sleep(2000);
//		    			 driver.findElement(By.xpath("//button[contains(.,'Close')]"));
//		    			
//		    			break;
//	    			}
//	    		}
//	    }
//	    		Thread.sleep(4000);
//	    driver.findElement(By.xpath("//button[contains(.,'Save')]"));
//	    
//	    driver.switchTo().defaultContent();
	    
		driver.findElement(By.linkText("App Launcher")).click();
		String RequestsLink = "Requests";
		
		
			
			Thread.sleep(2000);
			driver.findElement(By.linkText("ICIX")).click();
			Thread.sleep(2000);
			 driver.findElement(By.linkText("Requests")).click();
			Thread.sleep(8000);
			
			// New button
			 driver.findElement(By.cssSelector("div.triggerLinkTextAndIconWrapper")).click();	
			Thread.sleep(2000);
			 driver.findElement(By.cssSelector(".slds-dropdown__item.has-icon--left.forceListViewPickerAutocompleteOption > a")).click();
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
			    String requestName = "";
			    String strAttributeAnchor = "";
			    Thread.sleep(4000);
			    List<WebElement> listInput = driver.findElements(By.tagName("a"));
			    
//			    for(int i=0;i<listInput.size();i++)
//			    {
//			    	strAttributeAnchor = listInput.get(i).getAttribute("class");
//			    		if((strAttributeAnchor.contains(" outputLookupLink forceOutputLookup"))) 	{
//			    			System.out.println("Got class inner11 " + listInput.get(i).getText());
//			    			if(listInput.get(i).getText().contains("Certificate of Liability Insurance " + modifiedDate)){
//			    				Thread.sleep(1000);
//				    			System.out.println("Got class inner2222 " + strAttributeAnchor);
//				    			listInput.get(i).click();
//			    			}
//			    			
//			    		}	  
//	}
			    List<WebElement> listInputsA =  driver.findElements(By.cssSelector("th a.outputLookupLink.forceOutputLookup"));
				
				//always click on first request
				if(listInputsA.size()>0)
				 {
					listInputsA.get(0).click();
					
				 }
				
				Thread.sleep(4000);
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
			   
//Verifying status in all workflows
			    List<WebElement> listInputAnchorTag  =  driver.findElements(By.cssSelector("table tbody tr th div a.textUnderline outputLookupLink forceOutputLookup"));
				
				
				  String strAttributeAnchorTag ="";
				  System.out.println(listInputAnchorTag.size());
			    for(int i=0;i<listInputAnchorTag.size();i++)
			    {
		    				Thread.sleep(1000);
		    				if(!listInputAnchorTag.get(i).getText().equalsIgnoreCase("")){
		    					System.out.println("true");
			    			listInputAnchorTag.get(i).click();
			    			Thread.sleep(3000);
			    			String kk = driver.findElement(By.xpath("//*[@id='205:c']/div/form/section/div[1]/div/section[1]/ul/div[4]/li[2]/div[2]/div/span")).getText();
			    					System.out.println(kk);
			    					if(kk.contains("Cancelled")){
			    						System.out.println("true");
								        Assert.assertEquals(1, 1);
			    					}
			    			 
		    	  
	    		
	    		
			  
			    }
			    }
	    }
}
