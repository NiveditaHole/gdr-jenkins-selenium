package com.GDR;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import SSLibrary.UtilitySS;

public class Pickups  {
 WebDriver driver;
  

@Test
 public static void Test1() throws Exception
 {
    try
	{
    		
    System.setProperty("webdriver.chrome.driver","/home/niveditah/Downloads/chrome74/chromedriver");
	WebDriver driver= new ChromeDriver();	
	WebDriverWait wait= new WebDriverWait(driver, 100);
	driver.get("http://gdr-qa-dashboard-3-0.eastus.cloudapp.azure.com");
	driver.manage().window().maximize();
    driver.findElement(By.xpath("//*[@id=\"emailadd\"]")).sendKeys("avinash@trinesis.com");
	driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("Trinesis_123");
 	driver.findElement(By.xpath("/html/body/app-root/app-login/section/div/div[2]/form/mat-card-actions/button")).click();
 	
    //Take SS here
 	UtilitySS.CaptureScreenshots(driver, "LoginSuccessful");
 	//click on Pickup tab
	
 	WebElement LOgin;
 	LOgin= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarCollapse\"]/links/ul[1]/li[2]/a")));
 	LOgin.click();

 	
 	/* text present or not
 	if(driver.getPageSource().contains("213 pickup"))
 	{
 		System.out.println("Text is present");
 		}else
 		{
 		System.out.println("Text is absent");
       }
 	*/
 	
     //Add filter 
    //driver.findElement(By.xpath("/html/body/app-root/app-pickups/div/div[2]/div[1]/div[3]/button[3]/span")).click();
    LOgin= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-pickups/div/div[2]/div[1]/div[3]/button[3]/span")));
    LOgin.click();
    
    /*
	//Input Request Id
 	driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-pickupsfilter/div[1]/div/div[1]/div/input")).sendKeys("4591");
    //implicit wait
 	driver.manage().timeouts().implicitlyWait(20,TimeUnit.MINUTES);
 	//Apply
 	driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-pickupsfilter/div[2]/button[1]")).click(); 
 
 	
 	//TAKE SS here
 	UtilitySS.CaptureScreenshots(driver, "RequestIdFilter");
 	//Reset
 	driver.findElement(By.xpath("/html/body/app-root/app-pickups/div/div[2]/div[1]/div[3]/button[2]")).click();
 	Thread.sleep(3000);
 	//details 
 	
 	driver.findElement(By.xpath("/html/body/app-root/app-pickups/div/div[2]/div[2]/table/tbody/tr[1]/td[11]/button[1]")).click();
 	Thread.sleep(2000);
    //Scrolling down for NP dropdown
 	JavascriptExecutor je1 =(JavascriptExecutor)driver;
    WebElement element1 = driver.findElement(By.xpath("/html/body/app-root/app-pickup-details/div/div[4]/mat-card/div/div[8]/div/div[1]/div/div/mat-form-field/div"));
    je1.executeScript("arguments[0].scrollIntoView(true);", element1);
 	
    //Drodfdown to select NP 
    driver.manage().timeouts().implicitlyWait(100,TimeUnit.MINUTES);
    Select NPDropdown= new Select(driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]")));
 	NPDropdown.selectByIndex(1);
 	Thread.sleep(2000);
    
    // Scrolling up for driver
	JavascriptExecutor je2 =(JavascriptExecutor)driver;
    WebElement element2 = driver.findElement(By.xpath("/html/body/app-root/app-pickup-details/div/div[4]/mat-card/div/div[3]/div/div[2]/mat-form-field/div"));
    je2.executeScript("arguments[0].scrollIntoView(true);", element2);
    Thread.sleep(2000);Thread.sleep(2000);
 	
 	//Dropdown Driver select
    driver.manage().timeouts().implicitlyWait(100,TimeUnit.MINUTES);
 	Select DriverDD= new Select(driver.findElement(By.xpath("//*[@id=\"mat-input-14\"]")));
 	DriverDD.selectByIndex(1);
    Thread.sleep(3000);
    	
    // Scrolling up for track
    JavascriptExecutor je3 =(JavascriptExecutor)driver;
    WebElement track = driver.findElement(By.xpath("/html/body/app-root/app-pickup-details/div/div[2]/div/button"));
    je3.executeScript("arguments[0].scrollIntoView(true);", track);
    Thread.sleep(2000);
    
 	// status dropdown
    driver.manage().timeouts().implicitlyWait(100,TimeUnit.MINUTES);
 	Select ChangeStatus= new Select(driver.findE/html/body/app-root/app-pickups/div/div[2]/div[1]/div[3]/button[3]lement(By.xpath("//*[@id=\"mat-input-13\"]")));
 	
 	ChangeStatus.selectByIndex(2);
 	Thread.sleep(2000);
 	driver.switchTo().alert().accept();
 	
 	UtilitySS.CaptureScreenshots(driver, "Statuschanged");
 	
 	//track button
 	driver.findElement(By.xpath("/html/body/app-root/app-pickup-details/div/div[2]/div/button")).click();
 	
 	//view pickup
 	driver.findElement(By.xpath("/html/body/app-root/app-track-route-picked-up/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/button")).click();
 	
 	//track 
 	driver.findElement(By.xpath("/html/body/app-root/app-track-pickup-list/div/div/div[1]/div/div/button")).click();
 
 	//click on Pickup tab
 	driver.manage().timeouts().implicitlyWait(50,TimeUnit.MINUTES);
 	driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/links/ul[1]/li[2]/a")).click();

 	 //Reset filter
    driver.findElement(By.xpath("/html/body/app-root/app-pickups/div/div[2]/div[1]/div[3]/button[2]")).click();
   
 
 	//select filter 
    driver.findElement(By.xpath("/html/body/app-root/app-pickups/div/div[2]/div[1]/div[3]/button[3]/span")).click();
    */
    
    
    //Select value from dropdown Status
    driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
    Select Status= new Select(driver.findElement(By.xpath("//*[@id=\"mat-input-3\"]")));
 	Status.selectByVisibleText("Delivered");
 
 	//Apply
 	
 	 //driver.findElement(By.xpath("//*[@id=\"mat-dialog-1\"]/app-pickupsfilter/div[3]/button[1]")).click(); 
 	 WebElement Apply;
 	 Apply= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Apply')]")));
     Apply.click();
     Thread.sleep(3000);
   
    //Scrolling down for whole page
	JavascriptExecutor je =(JavascriptExecutor)driver;
    WebElement element = driver.findElement(By.xpath("/html/body/app-root/app-pickups/div/div[2]/div[2]/mat-paginator/div/div/div[1]"));
    je.executeScript("arguments[0].scrollIntoView(true);", element);
    UtilitySS.CaptureScreenshots(driver, "PickupFilterForStatus");
 	Thread.sleep(3000);
 	
    //Reset filter
    driver.findElement(By.xpath("/html/body/app-root/app-pickups/div/div[2]/div[1]/div[3]/button[2]")).click();
    Thread.sleep(3000);

 	//Select filter agn
 	driver.findElement(By.xpath("/html/body/app-root/app-pickups/div/div[2]/div[1]/div[3]/button[3]/span")).click();
 	Thread.sleep(2000);
 	//Select value from dropdown Clients
 	Select Clients= new Select(driver.findElement(By.xpath("//*[@id=\"mat-input-8\"]")));
 	Clients.selectByIndex(1);
 	//Apply
 
 	driver.findElement(By.xpath("//span[contains(text(), 'Apply')]")).click(); 
 	Thread.sleep(7000);
 	UtilitySS.CaptureScreenshots(driver, "ClientnameFilter");
 	//Reset filter
    driver.findElement(By.xpath("/html/body/app-root/app-pickups/div/div[2]/div[1]/div[3]/button[2]")).click();
    Thread.sleep(3000);
    
    //Select filter agn
    driver.findElement(By.xpath("/html/body/app-root/app-pickups/div/div[2]/div[1]/div[3]/button[3]/span")).click();
    Thread.sleep(2000);
    //Select value from dropdown NP
   	Select Recipient= new Select(driver.findElement(By.cssSelector("#mat-input-10")));
 	Thread.sleep(2000);
 	Recipient.selectByIndex(3);
   	//Recipient.selectByVisibleText("Broken silence");
   	//Apply 
   	Apply= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Apply')]")));
    Apply.click();
   	
   //driver.findElement(By.cssSelector("#mat-dialog-3 > app-pickupsfilter > div.mat-dialog-actions > button.Rectangle-Copy-12.mat-button")).click(); 
  	Thread.sleep(5000);
 	UtilitySS.CaptureScreenshots(driver, "RecipientFilter");
 	//Reset filter
 	Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/app-root/app-pickups/div/div[2]/div[1]/div[3]/button[2]")).click();
    Thread.sleep(3000);
    
    
    //Select filter in combination
    driver.findElement(By.xpath("/html/body/app-root/app-pickups/div/div[2]/div[1]/div[3]/button[3]/span")).click();
    //Select value from dropdown Status
    driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS); 	
    Select Status1= new Select(driver.findElement(By.xpath("//*[@id=\"mat-input-15\"]")));
 	Status1.selectByVisibleText("Delivered");
   	Thread.sleep(2000);
   	
    //Select value from dropdown Clients
   	Select Clients1= new Select(driver.findElement(By.xpath("//*[@id=\"mat-input-16\"]")));
   	Clients1.selectByVisibleText("Bojangles");
    driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS); 
   	Select Recipient1= new Select(driver.findElement(By.xpath("//*[@id=\"mat-input-17\"]")));
   	Recipient1.selectByVisibleText("Action ministries");
   	
   	driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS); 
	//Apply
   	driver.findElement(By.xpath("//span[contains(text(),'Apply')]")).click();
 	Thread.sleep(7000);
 	JavascriptExecutor je4 =(JavascriptExecutor)driver;
    WebElement element3 = driver.findElement(By.xpath("/html/body/app-root/app-pickups/div/div[2]/div[2]/mat-paginator/div/div/div[1]"));
    je.executeScript("arguments[0].scrollIntoView(true);", element3);
 	UtilitySS.CaptureScreenshots(driver, "FilterinCombination");
 	//Reset filter
 	Thread.sleep(4000);
 	driver.findElement(By.xpath("/html/body/app-root/app-pickups/div/div[2]/div[1]/div[3]/button[2]")).click();
 	Thread.sleep(3000);
 		
 	//Export
 	//driver.findElement(By.xpath("/html/body/app-root/app-pickups/div/div[2]/div[1]/div[3]/button[1]")).click();
  	
	
    }
	catch(Exception IllegalStateException)
	{
		System.out.println("exception is " +IllegalStateException.getMessage());
	}
	
	 
 }



}


