package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login {
	
	public static class loginPage {
		
		WebDriver driver = null;
		
		By username_field = By.id("user-name");
		By password_field = By.id("password");
		By login_button = By.id("login-button");
		
		
		public loginPage (WebDriver driver) {
			
			this.driver = driver;
		}
		
		public void sendUsername(String username) {
			
			driver.findElement(username_field).sendKeys(username);
			
		}
		
		public void sendPassword(String Pw) {
			
			driver.findElement(password_field).sendKeys(Pw);
			
		}
		
		public void clicklogin() {
			
			driver.findElement(login_button).click();
			
		}
		
	
			
			

	}
}