package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewCartPage {
	WebDriver driver;

	public ViewCartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By Subscription= By.xpath("//h2[text()='Subscription']");
	
	By Email= By.xpath("//input[@type='email']");
	
	By Submit= By.xpath("//button[@type='submit']");
	
	By Proceed_To_Checkout= By.xpath("//a[text()='Proceed To Checkout']");
	
	By Register= By.xpath("//a/u[text()='Register / Login']");
	
	By products= By.xpath("//a[@href='/products']");
	
	By cart_quantity_delete= By.xpath("//a[@class='cart_quantity_delete']");
	
	By Cart_is_empty= By.xpath("//p//b[text()='Cart is empty!']");
	
	By Product_Available_In_table= By.xpath("//table[@id='cart_info_table']/tbody/tr[1]");

	public boolean Verify_Text_Subscription() {
		return driver.findElement(Subscription).isDisplayed();
	}

	public void Enter_Email_Address(String email) {
		driver.findElement(Email).sendKeys(email);
	}

	public void Click_On_Arrow_Button() {
		driver.findElement(Submit).click();

	}

	public void Click_Processed_to_Checkout_Button() throws InterruptedException {
		driver.findElement(Proceed_To_Checkout).click();
	}

	public void Click_Register_Login_Button() throws InterruptedException {
		driver.findElement(Register).click();
	}

	public void Click_On_Here_Option() {
		driver.findElement(products).click();
	}
	
	public void Click_On_Remove_Product_From_Cart() {
		driver.findElement(By.xpath("cart_quantity_delete")).click();
	}
	
	public boolean Verify_Cart_Is_Empty() throws InterruptedException {
		return driver.findElement(Cart_is_empty).isDisplayed();
	}
	
	public boolean Verify_Product_Available_In_table() throws InterruptedException {
		return driver.findElement(Product_Available_In_table).isDisplayed();
	}

}
