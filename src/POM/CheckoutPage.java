package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean Verify_Address_Details() {
		return driver.findElement(By.xpath("//h2[text()='Address Details']")).isDisplayed();
	}

	public boolean Verify_Review_YourOrder() {
		return driver.findElement(By.xpath("//h2[text()='Review Your Order']")).isDisplayed();
	}

	public void Enter_Description_In_Comment_Text_Area() {
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("All is ok");
	}

	public void Click_Place_Order() {
		driver.findElement(By.xpath("//a[@href='/payment']")).click();
	}
	
	public boolean Verify_DELIVERY_Address_Details(String address) {
		return driver.findElement(By.xpath("(//li[contains(text(),'"+address+"')])[1]")).isDisplayed();
	}
	
	public boolean Verify_Billing_Address_Details(String address) {
		return driver.findElement(By.xpath("(//li[contains(text(),'"+address+"')])[2]")).isDisplayed();
	}

}
