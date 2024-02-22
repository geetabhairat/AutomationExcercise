package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestcasesPage {
	WebDriver driver;
	public TestcasesPage(WebDriver driver) {
		this.driver=driver;
	}
	public void Click_On_Testcase_Button(){
		driver.findElement(By.xpath("//a[text()=' Test Cases']")).click();
	}
}
