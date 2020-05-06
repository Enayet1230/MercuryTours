package testMercuryToursPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageRegister {
	
	WebDriver driver;
	
	public pageRegister(WebDriver wd) {
		driver = wd;
	}
	
	public WebElement getFirstName() {
		return driver.findElement(By.name("firstName"));
	}
	
	public WebElement getLastName() {
		return driver.findElement(By.name("lastName"));
	}
	
	public WebElement getPhone() {
		return driver.findElement(By.name("phone"));
	}
	
	public WebElement getEmail() {
		return driver.findElement(By.xpath("//*[@id=\"userName\"]"));
	}
	
	public WebElement getAddrs1() {
		return driver.findElement(By.name("address1"));
	}
	
	public WebElement getAddrs2() {
		return driver.findElement(By.name("address2"));
	}
	
	public WebElement getCity() {
		return driver.findElement(By.name("city"));
	}
	
	public WebElement getState() {
		return driver.findElement(By.name("state"));
	}
	
	public WebElement getPostcode() {
		return driver.findElement(By.name("postalCode"));
	}
	
	public WebElement getCountry() {
		return driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select"));
	}
	
	public WebElement getUserName() {
		return driver.findElement(By.name("email"));
	}
	
	public WebElement getPassword() {
		return driver.findElement(By.name("password"));
	}
	
	public WebElement getConfirmPassword() {
		return driver.findElement(By.name("confirmPassword"));
	}
	public WebElement getSubmit() {
		return driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[18]/td/input"));
	}

}
