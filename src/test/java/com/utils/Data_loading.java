package com.utils;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class Data_loading {

	String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	String DATE_FORMAT_DATE = "yyyy-MM-dd";
	String DATE_FORMAT_TODAY_DATE = "M/d/yyyy";
	String DATE_FORMAT_TODAY_DATE_TIME = "M/dd/yyyy hh:mm a";
	String DATE_FORMAT_TODAY_DATE_TIME2 = "M/d/yyyy hh:mm a";
	@SuppressWarnings("unused")
	private WebDriver driver;

	public void GeneralUtils(WebDriver driver) {
		this.driver = driver;
	}

	public String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
		// qa
	}

	@SuppressWarnings("unused")
	public Date nowSFDCformat() throws Exception {
		DateFormat formatter = null;
		Date convertedDate = null;
		String currentDate = now().substring(0, 10);
		String convertedDate2;
		// String currentDate = "2015-02-19 12:00:00";

		// Calendar cal = Calendar.getInstance();
		// formatter = new SimpleDateFormat(DATE_FORMAT_NOW);
		formatter = new SimpleDateFormat(DATE_FORMAT_DATE);

		// formatter = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		convertedDate = formatter.parse(currentDate);
		// System.out.println(convertedDate);
		return convertedDate;
	}

	public Date tomorrowSFDCformat() throws Exception {
		DateFormat formatter = null;
		Date convertedDate = null;

		formatter = new SimpleDateFormat(DATE_FORMAT_DATE);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String tommorrow = (String) (formatter.format(cal.getTime()));
		convertedDate = formatter.parse(tommorrow);
		// System.out.println(convertedDate);
		return convertedDate;
	}

	public Date todayPlusNumberOfDaysSFDCformat(int numberOfDays)
			throws Exception {
		DateFormat formatter = null;
		Date convertedDate = null;

		formatter = new SimpleDateFormat(DATE_FORMAT_DATE);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, numberOfDays); // number of days to add
		String tommorrow = (String) (formatter.format(cal.getTime()));
		convertedDate = formatter.parse(tommorrow);
		return convertedDate;
	}

	public String today_date() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_TODAY_DATE);
		return sdf.format(cal.getTime());
	}

	public String today_date_time() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_TODAY_DATE_TIME);
		return sdf.format(cal.getTime());
	}

	public Date today_date_time2() throws ParseException {
		// Calendar cal = Calendar.getInstance();
		// Date currentDate = cal.getTime();
		Date curDate = new Date();
		DateFormat sdf = new SimpleDateFormat(DATE_FORMAT_TODAY_DATE_TIME2,
				Locale.US);
		String currentDateTimeStr = sdf.format(curDate);
		Date currentDateTime = sdf.parse(currentDateTimeStr);

		return currentDateTime;
	}

	public String getTestRunStartTime() {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH.mm");
		Calendar cal = Calendar.getInstance();
		String dateTime = dateFormat.format(cal.getTime());

		return dateTime;
	}

	public String getTime() {
		DateFormat dateFormat = new SimpleDateFormat("HH.mm");
		Calendar cal = Calendar.getInstance();
		String dateTime = dateFormat.format(cal.getTime());

		return dateTime;

	}

	public String getProperties(String PropertyName) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			// / input = new
			// FileInputStream("/Users/jeff.radom/git/AutomationForSalesforce/AutomationforSalesforce/src/test/java/config/config.properties");
			input = new FileInputStream(getProjectDirectory()
					+ "Config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {

			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(PropertyName);
	}
	
	
	

	
	
	public String getRequestName(String RequestName) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			// / input = new
			// FileInputStream("/Users/jeff.radom/git/AutomationForSalesforce/AutomationforSalesforce/src/test/java/config/config.properties");
			input = new FileInputStream(getProjectDirectory()
					+ "Config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {

			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(RequestName);
	}

	public String getUserName(String username) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			// / input = new
			// FileInputStream("/Users/jeff.radom/git/AutomationForSalesforce/AutomationforSalesforce/src/test/java/config/config.properties");
			input = new FileInputStream(getProjectDirectory()
					+ "Config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {

			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(username);
	}

	public String getDATA(String Data) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			// / input = new
			// FileInputStream("/Users/jeff.radom/git/AutomationForSalesforce/AutomationforSalesforce/src/test/java/config/config.properties");
			input = new FileInputStream(getProjectDirectory()
					+ "Config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {

			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(Data);
	}

	public String getPassword(String password) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			// / input = new
			// FileInputStream("/Users/jeff.radom/git/AutomationForSalesforce/AutomationforSalesforce/src/test/java/config/config.properties");
			input = new FileInputStream(getProjectDirectory()
					+ "Config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {

			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(password);
	}

	public static String getProjectDirectory() {
		String projectDir = System.getProperty("user.dir")
				+ "/src/test/java/ConfigData/";
		// if (projectDir.contains("/AutomationSalesforce/"))
		// {
		// projectDir = projectDir + "src/test/java/Config/";
		// }
		// System.out.println("Using base directory as: " + projectDir);
		return projectDir;
	}

	// Added By sdei for fetching relationship type and status
	public String getRelationshipType(String Rtype) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			// / input = new
			// FileInputStream("/Users/jeff.radom/git/AutomationForSalesforce/AutomationforSalesforce/src/test/java/config/config.properties");
			input = new FileInputStream(getProjectDirectory()
					+ "Config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {

			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(Rtype);
	}

	// Added By sdei for fetching relationship type and status
	public String getRelationshipStatus(String Rstatus) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			// / input = new
			// FileInputStream("/Users/jeff.radom/git/AutomationForSalesforce/AutomationforSalesforce/src/test/java/config/config.properties");
			input = new FileInputStream(getProjectDirectory()
					+ "Config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {

			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(Rstatus);
	}

	public String generaterandomupc() {
		// randomNumbers = RandomStringUtils.randomNumeric(8);
		// UPCproduct = "1111" + randomNumbers;
		return "1111" + RandomStringUtils.randomNumeric(8);
	}
	

	public void LightiningView(WebDriver driver1) throws InterruptedException {
		
		if (driver1.findElements(By.xpath("//span[@id='userNavLabel']")).size() > 0) {

			driver1.findElement(By.id("userNavLabel")).click();
			driver1.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[3]"))
					.click();
			
			Thread.sleep(5000);
			driver1.findElement(By.cssSelector("div[class='icon-waffle']"))
					.click();
		} else  {
			Thread.sleep(5000);
			driver1.findElement(By.cssSelector("div[class='icon-waffle']"))
					.click();
		}
	}
	
	public void VerifyRequestStatus(WebDriver driver1,String StatusLink) throws InterruptedException {
			
		String RelatedList = getProperties("RelatedList");
		String RequestName = getProperties("RequestForApproval");
		
		RequestTab(driver1);
		    Thread.sleep(2000);
		    driver1.findElement(By.linkText(RequestName)).click();
		    Thread.sleep(2000);
		    driver1.findElement(By.cssSelector(RelatedList)).click();
		    Thread.sleep(5000);
		    //driver.findElement(By.cssSelector("th div .textUnderline.outputLookupLink.forceOutputLookup")).click();
		    driver1.findElement(By.linkText(RequestName)).click();
		    Thread.sleep(5000);
		    
		    if ( driver1.findElements(By.xpath(StatusLink)).size()>0)
		    {
		    	  Assert.assertEquals("1", "1");
		    }
		    else
		    {
		    	Assert.assertEquals("0", "1");
		    }
	}
	public void DeleteTPGroup(WebDriver driver) throws InterruptedException {
		String TPGroupName = getProperties("TPGroupNameDelete"); 
		String ListTypeDD = getProperties("ListTypeDD"); 
		String ListTypeAll = getProperties("ListTypeAll");
		String DeleteLink = getProperties("DeleteLink");
		String AppSelector = getProperties("AppSelector");
		String TPGroupTab = getProperties("TPGroupTab");
		
		driver.findElement(By.cssSelector(AppSelector)).click();	
		 
		Thread.sleep(3000);	
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(3000);	
		driver.findElement(By.xpath(TPGroupTab)).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(ListTypeDD)).click();	
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(ListTypeAll)).click();
		Thread.sleep(2000);
		System.out.println(TPGroupName);
		driver.findElement(By.linkText(TPGroupName)).click();
		Thread.sleep(2000);
		//driver.findElement(By.linkText(DeleteLink)).click();
		

		List<WebElement> listInputs =  driver.findElements(By.linkText(DeleteLink));
		
		if(listInputs.size()>0)
		 {
			Thread.sleep(3000);
			listInputs.get(0).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[contains(.,'Delete')]")).click();
			Thread.sleep(2000);
			String TPGMessage = driver.findElement(By.cssSelector(".toastMessage.slds-text-heading--small.forceActionsText")).getText();
			Assert.assertEquals(TPGMessage, "You deleted the trading partner group.");
		 }
		 else
		 {
			 Assert.assertEquals(0, 1);
		 }
	}
	
	public void VerifyViewTPGroup(WebDriver driver) throws InterruptedException {
	
		String ListTypeDD = getProperties("ListTypeDD"); 
		String ListTypeAll = getProperties("ListTypeAll");
		String AppSelector = getProperties("AppSelector");
		String TPGroupTab = getProperties("TPGroupTab");
		
		driver.findElement(By.cssSelector(AppSelector)).click();	
		 
		Thread.sleep(3000);	
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(3000);	
		driver.findElement(By.xpath(TPGroupTab)).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(ListTypeDD)).click();	
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(ListTypeAll)).click();
		Thread.sleep(2000);
		
		List<WebElement> listInputs =  driver.findElements(By.cssSelector("th a.outputLookupLink.forceOutputLookup"));
		
		
		if(listInputs.size()>0)
		 {
			listInputs.get(0).click();
			
		 }
		 else
		 {
			 Assert.assertEquals(0, 1);
		 }
	}

	
	public void VerifyEditTPGroup(WebDriver driver) throws InterruptedException {
		
		String ListTypeDD = getProperties("ListTypeDD"); 
		String ListTypeAll = getProperties("ListTypeAll");
		String AppSelector = getProperties("AppSelector");
		String TPGroupTab = getProperties("TPGroupTab");
		String TPGroupNameUpdate = getProperties("TPGroupNameUpdate");
		
		driver.findElement(By.cssSelector(AppSelector)).click();	
		 
		Thread.sleep(3000);	
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(3000);	
		driver.findElement(By.xpath(TPGroupTab)).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(ListTypeDD)).click();	
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(ListTypeAll)).click();
		Thread.sleep(2000);
	
		driver.findElement(By.cssSelector("th a.outputLookupLink.forceOutputLookup")).click();
		
		List<WebElement> listInputs =  driver.findElements(By.cssSelector(".nthOf.slds-button-group.oneActionsRibbon div[title=Edit]"));
		
		if(listInputs.size()>0)
		 {
			Thread.sleep(3000);
			listInputs.get(0).click();
			driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
			driver.findElement(By.id("txtGroupName")).clear();
			driver.findElement(By.id("txtGroupName")).sendKeys(TPGroupNameUpdate);
			driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
			
			Thread.sleep(5000);
			String TPGMessage = driver.findElement(By.cssSelector("div.slds-modal__content div.slds-m-around--medium p")).getText();
			
			Assert.assertEquals(TPGMessage, "Trading partner group created successfully");
			
			Thread.sleep(3000);
		 }
		else
		 {			
			 Assert.assertEquals(0, 1);
		 }
	}
	
	public void CreateTPGroup(WebDriver driver) throws InterruptedException {
		
		String TPGroupName = getProperties("TPGroupName"); 
		String AppSelector = getProperties("AppSelector");
		String TPGroupTab = getProperties("TPGroupTab");
		String TagType = getProperties("TagType");
		driver.findElement(By.cssSelector(AppSelector)).click();	
		 
		Thread.sleep(3000);	
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(3000);	
		driver.findElement(By.xpath(TPGroupTab)).click();
		Thread.sleep(3000);
		Thread.sleep(3000);
	
		// Creating New Trading Partner Group 				
		driver.findElement(By.cssSelector("div[title='New']")).click();	
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		
		driver.findElement(By.id("txtGroupName")).sendKeys(TPGroupName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(.,'"+TagType+"')]")).click();
		Thread.sleep(2000);
	    //driver.findElement(By.xpath("//a[@id='tab-scoped-1__item']")).click();
		//new Select(driver.findElement(By.id("ddlAttrStatus"))).selectByVisibleText("Pending");
		
		//Thread.sleep(2000);
		//driver.findElement(By.xpath(".//*[@id='tab-scoped-2__item']")).click();
		//new Select(driver.findElement(By.id("ddlAttrType"))).selectByVisibleText("Agent");
		//Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
		Thread.sleep(3000);
		
		String TPGMessage = driver.findElement(By.cssSelector("div.slds-modal__content div.slds-m-around--medium p")).getText();
		
		Assert.assertEquals(TPGMessage, "Trading partner group created successfully");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();
		
		driver.switchTo().defaultContent();
		
	}
	
	public void RequestTab(WebDriver driver1) throws InterruptedException {
		String AppSelector = getProperties("AppSelector");
		String ICIXLink = getProperties("ICIXLink");
		String RequestsLink = getProperties("RequestsLink");
		String ListTypeDD = getProperties("ListTypeDD");
		String ListTypeAll = getProperties("ListTypeAll");
		
		 driver1.findElement(By.cssSelector(AppSelector)).click();	
			
			Thread.sleep(2000);
			 driver1.findElement(By.linkText(ICIXLink)).click();
			Thread.sleep(2000);
			 driver1.findElement(By.linkText(RequestsLink)).click();
			Thread.sleep(3000);
			
			// New button
			 driver1.findElement(By.cssSelector(ListTypeDD)).click();	
			Thread.sleep(2000);
			 driver1.findElement(By.cssSelector(ListTypeAll)).click();
	}
	public void loginToPortal(String uname, String pwd, WebDriver driver)
			throws InterruptedException {

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("Login")).click();

	}
	
	public void CreateRelationship(WebDriver driver,String AccountName)
			throws InterruptedException {
		
		Thread.sleep(2000);
		//driver.findElement(By.linkText("Accounts")).click();
		//Thread.sleep(1000);
		driver.findElement(By.linkText("Recently Viewed")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("All Accounts")).click();	
		Thread.sleep(3000);

		driver.findElement(By.linkText(AccountName)).click();	
		driver.findElement(By.linkText("Trading Partner Relationships")).click();	
		Thread.sleep(3000);
		driver.findElement(By.linkText("New")).click();	
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		Thread.sleep(3000);
		driver.findElement(By.id("txt_UURelationship_Name")).sendKeys("test129");			
		new Select(driver.findElement(By.id("ddl_UURelationship_Type"))).selectByVisibleText("Audit Company");
		Thread.sleep(3000);
		driver.findElement(By.id("tab-PartnerRelationship-1__item")).click();
		Thread.sleep(3000);	    
	    driver.findElement(By.xpath("/html/body/div/partner-connect/div[2]/div/div/div[2]/div[2]/div/div/div/div/div/div[6]/div/div[1]/label/span")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("btn_UPRelationship_Save")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//message-dialog/div[2]/div/div/div[3]/button")).click();

	}
	
	public WebDriver openBrowser(WebDriver driver1)
	 {  
	 String baseUrl = "https://login.salesforce.com";
	  //driver = new FirefoxDriver();
	  //System.setProperty("webdriver.chrome.driver", "/Users/gurpinder.singh/Downloads/chromedriver");
	  ChromeDriverManager.getInstance().setup();
	  driver1 = new ChromeDriver();  
	  driver1.manage().window().maximize();
	  
	  driver1.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	  driver1.navigate().to(baseUrl);
	  return driver1;
	  
	  
	 }
}
