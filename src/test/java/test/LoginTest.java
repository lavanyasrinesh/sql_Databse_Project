package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	WebDriver driver;
	LoginPage loginpage;

	@BeforeMethod
	public void openBrowser() {
		driver=BrowserFactory.init();
		 loginpage =PageFactory.initElements(driver, LoginPage.class);
		}
	@Test
	public void gettingDataFromDatabase() throws Exception {
		loginpage.login_textbox_field(LoginPage.gettingDataFromDatabase("username"));
		loginpage.password_textbox_field(LoginPage.gettingDataFromDatabase("password"));
		loginpage.cliking_on_submit_button();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
