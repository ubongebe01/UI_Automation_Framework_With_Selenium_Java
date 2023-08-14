package tests;



import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.login.loginPage;


@Listeners(listeners.TestNGListeners.class)
public class test {
    WebDriver driver = null;
    loginPage loginPgObj = new loginPage(driver);
    
    @BeforeTest
    public void SetUpTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

@Test(priority=0)
public void loginTest() throws InterruptedException {
	
    loginPage loginPgObj = new loginPage(driver);
        
        // navigate to the SwagLabs homepage, populate the username and password fields,
        // and then click on the login button
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        loginPgObj.sendUsername("standard_user");
        loginPgObj.sendPassword("secret_sauce");
        loginPgObj.clicklogin();
        Thread.sleep(3000);
        
      //test assertion for scenario 1
		 
      	Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Swag Labs");
      	assertTrue(verifyTitle);
}
      	
      	//scenario two: select items into the chart and click the chart
@SuppressWarnings("deprecation")
@Test(priority=1)

public void chartTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      	driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
      	driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
      	driver.findElement(By.xpath("//*[@id=\'shopping_cart_container\']/a")).click();
      	
      	 //test assertion for scenario 2
      	Boolean verifyTitle2 = driver.getTitle().equalsIgnoreCase("Swag Labs");
      	assertTrue(verifyTitle2);
}
      	
      //scenario three: click on checkout to check out to payment page
@Test(priority=2)
	public void checkoutTest() throws InterruptedException {
  		Thread.sleep(3000);
      	driver.findElement(By.id("checkout")).click();
      	Thread.sleep(2000);
   	 //test assertion for scenario 3
      	Boolean verifyTitle3 = driver.getTitle().equalsIgnoreCase("Swag Labs");
      	assertTrue(verifyTitle3);
	}
      	
      //scenario four: fill the checkout and continue to checkout
@SuppressWarnings("deprecation")
@Test(priority=3)

	public void checkoutformTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      	driver.findElement(By.id("first-name")).sendKeys("Ubong");
      	Thread.sleep(2000);
      	driver.findElement(By.id("last-name")).sendKeys("Udoakaebe");
      	Thread.sleep(2000);
      	driver.findElement(By.id("postal-code")).sendKeys("000000");
      	Thread.sleep(2000);
      	driver.findElement(By.id("continue")).click();
    	Thread.sleep(2000);
      	
      //test assertion for scenario 4
      	Boolean verifyTitle4 = driver.getTitle().equalsIgnoreCase("Swag Labs");
      	assertTrue(verifyTitle4);
      	
	
      	
   
	}   	
      //click on the finish button the complete the buying process
@SuppressWarnings("deprecation")
@Test(priority=4)

	public void buyingcompleteTest() throws InterruptedException {
	  	// scroll down the page and click on finish
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 		JavascriptExecutor scroll = (JavascriptExecutor)driver;
 		scroll.executeScript("window.scrollTo(0, document.body.scrollHeight)");
 		
 		Thread.sleep(3000);
      	
		driver.findElement(By.id("finish")).click();
      	
      	Thread.sleep(3000);
      //test assertion for scenario 5
      	Boolean verifyTitle5 = driver.getTitle().equalsIgnoreCase("Swag Labs");
      	assertTrue(verifyTitle5); 	   
    }

@AfterTest
	public void TearDownTest() {
	driver.close();
	
}

}


