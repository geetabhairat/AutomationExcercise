package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestcasesPage {
	WebDriver driver;
	public TestcasesPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By Test_Cases= By.xpath("//a[text()=' Test Cases']");

	
	public void Click_On_Testcase_Button(){
		driver.findElement(Test_Cases).click();
	}
}
