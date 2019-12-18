package SSLibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class UtilitySS {
	
	//WILL PASS DRIVER AS PARAMETER
	public static void CaptureScreenshots(WebDriver driver, String screenshotname)
	{
		try {
			//System.out.println("screenshot logic starts");
			TakesScreenshot ts1=(TakesScreenshot) driver;
			//scr and type of ss   
			File src = ts1.getScreenshotAs(OutputType.FILE);
			//coppying file from src to dest will use FileUtils class with CopyFile method with two arg src anad dest
			
			//FOR CREATING EACH TIME NEW NAME OF SS WILL take name each time
			FileUtils.copyFile(src, new File("./Screenshot/" +screenshotname+ ".png"));
			
		}
		catch (Exception e) {
			System.out.println("Exception while taking ss" +e.getMessage());
		
		}	
    
		
	}

	
	

}
