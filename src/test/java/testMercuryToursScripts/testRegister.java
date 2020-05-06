package testMercuryToursScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testMercuryToursPages.pageRegister;



public class testRegister {
	
	WebDriver driver;
	pageRegister pnTour;
	
	@BeforeTest
	public void beforeTest() {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Software Testing\\Automation Testing\\Selenium Libraries\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		pnTour = new pageRegister(driver);
			
		driver.manage().deleteAllCookies();
			
		driver.navigate().to("http://newtours.demoaut.com/mercuryregister.php");
			
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	@Test
	public void validateDataEntry() throws InterruptedException {
		
		pnTour.getFirstName().sendKeys("Muhammad Enayetur");
		pnTour.getLastName().sendKeys("Rahman");
		pnTour.getPhone().sendKeys("2406330951");
		pnTour.getEmail().sendKeys("abc@gmail.com");
		pnTour.getAddrs1().sendKeys("22 sign view");
		pnTour.getAddrs2().sendKeys("Apt 2B");
		pnTour.getCity().sendKeys("La Plata");
		pnTour.getState().sendKeys("Maryland");
		pnTour.getPostcode().sendKeys("20646");
		
		Select ddSelect = new Select(pnTour.getCountry());
		ddSelect.selectByVisibleText("UNITED STATES");
		
		pnTour.getUserName().sendKeys("enayet");
		pnTour.getPassword().sendKeys("en110");
		pnTour.getConfirmPassword().sendKeys("en110");
		
		String actualUrl = driver.getCurrentUrl();
		String pageTitle = driver.getTitle();
		
		boolean isEnabled = pnTour.getSubmit().isEnabled();
		boolean isDisplayed = pnTour.getSubmit().isDisplayed();
		
		System.out.println("Current Url = "+actualUrl);
		System.out.println("Page Title = "+pageTitle);
		System.out.println("Is submit button enabled? "+isEnabled);
		System.out.println("Is submit button displayed? "+isDisplayed);
		
		Thread.sleep(3000);
		
	}
	
	@Test(priority = 2, dependsOnMethods = {"validateDataEntry"})
	public void validateSubmitButtonPresent() {
		System.out.println("This is validateSubmitButtonPresent");
		boolean displaySubmit = pnTour.getSubmit().isDisplayed();
		Assert.assertTrue(displaySubmit);
	}
	
	@Test(priority = 1, dependsOnMethods = {"validateDataEntry"})
	public void validateUrl() {
		System.out.println("This is validateUrl");
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://newtours.demoaut.com/mercuryregister.php";
		Assert.assertEquals(actualUrl, expectedUrl);
		
	}
	
	@AfterTest
	public void afterTest() {
		
		driver.quit();
		
	}


}
