package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Productdetailpage {
	WebDriver driver;

	public Productdetailpage(WebDriver driver) {
		this.driver = driver;
	}

	public void Verify_User_Is_Navigated_To_ALL_ProductPage_Successfully() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h2[text()='All Products']")).isDisplayed();
	}

	public void Click_On_View_Product() {
		WebElement element = driver.findElement(By.xpath("//a[@data-product-id='1']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public boolean verify_Product_Name() {
		return driver.findElement(By.xpath("//h2[text()='Blue Top']")).isDisplayed();
	}

	public boolean verify_Category() {
		return driver.findElement(By.xpath("//p[text()='Category: Women > Tops']")).isDisplayed();
	}

	public boolean verify_Price() {
		return driver.findElement(By.xpath("//span[text()='Rs. 500']")).isDisplayed();
	}

	public boolean verify_Avaibility() {
		return driver.findElement(By.xpath("//b[text()='Availability:']")).isDisplayed();
	}

	public boolean verify_Condition() {
		return driver.findElement(By.xpath("//b[text()='Condition:']")).isDisplayed();
	}

	public boolean verify_Brand() {
		return driver.findElement(By.xpath("//b[text()='Brand:']")).isDisplayed();
	}

	public void Click_add_TO_Cart_Button() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
	}

	public void Click_On_View_Cart() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p//u[text()='View Cart']")).click();
	}
	
	public void add_number_Of_Quantity(String number) {
		driver.findElement(By.xpath("//input[@id='quantity']")).clear();
		driver.findElement(By.xpath("//input[@id='quantity']")).sendKeys(number);
	}
	
	public boolean verify_Quantity(String Number) throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(By.xpath("//table[@id='cart_info_table']//tbody//td//button[text()='"+Number+"']")).isDisplayed();
	}
	
	public boolean verify_Write_Your_Review() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(By.xpath("//ul/li/a[text()='Write Your Review']")).isDisplayed();
	}
	
	public void enter_Name(String name){
		driver.findElement(By.id("name")).sendKeys(name);
	}
	
	public void enter_Email(String mail){
		driver.findElement(By.id("email")).sendKeys(mail);
	}
	
	public void enter_Review(String review){
		driver.findElement(By.id("review")).sendKeys(review);
	}
	
	public void Click_On_Submit() {
		driver.findElement(By.id("button-review")).click();
	}
}