package com.GDR;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Clients {
	

	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
    System.setProperty("webdriver.chrome.driver","/home/niveditah/Downloads/chrome74/chromedriver");
    driver= new ChromeDriver();
    
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    
    driver.get("http://gdr-qa-dashboard-3-0.eastus.cloudapp.azure.com");
    driver.findElement(By.xpath("//*[@id=\"emailadd\"]")).sendKeys("avinash@trinesis.com");
	driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("Trinesis_123");
	driver.findElement(By.xpath("/html/body/app-root/app-login/section/div/div[2]/form/mat-card-actions/button")).click();
	WebElement ClientLink;
	WebDriverWait wait= new WebDriverWait(driver, 100);
	ClientLink= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#navbarCollapse > links > ul.navbar-nav.mr-auto > li:nth-child(3) > a")));
	ClientLink.click(); 
	
	
	}
    @Test(enabled=false)
	public void ClientnamePresent()
	{    
        // enter name and next step 
		//driver.findElement(By.xpath("/html/body/app-root/app-customers/div[1]/div[1]/button")).click();	
		driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-account-creation-dialog/div/button[1]")).click();

		//To check text present
		if(driver.getPageSource().contains("Please enter fields"))
		{
		System.out.println("validation is present for empty Client name");
		}
		else
		{
		System.out.println("No validation");
		
	    }
	}
    
    @Test(enabled=false)
    public void CreateFacility() throws InterruptedException
    {
    	//add new client button
    	driver.findElement(By.xpath("/html/body/app-root/app-customers/div[1]/div[1]/button")).click();	
    	Thread.sleep(2000);
    	
		driver.findElement(By.xpath("//input[@class='ng-untouched ng-pristine ng-invalid']")).sendKeys("TestGenericClient");
		Thread.sleep(2000);
		//next button- made x path
		driver.findElement(By.xpath("//span[@class='Save-for-Later-Copy']")).click();
    	//select client type
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	Select ClientType= new Select(driver.findElement(By.xpath("//*[@id=\"mat-input-3\"]")));
        ClientType.selectByIndex(0);
        WebElement typeF=ClientType.getFirstSelectedOption();
        String value=typeF.getText();
    	System.out.println("Client type selected " +value);
    	
    	
    	//select radio for FG/FR
        Select SelectFR = new Select(driver.findElement(By.xpath("//*[@id=\"mat-input-4\"]")));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		SelectFR.selectByVisibleText("Atlanta airport");
		WebElement FR=SelectFR.getFirstSelectedOption();
		String FRvalue=FR.getText();
		System.out.println("FR selected is " +FRvalue);
		
    		
		/* select fG dropdown 
    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    	Select SelectFG = new Select(driver.findElement(By.xpath("//*[@id=\"mat-input-4\"]")));
    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 

        */
    	//Select driver services
		
    	WebElement Goodr = driver.findElement(By.id("mat-radio-7-input"));
        // Check if radio button is selected by default
        if (Goodr.isSelected())
        {
        System.out.println("Goodr radio button is selected by default");
        }
        else
        {
        	Goodr.click();
        }
        //next
        
        //x path created
        driver.findElement(By.xpath("//*[@id='mat-radio-7-input']//following::button[1]")).click();
		//old x path driver.findElement(By.xpath("//*[@id=\"mat-dialog-1\"]/app-facility-account-dialog/div[4]/button[1]")).click();
		Thread.sleep(2000);
        
        //NEXT step of business detail
        driver.findElement(By.xpath("//input[@id='mat-input-5']")).sendKeys("34223");
        Thread.sleep(3000);
        
        //driver.findElement(By.xpath("//*[@id='mat-input-10']/following::button[1]")).click();
       // driver.findElement(By.cssSelector("#mat-dialog-2 > app-edit-business-dialog > div.mat-dialog-actions > button.Rectangle-Copy-12.mat-button > div.mat-button-ripple.mat-ripple")).click();
       // Thread.sleep(3000);
        // next button
        //if(driver.getPageSource().contains("Please enter fields"))
		//{
		//System.out.println("validation is present for business details");
	
        //}
        //else
        //{
          System.out.println("No validation");
          Thread.sleep(2000);
           driver.findElement(By.id("mat-input-6")).sendKeys("D Food Court");
           driver.findElement(By.id("mat-input-7")).sendKeys("D Food Court");
           driver.findElement(By.id("mat-input-8")).sendKeys("Atlanta");
           driver.findElement(By.id("mat-input-9")).sendKeys("GA");
           driver.findElement(By.id("mat-input-10")).sendKeys("34233");
           //next button
           driver.findElement(By.xpath("//input[@id='mat-input-10']/following::button[1]")).click();
           Thread.sleep(2000);
           //User details form
           driver.findElement(By.id("mat-input-11")).sendKeys("Jackson");
           driver.findElement(By.id("mat-input-12")).sendKeys("John");
           driver.findElement(By.id("mat-input-13")).sendKeys("sushmatri@gmail.coo");
           driver.findElement(By.id("mat-input-14")).sendKeys("67657567677");
           //driver.findElement(By.id("mat-input-14")).clear();
           Thread.sleep(2000);
           driver.findElement(By.id("mat-input-14")).sendKeys("67657567677");
           //next step
           driver.findElement(By.xpath("//input[@id='mat-input-14']/following::button[1]")).click();
           // menu page- skip	
           driver.findElement(By.className("Rectangle-Copy-13")).click();
       
           //done
           driver.findElement(By.xpath("//button[@class='Rectangle-Copy-11']")).click();   
         //delete newly created 
           driver.findElement(By.xpath("//span[@class='mat-button-wrapper']")).click();
           //driver.findElement(By.xpath("//span[contains(text(), ' Yes , Please Delete ')]")).click();
           //driver.findElement(By.xpath("//span[contains(text(), ' Cancel ')]")).click(); 
    }
    
     /*
    @Test
    public void EmailExist()
    {
    	
    	
    	driver.findElement(By.id("mat-input-11")).sendKeys("John");
    	driver.findElement(By.id("mat-input-12")).sendKeys("Marshal");
    	driver.findElement(By.id("mat-input-13")).sendKeys("niveditah@trinesis.com");
    	driver.findElement(By.id("mat-input-14")).sendKeys("3443");
    	driver.findElement(By.xpath("//*[@id=\"mat-dialog-5\"]/app-edituser/div[3]/button[1]")).click();
    	
    	if(driver.getPageSource().contains("Email already exist, please use another email."))
    	{
    		System.out.println("email id already present validation");
    		driver.findElement(By.id("mat-input-82")).clear();
    		driver.findElement(By.id("mat-input-82")).sendKeys("niveditah@gmail.com");
    		driver.findElement(By.xpath("//*[@id=\"mat-dialog-5\"]/app-edituser/div[3]/button[1]")).click();
    	}
    	
    	else {
    		driver.findElement(By.xpath("//*[@id=\"mat-dialog-5\"]/app-edituser/div[3]/button[1]")).click();
    	}
    	//menu selection page
    	driver.findElement(By.xpath("driver.findElement(By.xpath(\"//*[@id=\\\"mat-dialog-5\\\"]/app-edituser/div[3]/button[1]\")).click();")).click();
    	
    	
    	
    }*/
    @Test(enabled=true)
    public void CreateNP() throws InterruptedException
    {
    	//Add new client
    	driver.findElement(By.xpath("/html/body/app-root/app-customers/div[1]/div[1]/button")).click();	
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//input[@class='ng-untouched ng-pristine ng-invalid']")).sendKeys("TestNP");
		Thread.sleep(2000);
		//next button- made x path
		driver.findElement(By.xpath("//span[@class='Save-for-Later-Copy']")).click();
    	//select client type
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	Select ClientType= new Select(driver.findElement(By.xpath("//*[@id=\"mat-input-3\"]")));
        ClientType.selectByIndex(3);
        WebElement first_value=ClientType.getFirstSelectedOption();
        String value=first_value.getText();
    	System.out.println("Client type selected " +value);
    	//NEXT
    	driver.findElement(By.xpath("//button[@class='Rectangle-Copy-12 mat-button']")).click();
    	
    	//business details form
    	 driver.findElement(By.id("mat-input-4")).sendKeys("34223");
    	 driver.findElement(By.id("mat-input-5")).sendKeys("D Food Court");
         driver.findElement(By.id("mat-input-6")).sendKeys("D Food Court");
         driver.findElement(By.id("mat-input-7")).sendKeys("Atlanta");
         driver.findElement(By.id("mat-input-8")).sendKeys("GA");
         driver.findElement(By.id("mat-input-9")).sendKeys("34233");
         //next button
         driver.findElement(By.xpath("//input[@id='mat-input-9']/following::button[1]")).click();
         Thread.sleep(2000);
         //User details form
         driver.findElement(By.id("mat-input-10")).sendKeys("Jackson");
         driver.findElement(By.id("mat-input-11")).sendKeys("John");
         driver.findElement(By.id("mat-input-12")).sendKeys("NonprofitTest@gmail.co");
         driver.findElement(By.id("mat-input-13")).sendKeys("654654645654");
         Thread.sleep(2000);
         //next step
         driver.findElement(By.xpath("//input[@id='mat-input-13']/following::button[1]")).click();
         //done
         driver.findElement(By.xpath("//button[@class='Rectangle-Copy-11']")).click();    
         //delete newly created 
         driver.findElement(By.xpath("//span[@class='mat-button-wrapper']")).click();
    	 //yes delete
         //driver.findElement(By.xpath("//span[contains(text(), ' Yes , Please Delete ')]")).click();
    	
    }
	
	
    
}

