package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Accountcreatedpage {
	WebDriver driver;

	public Accountcreatedpage(WebDriver driver) {
		this.driver = driver;
	}

	public void Click_On_Continue() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
	}

	public boolean Verify_Account_Created() {
		return driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed();
	}
}
