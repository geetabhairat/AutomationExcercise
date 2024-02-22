package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactusPage {
	WebDriver driver;
	public ContactusPage(WebDriver driver) {
		this.driver=driver;
	}
	public void  Verify_Get_In_Touch(){
		driver.findElement(By.xpath("//h2[text()='Get In Touch']")).isDisplayed();
	}
	public void Enter_name(String name) {
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
	}
	public void Enter_email(String email) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@Placeholder='Email']")).sendKeys(email);
	}
	public void Enter_Subject(String Subject) {
		driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys(Subject);
	}
	public void Enter_Message(String Message) {
		driver.findElement(By.id("message")).sendKeys(Message);
	}
	public void Upload_File(String File) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='upload_file']")).sendKeys(File);
	
	}
	public void Click_On_Submit() {
		driver.findElement(By.xpath("//input[@name='submit']")).click();
}
	public boolean verify_Success_Your_Details_Have_Been_Submitted_Successfully(){
		return driver.findElement(By.xpath("//div[text()='Success! Your details have been submitted successfully.']")).isDisplayed();
}
	public void Click_On_Home_Button() {
		driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
}
}