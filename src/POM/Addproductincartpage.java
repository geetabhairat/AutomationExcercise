package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Addproductincartpage {
	WebDriver driver;

	public Addproductincartpage(WebDriver driver) {
		this.driver = driver;
	}

	public void Click_On_Add_To_Cart() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-default add-to-cart']")).click();
	}

	public void Click_On_Continue_Shopping_Button() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
	}

	public void Click_On_Add_To_Cart_Second_Product() {
		driver.findElement(By.xpath("(//a[text()='Add to cart'])[3]")).click();
	}

	public void Click_On_View_Cart() {
		driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

	}

	public boolean Verify_Both_Products_Are_Added_To_Cart() {
		return driver.findElement(By.xpath("//td[text()='Description']")).isDisplayed();
		// driver.findElement(By.xpath("(//a[@href='/product_details/1']")).isDisplayed();
		// return
		// driver.findElement(By.xpath("(//a[@href='/product_details/2']")).isDisplayed();
	}
}