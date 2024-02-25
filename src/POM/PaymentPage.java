package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
	WebDriver driver;
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By name_on_card= By.xpath("//input[@name='name_on_card']");
	
	By card_number= By.xpath("//input[@name='card_number']");
	
	By CVC= By.xpath("//input[@name='cvc']");
	
	By expiry_month= By.xpath("//input[@name='expiry_month']");
	
	By expiry_year= By.xpath("//input[@name='expiry_year']");
	
	By Confirm_Order= By.xpath("//button[text()='Pay and Confirm Order']");
	
	By Download_Invoice= By.xpath("//a[text()='Download Invoice']");
	
	public void Enter_name_on_card(String name) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(name_on_card).sendKeys(name);
	}
	
	public void Enter_Number(String number) throws InterruptedException {
		driver.findElement(card_number).sendKeys(number);
	}
	
	public void Enter_CVV(String cvc) throws InterruptedException {
		driver.findElement(CVC).sendKeys(cvc);
	}
	
	public void Enter_Expiry_month(String month) throws InterruptedException {
		driver.findElement(expiry_month).sendKeys(month);
	}
	
	public void Enter_Expiry_Year(String Year) throws InterruptedException {
		driver.findElement(expiry_year).sendKeys(Year);
	}
	
	public void Click_On_Pay_And_Confirm_Order() throws InterruptedException {
		driver.findElement(Confirm_Order).click();
	}
	
	public void Click_On_Download_Invoice() throws InterruptedException {
		driver.findElement(Download_Invoice).click();
	}

}
