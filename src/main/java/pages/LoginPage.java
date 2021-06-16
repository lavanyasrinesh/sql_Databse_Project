package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@id ='username']")
	WebElement username;
	@FindBy(how = How.XPATH, using = "//input[@id ='password']")
	WebElement password;
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Sign in')]")
	WebElement siginin_button;
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]")
	WebElement dahboardpage;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Bank & Cash')]")
	WebElement Bank_Cash_Field;

	public void login_textbox_field(String name) {
		username.sendKeys(name);
	}

	public void password_textbox_field(String pass_word) {
		password.sendKeys(pass_word);
	}
	public void cliking_on_submit_button() {
		siginin_button.click();
	}

	public  static String gettingDataFromDatabase(String columnname) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sqlurl="jdbc:mysql://localhost:3306/jan2021";
		String sqlusername = "root";
		String sqlpassword = "abc123";
		String query ="select * from jan2021";
		Connection con = DriverManager.getConnection(sqlurl, sqlusername, sqlpassword);
		Statement smt =con.createStatement();
		ResultSet rs=smt.executeQuery(query);
		while(rs.next()) {
			   return rs.getString(columnname);
		}
		return columnname;
		
	}

}
