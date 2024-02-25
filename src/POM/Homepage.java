package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
	WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
	}
	
	By Username_Visible = By.xpath("//a[text()=' Logged in as ']/b");
	
	By Delete_Account= By.xpath("//a[text()=' Delete Account']");
	
	By Logout= By.xpath("//a[text()=' Logout']");
	
	By Product_Button= By.xpath("//a[@href='/products']");
	
	By Subscription= By.xpath("//h2[text()='Subscription']");
	
	By Email= By.xpath("//input[@type='email']");
	
	By Submit= By.xpath("//button[@type='submit']");
	
	By View_cart= By.xpath("//a[@href='/view_cart']");
	
	By Category= By.xpath("//h2[text()='Category']");
	
	By Women= By.xpath("//a[@href='#Women']");
	
	By Men= By.xpath("//a[@href='#Men']");
	
	By Product_details= By.xpath("//a[@href='/product_details/1']");
	
	By Move_To_Top_Button= By.xpath("//a[@href='#top']");

	public String Username_Is_Visible() throws InterruptedException {
		Thread.sleep(1000);
		return driver.findElement(Username_Visible).getText();
	}

	public void Click_On_Delete_Account() {
		driver.findElement(Delete_Account).click();

	}

	public void Click_On_Logout() {
		driver.findElement(Logout).click();

	}

	public void Click_On_Product_Button() {
		driver.findElement(Product_Button).click();
	}

	public boolean Verify_Text_Subscription() {
		return driver.findElement(Subscription).isDisplayed();
	}

	public void Enter_Email_Address(String email) {
		driver.findElement(Email).sendKeys(email);
	}

	public void Click_On_Arrow_Button() {
		driver.findElement(Submit).click();

	}

	public void Click_On_Cart_Button() {
		driver.findElement(View_cart).click();
	}

	public boolean Verify_Category_Avaialble() {
		return driver.findElement(Category).isDisplayed();
	}
	
	public void Click_On_Women_Link() {
		driver.findElement(Women).click();
	}
	
	public void Click_On_Men_Link() {
		driver.findElement(Men).click();
	}
	
	public void Click_On_category_Option(String option) throws InterruptedException {
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
		driver.findElement(Product_details).click();
	}
	
	public void Click_On_Move_To_Top_Button() {
		driver.findElement(Move_To_Top_Button).click();
	}

}