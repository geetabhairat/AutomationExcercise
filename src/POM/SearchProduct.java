package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchProduct {
	WebDriver driver;

	public SearchProduct(WebDriver driver) {
		this.driver = driver;
	}
	
	By Search_product= By.id("search_product");
	
	By Submit_search= By.id("submit_search");
	
	By Searched_Products= By.xpath("//h2[text()='Searched Products']");

	public void Enter_Product_Name_In_Search_Input(){
		driver.findElement(Search_product).sendKeys("Top");;
	}
	public void Click_Search_Button(){
		driver.findElement(Submit_search).click();
	}

	public boolean Verify_Searched_Products() throws InterruptedException {
	return driver.findElement(Searched_Products).isDisplayed();
	}

}