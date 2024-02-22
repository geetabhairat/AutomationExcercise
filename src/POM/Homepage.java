package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
	WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
	}

	public String Username_Is_Visible() throws InterruptedException {
		Thread.sleep(1000);
		return driver.findElement(By.xpath("//a[text()=' Logged in as ']/b")).getText();
	}

	public void Click_On_Delete_Account() {
		driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();

	}

	public void Click_On_Logout() {
		driver.findElement(By.xpath("//a[text()=' Logout']")).click();

	}

	public void Click_On_Product_Button() {
		driver.findElement(By.xpath("//a[@href='/products']")).click();
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

	public void Click_On_Cart_Button() {
		driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
	}

	public boolean Verify_Category_Avaialble() {
		return driver.findElement(By.xpath("//h2[text()='Category']")).isDisplayed();
	}
	
	public void Click_On_Women_Link() {
		driver.findElement(By.xpath("//a[@href='#Women']")).click();
	}
	
	public void Click_On_Men_Link() {
		driver.findElement(By.xpath("//a[@href='#Men']")).click();
	}
	
	public void Click_On_category_Option(String option) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul/li/a[contains(text(),'"+option+"')]")).click();
	}
	
	public boolean Verify_Tet_Avaialble(String Text) throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(By.xpath("//h2[text()='"+Text+"']")).isDisplayed();
	}
	
	public void Click_On_Brand_Option(String Brand) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul/li/a[text()='"+Brand+"']")).click();
	}
	
	public void Click_On_Product_Details_Link() {
		driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
	}
	
	public void Click_On_Move_To_Top_Button() {
		driver.findElement(By.xpath("//a[@href='#top']")).click();
	}

}