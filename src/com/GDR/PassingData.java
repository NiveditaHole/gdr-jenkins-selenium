package com.GDR;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PassingData {
 
		 WebDriver driver;
		 
		 
		 //we will include the data provide name so i will 1st take data from method and then proccede
		 @Test(dataProvider="TestData")
		 public static void Login(String username , String password) throws Exception
		 {
		    		
		    System.setProperty("webdriver.chrome.driver","/home/niveditah/Downloads/chrome74/chromedriver");
			WebDriver driver= new ChromeDriver();	
			WebDriverWait wait= new WebDriverWait(driver, 100);
			driver.get("http://gdr-qa-dashboard-3-0.eastus.cloudapp.azure.com");
			driver.manage().window().maximize();
		    driver.findElement(By.xpath("//*[@id=\"emailadd\"]")).sendKeys(username);
			driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys(password);
		 	driver.findElement(By.xpath("/html/body/app-root/app-login/section/div/div[2]/form/mat-card-actions/button")).click();
		 	Thread.sleep(5000);
		    //System.out.println(driver.getTitle());
		    //all test are passed but we need to add cond login isd fail or successed
		    
		    //will use Assert which will take title and check. We can also include in assert if assert fail- message will be printed
		    Assert.assertTrue(driver.getPageSource().contains("Dashboard"), "User is not able to login- Incorrect credentials");
		    System.out.println("Page title is verified- User is able to login ");
	
             
		 }
		
		 
		 
		 //this way is not use ful when more data is there will use sheet in that case
		 //will create array twoo dim which will take two values 1 for username and 1 for password
		 //return type is object
		 @DataProvider(name="TestData")
		 public Object[][] PassData()
		 {
			Object[][] data= new Object[3][2]; 
			data[0][0]="nivedita@trinesis.com";
			data[0][1]="Trinesis_123";
			data[1][0]="avinash@trinesis.com";
			data[1][1]="Trinesis_123";
			data[2][0]="niveditah@trinesis.com";
			data[2][1]="Trinesis_123";
			return data;
			 
		 }
		 
		 
}
