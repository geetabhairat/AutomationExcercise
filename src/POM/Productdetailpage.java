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
	
	By All_Products= By.xpath("//h2[text()='All Products']");

	By Product_Name= By.xpath("//h2[text()='Blue Top']");
	
	By Category= By.xpath("//p[text()='Category: Women > Tops']");
	
	By Price= By.xpath("//span[text()='Rs. 500']");

	By Availability= By.xpath("//b[text()='Availability:']");
	
	By Condition= By.xpath("//b[text()='Condition:']");

	By Brand= By.xpath("//b[text()='Brand:']");
	
	By Button= By.xpath("//button[@type='button']");
	
	By View_Cart= By.xpath("//p//u[text()='View Cart']");
	
	By Quantity= By.xpath("//input[@id='quantity']");

	By Write_Your_Review= By.xpath("//ul/li/a[text()='Write Your Review']");
	
	By Name= By.id("name");
	
	By email= By.id("email");
	
	By Review= By.id("review");


	public void Verify_User_Is_Navigated_To_ALL_ProductPage_Successfully() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(All_Products).isDisplayed();
	}

	public void Click_On_View_Product() {
		WebElement element = driver.findElement(By.xpath("//a[@data-product-id='1']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public boolean verify_Product_Name() {
		return driver.findElement(Product_Name).isDisplayed();
	}

	public boolean verify_Category() {
		return driver.findElement(Category).isDisplayed();
	}

	public boolean verify_Price() {
		return driver.findElement(Price).isDisplayed();
	}

	public boolean verify_Avaibility() {
		return driver.findElement(Availability).isDisplayed();
	}

	public boolean verify_Condition() {
		return driver.findElement(Condition).isDisplayed();
	}

	public boolean verify_Brand() {
		return driver.findElement(Brand).isDisplayed();
	}

	public void Click_add_TO_Cart_Button() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(Button).click();
	}

	public void Click_On_View_Cart() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(View_Cart).click();
	}
	
	public void add_number_Of_Quantity(String number) {
		driver.findElement(Quantity).clear();
		driver.findElement(Quantity).sendKeys(number);
	}
	
	public boolean verify_Quantity(String Number) throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(By.xpath("//table[@id='cart_info_table']//tbody//td//button[text()='"+Number+"']")).isDisplayed();
	}
	
	public boolean verify_Write_Your_Review() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(Write_Your_Review).isDisplayed();
	}
	
	public void enter_Name(String name){
		driver.findElement(Name).sendKeys(name);
	}
	
	public void enter_Email(String mail){
		driver.findElement(email).sendKeys(mail);
	}
	
	public void enter_Review(String review){
		driver.findElement(email).sendKeys(review);
	}
	
	public void Click_On_Submit() {
		driver.findElement(Review).click();
	}
}