package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleatedAccountpage {
	WebDriver driver;
	public DeleatedAccountpage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void Countinue_Button(){
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
	}

}
