package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
	WebDriver driver;
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Enter_name_on_card(String name) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys(name);
	}
	
	public void Enter_Number(String number) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys(number);
	}
	
	public void Enter_CVV(String cvc) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys(cvc);
	}
	
	public void Enter_Expiry_month(String month) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys(month);
	}
	
	public void Enter_Expiry_Year(String Year) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys(Year);
	}
	
	public void Click_On_Pay_And_Confirm_Order() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Pay and Confirm Order']")).click();
	}
	
	public void Click_On_Download_Invoice() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Download Invoice']")).click();
	}

}
