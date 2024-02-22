package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewCartPage {
	WebDriver driver;

	public ViewCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean Verify_Text_Subscription() {
		return driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed();
	}

	public void Enter_Email_Address(String email) {
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
	}

	public void Click_On_Arrow_Button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	public void Click_Processed_to_Checkout_Button() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
	}

	public void Click_Register_Login_Button() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a/u[text()='Register / Login']")).click();
	}

	public void Click_On_Here_Option() {
		driver.findElement(By.xpath("//a[@href='/products']")).click();
	}
	
	public void Click_On_Remove_Product_From_Cart() {
		driver.findElement(By.xpath("//a[@class='cart_quantity_delete']")).click();
	}
	
	public boolean Verify_Cart_Is_Empty() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(By.xpath("//p//b[text()='Cart is empty!']")).isDisplayed();
	}
	
	public boolean Verify_Product_Available_In_table() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(By.xpath("//table[@id='cart_info_table']/tbody/tr[1]")).isDisplayed();
	}

}
