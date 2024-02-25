package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Account_Information_Page {
	 WebDriver driver;
	public Account_Information_Page(WebDriver driver) {
		this.driver=driver;
	}
	
	By gender= By.id("id_gender2");
	
	By Password= By.id("password");
	
	By DOB= By.xpath("(//option[@value='6'])[1]");
	
	By Month= By.xpath("//option[text()='May']");
	
	By Year= By.xpath("//option[text()='2015']");
	
	By Newsletter= By.id("newsletter");
	
	By Receive_Special_Offers= By.xpath("//label[text()='Receive special offers from our partners!']");
	
	By firstname= By.xpath("//input[@name='first_name']");
	
	By lastname= By.xpath("//input[@name='last_name']");
	
	By Company= By.id("company");
	
	By Address= By.id("address1");
	
	By India= By.xpath("//option[text()='India']");
	
	By state= By.id("state");
	
	By city= By.id("city");
	
	By zipcode= By.id("zipcode");
	
	By mobileNumber= By.id("mobile_number");
	
	By CreateAccount= By.xpath("//button[text()='Create Account']");

	public void Enter_Title() {
		driver.findElement(gender).click();
	}

	public void Enter_password1(String password1) {
		driver.findElement(Password).sendKeys(password1);
	}

	public void Enter_date_of_Birth() {
		driver.findElement(DOB).click();
	}

	public void Enter_Month_of_Birth() {
		driver.findElement(Month).click();
	}

	public void Enter_Year_of_Birth() {
		driver.findElement(Year).click();
	}

	public void Select_Checkbox_Sign_up_for_our_newsletter() {
		driver.findElement(Newsletter).click();
	}

	public void Select_Checkbox_Receive_special_offers_from_our_partners() {
		driver.findElement(Receive_Special_Offers).click();
	}

	public void Enter_Firstname(String Firstname) {
		driver.findElement(firstname).sendKeys(Firstname);
	}

	public void Enter_Lastname(String Lastname) {
		driver.findElement(lastname).sendKeys(Lastname);
	}

	public void Enter_Company(String company) {
		driver.findElement(Company).sendKeys(company);

	}

	public void Enter_address(String address) {
		driver.findElement(Address).sendKeys(address);
	}

	public void Select_Country() {
		driver.findElement(India).click();
	}

	public void Enter_State(String State) {
		driver.findElement(state).sendKeys(State);
	}

	public void Enter_City(String City) {
		driver.findElement(city).sendKeys(City);
	}
	public void Enter_Zipcode(String Zipcode) {
		driver.findElement(zipcode).sendKeys(Zipcode);
}
	public void Enter_Mobilenumber(String Mobileno) {
		driver.findElement(mobileNumber).sendKeys(Mobileno);
}
	public void Create_Account(){
		driver.findElement(CreateAccount).click();
	}
	

}
