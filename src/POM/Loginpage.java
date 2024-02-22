package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {

	WebDriver driver;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
	}

	public void Click_On_Signup_Loginbutton() {
		driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
	}

	public void Enter_name(String name) {
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
	}

	public void Enter_email(String email) {
		driver.findElement(By.xpath("(//input[@Placeholder='Email Address'])[2]")).sendKeys(email);
	}

	public void Click_On_Signup() {
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
	}

	public void verify_Login_To_Your_Account() {
		driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed();
	}

	public void Enter_Email_Address(String Email_Address) {
		driver.findElement(By.xpath("(//input[@Placeholder='Email Address'])")).sendKeys(Email_Address);
	}

	public void Enter_password(String password) {
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}

	public void Click_On_Login() {
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}

	public boolean verify_Your_Email_Or_password_Is_Incorrect_Error() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']")).isDisplayed();
	}

	public void verify_New_User_Signup() {
		driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();

	}

	public boolean verify_Email_Address_Already_Exist_Error() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(By.xpath("//p[text()='Email Address already exist!']")).isDisplayed();
	}
	public void Click_On_Contactus_Button(){
		driver.findElement(By.xpath("//a[text()=' Contact us']")).click();
	}
}