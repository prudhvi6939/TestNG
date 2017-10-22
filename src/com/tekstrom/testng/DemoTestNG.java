package com.tekstrom.testng;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class DemoTestNG

{
 
 public static RemoteWebDriver driver;
 public static String appURL = "http://automationpractice.com/index.php";
	@BeforeClass
	@Parameters({ "browser" })
  public void setUp(String browser) throws MalformedURLException {

  //System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
	// driver = new FirefoxDriver ();
	//driver.get("http://automationpractice.com");
		 driver = Browser.getDriver(browser);
  }
  
  @AfterClass
  public void aftmeth(){
	  
	  driver.quit();
	  
  }
  @Test
  public void TestLogin() {
	  System.out.println("Hello World");
	    driver.navigate().to(appURL);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.className("login")).click();
		driver.findElement( By.id("email")).sendKeys("prudhvi.kothapalli@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Selenium");
		driver.findElement(By.id("SubmitLogin")).click();
   }
  
  @Test 
  public void searchtshirt() {
	  //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.findElement(By.className("login")).click();
		//driver.findElement( By.id("email")).sendKeys("prudhvi.kothapalli@gmail.com");
		//driver.findElement(By.id("passwd")).sendKeys("Selenium");
		//driver.findElement(By.id("SubmitLogin")).click();
		WebElement ExWait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.id("search_query_top")));
		ExWait.sendKeys("T-Shirts");
		driver.findElement(By.name("submit_search")).submit();
  }
 /* 
  @Test 
  public void listtheprice(){
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.className("login")).click();
		driver.findElement( By.id("email")).sendKeys("prudhvi.kothapalli@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Selenium");
		driver.findElement(By.id("SubmitLogin")).click();
		WebElement ExWait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.id("search_query_top")));
		ExWait.sendKeys("T-Shirts");
		driver.findElement(By.name("submit_search")).submit();
		WebElement ExWait1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[1]/div/a[1]/img")));
		ExWait1.click();
		String amount = driver.findElement(By.id("our_price_display")).getText();
		System.out.println(amount);
  }
  @Test 
  public void addtocart(){
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.className("login")).click();
		driver.findElement( By.id("email")).sendKeys("prudhvi.kothapalli@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Selenium");
		driver.findElement(By.id("SubmitLogin")).click();
		WebElement ExWait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.id("search_query_top")));
		ExWait.sendKeys("T-Shirts");
		driver.findElement(By.name("submit_search")).submit();
		WebElement ExWait1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[1]/div/a[1]/img")));
		ExWait1.click();
		String amount = driver.findElement(By.id("our_price_display")).getText();
		System.out.println(amount);
		driver.findElement(By.id("add_to_cart")).click();
  }
  */
  
}
