package util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
static WebDriver driver;
	
	
	public  static WebDriver init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver_new1.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
		return driver;
	}
	
	public  static void takeScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat("MMddyy_HHmmss");
		Date date = new Date();
		String label =format.format(date);
		String currentDirectory = System.getProperty("user.dir");
		FileUtils.copyFile(sourcefile, new File(currentDirectory +"/screenshot/" +label+".png"));
		
		
	}
	
	
}
