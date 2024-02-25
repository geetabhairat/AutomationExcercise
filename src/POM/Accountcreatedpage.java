package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Accountcreatedpage {
	WebDriver driver;

	public Accountcreatedpage(WebDriver driver) {
		this.driver = driver;
	}
	
	By Continue= By.xpath("//a[text()='Continue']");
	
	By Account_Created= By.xpath("//b[text()='Account Created!']");

	public void Click_On_Continue() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(Continue).click();
	}

	public boolean Verify_Account_Created() {
		return driver.findElement(Account_Created).isDisplayed();
	}
}
