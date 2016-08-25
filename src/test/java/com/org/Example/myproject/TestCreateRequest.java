package com.org.Example.myproject;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import com.utils.Data_loading;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCreateRequest {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  String baseUrl;
  Data_loading guitils = new Data_loading();
  //String userName1 = guitils.getUserName("CustomerAdminRequestorUsername");
//	String password1 = guitils.getPassword("CustomerAdminRequestorPassword");
	String userName1 = guitils.getUserName("StandardUserRequestorUsername");
	String password1 = guitils.getPassword("StandardUserRequestorPassword");
	
	String RequestName = guitils.getRequestName("RequestForApproval");
	String ICIX_ID = guitils.getDATA("ICIX_ID");
	String ResponderName = guitils.getRequestName("ResponderName");
	
  
	@BeforeClass
	public void beforeClass() {		
		driver = guitils.openBrowser(driver);
	}
	
  @Test
  public void TestCreateRequest() throws Exception {
	   guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(8000);
		guitils.LightiningView(driver);
		Thread.sleep(5000);
		
		guitils.RequestTab(driver);
    Thread.sleep(3000);
    //driver.findElement(By.cssSelector("div[title='New']")).click();
    //driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
    driver.findElement(By.cssSelector("div[title=\"New\"]")).click();
    driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
    driver.findElement(By.id("requestName")).clear();
    Thread.sleep(1000);
    driver.findElement(By.id("requestName")).sendKeys(RequestName);
    Thread.sleep(1000);
    driver.findElement(By.id("tradingPartnerDropDown")).sendKeys(ResponderName);
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("h3.ng-binding")).click();
    //Thread.sleep(1000);
   // driver.findElement(By.id("tradingpartner")).click();
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("button.slds-button.slds-button--neutral")).click();
    Thread.sleep(1000);
    driver.findElement(By.linkText("All")).click();
    Thread.sleep(1000);
    driver.findElement(By.cssSelector(".slds-col.slds-size--1-of-12.slds-checkbox--faux")).click();
  
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("div.slds-modal__footer.slds-modal__footer--directional > button.slds-button.slds-button--brand")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[4]")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("date")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[2]/button")).click();
    driver.findElement(By.xpath("//tr[4]/td[6]/span")).click();
    driver.findElement(By.id("comments")).clear();
    Thread.sleep(2000);
    driver.findElement(By.id("comments")).sendKeys("Test Automation");
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("button.slds-button.slds-button--brand")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > .slds-button.slds-button--brand")).click();
    Thread.sleep(2000);
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
