package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Addproductincartpage {
	WebDriver driver;

	public Addproductincartpage(WebDriver driver) {
		this.driver = driver;
	}
	
	By Add_To_Cart= By.xpath("//a[@class='btn btn-default add-to-cart']");
	
	By Continue_Shopping= By.xpath("//button[text()='Continue Shopping']");
	
	By Add_To_Cart_Second_Product= By.xpath("(//a[text()='Add to cart'])[3]");
	
	By View_cart= By.xpath("//a[@href='/view_cart']");
	
	By Description= By.xpath("//td[text()='Description']");

	public void Click_On_Add_To_Cart() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(Add_To_Cart).click();
	}

	public void Click_On_Continue_Shopping_Button() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(Continue_Shopping).click();
	}

	public void Click_On_Add_To_Cart_Second_Product() {
		driver.findElement(Add_To_Cart_Second_Product).click();
	}

	public void Click_On_View_Cart() {
		driver.findElement(View_cart).click();

	}

	public boolean Verify_Both_Products_Are_Added_To_Cart() {
		return driver.findElement(Description).isDisplayed();
	}
}