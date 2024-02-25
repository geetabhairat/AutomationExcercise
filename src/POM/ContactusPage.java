package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactusPage {
	WebDriver driver;
	public ContactusPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By Get_In_Touch= By.xpath("//h2[text()='Get In Touch']");
	
	By Name= By.xpath("//input[@name='name']");
	
	By Email= By.xpath("//input[@Placeholder='Email']");
	
	By subject= By.xpath("//input[@placeholder='Subject']");
	
	By message= By.id("message");
	
	By upload_file= By.xpath("//input[@name='upload_file']");

	By submit= By.xpath("//input[@name='submit']");
	
	By submitted_successfully= By.xpath("//div[text()='Success! Your details have been submitted successfully.']");
	
	By Home_Button= By.xpath("//a[@class='btn btn-success']");

	public void  Verify_Get_In_Touch(){
		driver.findElement(Get_In_Touch).isDisplayed();
	}
	public void Enter_name(String name) {
		driver.findElement(Name).sendKeys(name);
	}
	public void Enter_email(String email) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(Email).sendKeys(email);
	}
	public void Enter_Subject(String Subject) {
		driver.findElement(subject).sendKeys(Subject);
	}
	public void Enter_Message(String Message) {
		driver.findElement(message).sendKeys(Message);
	}
	public void Upload_File(String File) throws InterruptedException {
		driver.findElement(upload_file).sendKeys(File);
	
	}
	public void Click_On_Submit() {
		driver.findElement(submit).click();
}
	public boolean verify_Success_Your_Details_Have_Been_Submitted_Successfully(){
		return driver.findElement(submitted_successfully).isDisplayed();
}
	public void Click_On_Home_Button() {
		driver.findElement(Home_Button).click();
}
}