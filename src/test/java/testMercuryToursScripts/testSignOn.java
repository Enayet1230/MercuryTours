package testMercuryToursScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testMercuryToursPages.pageSignOn;



public class testSignOn {
	
	WebDriver driver;
	pageSignOn snTour;
	
	@BeforeTest
	public void beforeTest() {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Software Testing\\Automation Testing\\Selenium Libraries\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		snTour = new pageSignOn(driver);
			
		driver.manage().deleteAllCookies();
			
		driver.navigate().to("http://newtours.demoaut.com/mercurysignon.php");
					
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	}
	
	@Test
	public void validateElementPresent() throws InterruptedException {
		
		WebElement userName = snTour.getUserName();
		boolean presentUserName = userName.isDisplayed();
		Reporter.log("Verifying user name textbox is present", true);
		if(presentUserName) {
			userName.sendKeys("Michel");
			Reporter.log("Entering Michel in the user name textbox", true);
		}
		
		WebElement password = snTour.getPassword();
		boolean presentPassword = password.isDisplayed();
		Reporter.log("Verifying password textbox is present", true);
		if(presentPassword) {
			password.sendKeys("sdde22");
			Reporter.log("Entering sdde22 in the password textbox", true);
		}
		
		Thread.sleep(2000);
		boolean presentSubmitButton = snTour.getSubmit().isDisplayed();
		Reporter.log("Verifying submit button is present", true);
		
		Assert.assertTrue(presentUserName);
		Assert.assertTrue(presentPassword);;
		Assert.assertTrue(presentSubmitButton);
	}
	
	@Test(dependsOnMethods = {"validateElementPresent"})
	public void validateSignOnNegative() throws InterruptedException {
		
		WebElement userName = snTour.getUserName();
		userName.clear();
		Reporter.log("Clear text in the user name textbox", true);
		userName.sendKeys("Rechard");
		Reporter.log("Entering Rechard in the user name textbox", true);
		
		WebElement password = snTour.getPassword();
		password.clear();
		Reporter.log("Clear text in the password textbox", true);
		password.sendKeys("mn980");
		Reporter.log("Entering mn980 in the password textbox", true);
		
		Thread.sleep(2000);
		
		snTour.getSubmit().click();
		Reporter.log("Click on submit button", true);
		
		String expectedUrl = "http://newtours.demoaut.com/mercurysignon.php";
		String actualUrl = driver.getCurrentUrl();
		Reporter.log("Read current url of the page", true);
		Reporter.log("Then compare the actual url with expected url", true);
		boolean result = actualUrl.contains(expectedUrl);
		
		Assert.assertTrue(result);
		
	}
	
	@AfterTest
	public void afterTest() {
		
		driver.quit();
	}


}
