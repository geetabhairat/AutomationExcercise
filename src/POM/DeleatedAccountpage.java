package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleatedAccountpage {
	WebDriver driver;
	public DeleatedAccountpage(WebDriver driver) {
		this.driver=driver;
	}
	
	By Continue= By.xpath("//a[text()='Continue']");
	
	public void Countinue_Button(){
		driver.findElement(Continue).click();
	}

}
