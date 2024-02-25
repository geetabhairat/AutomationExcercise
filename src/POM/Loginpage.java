package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {

	WebDriver driver;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
	}

	By Signup_Login = By.xpath("//a[text()=' Signup / Login']");

	By Name = By.xpath("//input[@name='name']");

	By Email = By.xpath("(//input[@Placeholder='Email Address'])[2]");

	By Signup = By.xpath("//button[text()='Signup']");

	By Login_To_Your_Account = By.xpath("//h2[text()='Login to your account']");

	By EmailAddress = By.xpath("//input[@Placeholder='Email Address']");

	By Password = By.xpath("//input[@name='password']");

	By Login = By.xpath("//button[text()='Login']");

	By password_Incorrect = By.xpath("//p[text()='Your email or password is incorrect!']");

	By New_Signup = By.xpath("//h2[text()='New User Signup!']");
	
	By already_exist = By.xpath("//p[text()='Email Address already exist!']");
	
	By Contact_Us = By.xpath("//a[text()=' Contact us']");

	public void Click_On_Signup_Loginbutton() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(Signup_Login).click();
	}

	public void Enter_name(String name) {
		driver.findElement(Name).sendKeys(name);
	}

	public void Enter_email(String email) {
		driver.findElement(Email).sendKeys(email);
	}

	public void Click_On_Signup() {
		driver.findElement(Signup).click();
	}

	public void verify_Login_To_Your_Account() {
		driver.findElement(Login_To_Your_Account).isDisplayed();
	}

	public void Enter_Email_Address(String Email_Address) {
		driver.findElement(EmailAddress).sendKeys(Email_Address);
	}

	public void Enter_password(String password) {
		driver.findElement(Password).sendKeys(password);
	}

	public void Click_On_Login() {
		driver.findElement(Login).click();
	}

	public boolean verify_Your_Email_Or_password_Is_Incorrect_Error() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(password_Incorrect).isDisplayed();
	}

	public void verify_New_User_Signup() {
		driver.findElement(New_Signup).isDisplayed();

	}

	public boolean verify_Email_Address_Already_Exist_Error() throws InterruptedException {
		return driver.findElement(already_exist).isDisplayed();
	}

	public void Click_On_Contactus_Button() {
		driver.findElement(Contact_Us).click();
	}
}