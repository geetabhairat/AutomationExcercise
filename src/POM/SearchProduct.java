package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchProduct {
	WebDriver driver;

	public SearchProduct(WebDriver driver) {
		this.driver = driver;
	}

	public void Enter_Product_Name_In_Search_Input(){
		driver.findElement(By.id("search_product")).sendKeys("Top");;
	}
	public void Click_Search_Button(){
		driver.findElement(By.id("submit_search")).click();
	}

	public boolean Verify_Searched_Products() throws InterruptedException {
		Thread.sleep(1000);
		return driver.findElement(By.xpath("//h2[text()='Searched Products']")).isDisplayed();
	}

}