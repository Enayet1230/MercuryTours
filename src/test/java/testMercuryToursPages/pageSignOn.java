package testMercuryToursPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageSignOn {
	
	WebDriver driver;
	
	public pageSignOn(WebDriver wd) {
		driver = wd;
	}

	public WebElement getUserName() {
		return driver.findElement(By.name("userName"));
	}
	
	public WebElement getPassword() {
		return driver.findElement(By.name("password"));
	}
	
	public WebElement getSubmit() {
		return driver.findElement(By.name("login"));
	}
	


}
