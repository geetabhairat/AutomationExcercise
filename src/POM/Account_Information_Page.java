package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Account_Information_Page {
	 WebDriver driver;
	public Account_Information_Page(WebDriver driver) {
		this.driver=driver;
	}

	public void Enter_Title() {
		driver.findElement(By.id("id_gender2")).click();
	}

	public void Enter_password1(String password1) {
		driver.findElement(By.id("password")).sendKeys(password1);
	}

	public void Enter_date_of_Birth() {
		driver.findElement(By.xpath("(//option[@value='6'])[1]")).click();
	}

	public void Enter_Month_of_Birth() {
		driver.findElement(By.xpath("//option[text()='May']")).click();
	}

	public void Enter_Year_of_Birth() {
		driver.findElement(By.xpath("//option[text()='2015']")).click();
	}

	public void Select_Checkbox_Sign_up_for_our_newsletter() {
		driver.findElement(By.id("newsletter")).click();
	}

	public void Select_Checkbox_Receive_special_offers_from_our_partners() {
		driver.findElement(By.xpath("//label[text()='Receive special offers from our partners!']")).click();
	}

	public void Enter_Firstname(String Firstname) {
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(Firstname);
	}

	public void Enter_Lastname(String Lastname) {
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(Lastname);
	}

	public void Enter_Company(String Company) {
		driver.findElement(By.id("company")).sendKeys(Company);

	}

	public void Enter_address(String address) {
		driver.findElement(By.id("address1")).sendKeys(address);
	}

	public void Select_Country() {
		driver.findElement(By.xpath("//option[text()='India']")).click();
	}

	public void Enter_State(String State) {
		driver.findElement(By.id("state")).sendKeys(State);
	}

	public void Enter_City(String City) {
		driver.findElement(By.id("city")).sendKeys(City);
	}
	public void Enter_Zipcode(String Zipcode) {
		driver.findElement(By.id("zipcode")).sendKeys(Zipcode);
}
	public void Enter_Mobilenumber(String Mobileno) {
		driver.findElement(By.id("mobile_number")).sendKeys(Mobileno);
}
	public void Create_Account(){
		driver.findElement(By.xpath("//button[text()='Create Account']")).click();
	}
	

}
