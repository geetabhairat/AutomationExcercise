package Test;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.Account_Information_Page;
import POM.Accountcreatedpage;
import POM.Addproductincartpage;
import POM.Applicationbasepage;
import POM.CheckoutPage;
import POM.ViewCartPage;
import POM.ContactusPage;
import POM.DeleatedAccountpage;
import POM.Homepage;
import POM.Loginpage;
import POM.PaymentPage;
import POM.TestcasesPage;
import POM.Productdetailpage;
import POM.SearchProduct;

public class A extends Applicationbasepage {
	private static final String action = null;
	WebDriver driver = new ChromeDriver();

	@Test(testName = "Register User", priority = 1)
	public void Registe_User() throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(new File("./Extensions/gighmmpiobklfepjocnamgkkbiglidom-5.18.0-Crx4Chrome.com.crx"));
		opt.setExperimentalOption("prefs", new HashMap<String, Object>() {
			{
				put("autofill.profile_enabled", false);
			}
		});
		opt.addArguments("--disable-save-password-bubble");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(10000);
		driver.get("http://automationexercise.com");
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String parentwindow = I1.next();
			String childwindow = I1.next();
			driver.switchTo().window(parentwindow);
		}
		loginpage = new Loginpage(driver);
		account_Information_Page = new Account_Information_Page(driver);
		accountcreatedpage = new Accountcreatedpage(driver);
		homepage = new Homepage(driver);
		deleatedAccountpage = new DeleatedAccountpage(driver);
		contactusPage = new ContactusPage(driver);
		testcasesPage = new TestcasesPage(driver);
		productdetailpage = new Productdetailpage(driver);
		searchProduct = new SearchProduct(driver);
		viewcartPage = new ViewCartPage(driver);
		addproductincartpage = new Addproductincartpage(driver);
		checkoutPage = new CheckoutPage(driver);
		paymentPage = new PaymentPage(driver);

		loginpage.Click_On_Signup_Loginbutton();
		loginpage.Enter_name("geeta");
		loginpage.Enter_email("geetabhairat@1238");
		loginpage.Click_On_Signup();
		account_Information_Page.Enter_Title();
		account_Information_Page.Enter_password1("Geeta@23");
		account_Information_Page.Enter_date_of_Birth();
		account_Information_Page.Enter_Month_of_Birth();
		account_Information_Page.Enter_Year_of_Birth();
		account_Information_Page.Select_Checkbox_Sign_up_for_our_newsletter();
		//Thread.sleep(1000);
		account_Information_Page.Select_Checkbox_Receive_special_offers_from_our_partners();
		account_Information_Page.Enter_Firstname("Geeta");
		account_Information_Page.Enter_Lastname("Bhairat");
		account_Information_Page.Enter_Company("Thinkmind");
		account_Information_Page.Enter_address("PUNE");
		account_Information_Page.Select_Country();
		account_Information_Page.Enter_State("MAHARASTRA");
		account_Information_Page.Enter_City("pune");
		account_Information_Page.Enter_Zipcode("411033");
		account_Information_Page.Enter_Mobilenumber("7378416678");
		account_Information_Page.Create_Account();

		accountcreatedpage.Click_On_Continue();
		String Expected_Name = "geeta";
		Assert.assertEquals(homepage.Username_Is_Visible(), Expected_Name);

		homepage.Username_Is_Visible();
		homepage.Click_On_Delete_Account();

		deleatedAccountpage.Countinue_Button();

	}

	@Test(testName = "Login User with correct email and password", priority = 2)
	public void Login_User_with_correct_email_and_password() throws InterruptedException {

		driver.get("https://automationexercise.com/");
		String Expected_Title = "Automation Exercise";

		Assert.assertEquals(driver.getTitle(), Expected_Title);
		loginpage.Click_On_Signup_Loginbutton();
		loginpage.verify_Login_To_Your_Account();
		loginpage.Enter_Email_Address("geetabhairat@123");
		loginpage.Enter_password("Geeta@23");
		loginpage.Click_On_Login();
		String Expected_Name = "geeta";
		Assert.assertEquals(homepage.Username_Is_Visible(), Expected_Name);
		homepage.Username_Is_Visible();
		// homepage.Click_On_Delete_Account();
		// deleatedAccountpage.Countinue_Button();
	}

	@Test(testName = "Login User with incorrect email and password", priority = 3)
	public void Login_User_with_incorrect_email_and_password() throws InterruptedException {
		homepage.Click_On_Logout();
		driver.get("https://automationexercise.com/");
		String Expected_Title = "Automation Exercise";
		Assert.assertEquals(driver.getTitle(), Expected_Title);
		loginpage.Click_On_Signup_Loginbutton();
		loginpage.verify_Login_To_Your_Account();
		loginpage.Enter_Email_Address("Geetabh@432");
		loginpage.Enter_password("Geeta@23kjhh");
		loginpage.Click_On_Login();

		Assert.assertTrue(loginpage.verify_Your_Email_Or_password_Is_Incorrect_Error());

	}

	@Test(testName = "Logout User", priority = 4)
	public void Logout_User() throws InterruptedException {
		
		driver.get("https://automationexercise.com/");
		String Expected_Title = "Automation Exercise";
		Assert.assertEquals(driver.getTitle(), Expected_Title);
		loginpage.Click_On_Signup_Loginbutton();
		loginpage.verify_Login_To_Your_Account();
		loginpage.Enter_Email_Address("geetabhairat@123");
		loginpage.Enter_password("Geeta@23");
		loginpage.Click_On_Login();
		String Expected_Name = "geeta";
		Assert.assertEquals(homepage.Username_Is_Visible(), Expected_Name);
		homepage.Username_Is_Visible();
		homepage.Click_On_Logout();
		String Expected_page = "Automation Exercise - Signup / Login";
		Assert.assertEquals(driver.getTitle(), Expected_page);
	}

	@Test(testName = "Register User with existing email", priority = 5)
	public void Register_User_With_Existing_Email() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
		String Expected_Title = "Automation Exercise";

		Assert.assertEquals(driver.getTitle(), Expected_Title);
		loginpage.Click_On_Signup_Loginbutton();
		loginpage.verify_New_User_Signup();
		loginpage.Enter_name("geeta");
		loginpage.Enter_email("geetabhairat@123");
		loginpage.Click_On_Signup();
		loginpage.verify_Email_Address_Already_Exist_Error();
	}

	@Test(testName = "Contact Us Form", priority = 6)
	public void Contact_Us_Form() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		String Expected_Title = "Automation Exercise";
		Assert.assertEquals(driver.getTitle(), Expected_Title);
		loginpage.Click_On_Contactus_Button();
		contactusPage.Verify_Get_In_Touch();
		contactusPage.Enter_name("Geeta");
		contactusPage.Enter_email("geetabhairat@12345");
		contactusPage.Enter_Subject("Math");
		contactusPage.Enter_Message("wrteugjgh");
		contactusPage.Upload_File("C:\\Users\\Vivek\\OneDrive\\Desktop\\a.txt");
		contactusPage.Click_On_Submit();
		Alert ale = driver.switchTo().alert();
		ale.accept();
		Assert.assertTrue(contactusPage.verify_Success_Your_Details_Have_Been_Submitted_Successfully());
		contactusPage.Click_On_Home_Button();
		String Expected_Home_Title = "Automation Exercise";
		Assert.assertEquals(driver.getTitle(), Expected_Home_Title);
	}

	@Test(testName = "Verify Test Cases Page", priority = 7)
	public void Verify_Test_Cases_Page() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		String Expected_Title = "Automation Exercise";
		Assert.assertEquals(driver.getTitle(), Expected_Title);
		testcasesPage.Click_On_Testcase_Button();
		//Thread.sleep(5000);
		System.out.println(driver.getTitle());
		String Expected_Title1 = "Automation Practice Website for UI Testing - Test Cases";
		Assert.assertEquals(driver.getTitle(), Expected_Title1);

	}

	@Test(testName = "Verify All Products and product detail page", priority = 8)
	public void Verify_All_Products_And_Product_Detail_Page() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		homepage.Click_On_Product_Button();
		//Thread.sleep(5000);
		String Expected_page = "Automation Exercise - All Products";
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), Expected_page);
		productdetailpage.Click_On_View_Product();
		Thread.sleep(5000);
		String Expected_page1 = "Automation Exercise - Product Details";
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), Expected_page1);
		Assert.assertTrue(productdetailpage.verify_Product_Name());
		Assert.assertTrue(productdetailpage.verify_Category());
		Assert.assertTrue(productdetailpage.verify_Price());
		Assert.assertTrue(productdetailpage.verify_Avaibility());
		Assert.assertTrue(productdetailpage.verify_Condition());
		Assert.assertTrue(productdetailpage.verify_Brand());

	}

	@Test(testName = "Search Product", priority = 9)
	public void Search_Product() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		String Expected_page = "Automation Exercise";
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), Expected_page);
		homepage.Click_On_Product_Button();
		//Thread.sleep(5000);
		String Expected_page1 = "Automation Exercise - All Products";
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), Expected_page1);
		searchProduct.Enter_Product_Name_In_Search_Input();
		searchProduct.Click_Search_Button();
		Assert.assertTrue(searchProduct.Verify_Searched_Products());
	}

	@Test(testName = "Verify Subscription in home page", priority = 10)
	public void Verify_Subscription_In_Home_Page() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		String Expected_page = "Automation Exercise";
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), Expected_page);
		Actions a = new Actions(driver);
		a.scrollToElement(driver.findElement(By.xpath("//h2[text()='Subscription']"))).build().perform();
		Assert.assertTrue(homepage.Verify_Text_Subscription());
		homepage.Enter_Email_Address("geetabhairat@1234");
		homepage.Click_On_Arrow_Button();
	}

	@Test(testName = "Verify Subscription in cart page", priority = 11)
	public void Verify_Subscription_In_Cart_Page() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		String Expected_page = "Automation Exercise";
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), Expected_page);
		homepage.Click_On_Cart_Button();
		Actions a = new Actions(driver);
		a.scrollToElement(driver.findElement(By.xpath("//h2[text()='Subscription']"))).build().perform();
		Assert.assertTrue(viewcartPage.Verify_Text_Subscription());
		viewcartPage.Enter_Email_Address("geetabhairat@1234");
		viewcartPage.Click_On_Arrow_Button();

	}

	@Test(testName = "Add product in cart", priority = 12)
	public void Add_Product_In_Cart() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		String Expected_page = "Automation Exercise";
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), Expected_page);
		homepage.Click_On_Product_Button();
		//Thread.sleep(5000);
		Actions a = new Actions(driver);
		//Thread.sleep(3000);
		a.scrollToElement(driver.findElement(By.xpath("//a[@data-product-id='4']"))).build().perform();
		driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
		WebElement element = driver.findElement(By.xpath("//a[@data-product-id='1']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		//Thread.sleep(1000);
		addproductincartpage.Click_On_Continue_Shopping_Button();
		a.scrollToElement(driver.findElement(By.xpath("//a[@data-product-id='4']"))).build().perform();
		driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
		WebElement element1 = driver.findElement(By.xpath("//a[@data-product-id='2']"));
		executor.executeScript("arguments[0].click();", element1);
		Thread.sleep(3000);
		productdetailpage.Click_On_View_Cart();
		//Thread.sleep(1000);
		addproductincartpage.Verify_Both_Products_Are_Added_To_Cart();

	}

	@Test(testName = "Verify Product quantity in Cart", priority = 13)
	public void Verify_Product_Quantity_In_Cart() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		String Expected_page = "Automation Exercise";
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), Expected_page);
		Actions a = new Actions(driver);
		a.scrollToElement(driver.findElement(By.xpath("//a[@data-product-id='4']"))).build().perform();
		productdetailpage.Click_On_View_Product(); 
		Thread.sleep(2000);
		productdetailpage.add_number_Of_Quantity("4");
		//Thread.sleep(1000);
		productdetailpage.Click_add_TO_Cart_Button();
		productdetailpage.Click_On_View_Cart();
		//Thread.sleep(3000);
		Assert.assertTrue(productdetailpage.verify_Quantity("4"));

	}

	@Test(testName = "Place Order: Register while Checkout", priority = 14)
	public void Place_Order_Register_while_Checkout() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		String Expected_page = "Automation Exercise";
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), Expected_page);
		Thread.sleep(5000);
		Actions a = new Actions(driver);
		//Thread.sleep(3000);
		a.scrollToElement(driver.findElement(By.xpath("//a[@data-product-id='4']"))).build().perform();
		driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
		WebElement element = driver.findElement(By.xpath("//a[@data-product-id='1']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		//Thread.sleep(3000);
		productdetailpage.Click_On_View_Cart();
		viewcartPage.Click_Processed_to_Checkout_Button();
		viewcartPage.Click_Register_Login_Button();
		loginpage.Enter_name("geeta");
		loginpage.Enter_email("geetabhairat@1");
		loginpage.Click_On_Signup();

		account_Information_Page.Enter_Title();
		account_Information_Page.Enter_password1("Geeta@23");
		account_Information_Page.Enter_date_of_Birth();
		account_Information_Page.Enter_Month_of_Birth();
		account_Information_Page.Enter_Year_of_Birth();
		account_Information_Page.Select_Checkbox_Sign_up_for_our_newsletter();
		//Thread.sleep(1000);
		account_Information_Page.Select_Checkbox_Receive_special_offers_from_our_partners();
		account_Information_Page.Enter_Firstname("Geeta");
		account_Information_Page.Enter_Lastname("Bhairat");
		account_Information_Page.Enter_Company("Thinkmind");
		account_Information_Page.Enter_address("PUNE");
		account_Information_Page.Select_Country();
		account_Information_Page.Enter_State("MAHARASTRA");
		account_Information_Page.Enter_City("pune");
		account_Information_Page.Enter_Zipcode("411033");
		account_Information_Page.Enter_Mobilenumber("7378416678");
		account_Information_Page.Create_Account();
		Assert.assertTrue(accountcreatedpage.Verify_Account_Created());
		accountcreatedpage.Click_On_Continue();
		// String Expected_Name = "geeta";
		//Thread.sleep(5000);
		homepage.Click_On_Cart_Button();
		viewcartPage.Click_Processed_to_Checkout_Button();
		//Thread.sleep(2000);
		Assert.assertTrue(checkoutPage.Verify_Address_Details());
		Assert.assertTrue(checkoutPage.Verify_Review_YourOrder());
		checkoutPage.Enter_Description_In_Comment_Text_Area();
		checkoutPage.Click_Place_Order();
		paymentPage.Enter_name_on_card("geeta");
		paymentPage.Enter_Number("654654654");
		paymentPage.Enter_CVV("456");
		paymentPage.Enter_Expiry_month("11");
		paymentPage.Enter_Expiry_Year("2026");
		paymentPage.Click_On_Pay_And_Confirm_Order();
		//Thread.sleep(2000);
		homepage.Click_On_Delete_Account();

	}

	@Test(testName = "Place Order: Register before Checkout", priority = 15)
	public void Place_Order_Register_before_Checkout() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		String Expected_page = "Automation Exercise";
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), Expected_page);
		Thread.sleep(5000);
		loginpage.Click_On_Signup_Loginbutton();
		loginpage.Enter_name("geeta");
		loginpage.Enter_email("geetabhairat@1");
		loginpage.Click_On_Signup();

		account_Information_Page.Enter_Title();
		account_Information_Page.Enter_password1("Geeta@23");
		account_Information_Page.Enter_date_of_Birth();
		account_Information_Page.Enter_Month_of_Birth();
		account_Information_Page.Enter_Year_of_Birth();
		account_Information_Page.Select_Checkbox_Sign_up_for_our_newsletter();
		Thread.sleep(1000);
		account_Information_Page.Select_Checkbox_Receive_special_offers_from_our_partners();
		account_Information_Page.Enter_Firstname("Geeta");
		account_Information_Page.Enter_Lastname("Bhairat");
		account_Information_Page.Enter_Company("Thinkmind");
		account_Information_Page.Enter_address("PUNE");
		account_Information_Page.Select_Country();
		account_Information_Page.Enter_State("MAHARASTRA");
		account_Information_Page.Enter_City("pune");
		account_Information_Page.Enter_Zipcode("411033");
		account_Information_Page.Enter_Mobilenumber("7378416678");
		account_Information_Page.Create_Account();
		Assert.assertTrue(accountcreatedpage.Verify_Account_Created());
		accountcreatedpage.Click_On_Continue();
		Actions a = new Actions(driver);
		//Thread.sleep(3000);
		a.scrollToElement(driver.findElement(By.xpath("//a[@data-product-id='4']"))).build().perform();
		driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
		WebElement element = driver.findElement(By.xpath("//a[@data-product-id='1']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// Thread.sleep(3000);
		//Thread.sleep(5000);
		productdetailpage.Click_On_View_Cart();
		viewcartPage.Click_Processed_to_Checkout_Button();
		Thread.sleep(2000);
		Assert.assertTrue(checkoutPage.Verify_Address_Details());
		Assert.assertTrue(checkoutPage.Verify_Review_YourOrder());
		checkoutPage.Enter_Description_In_Comment_Text_Area();
		checkoutPage.Click_Place_Order();
		paymentPage.Enter_name_on_card("geeta");
		paymentPage.Enter_Number("654654654");
		paymentPage.Enter_CVV("456");
		paymentPage.Enter_Expiry_month("11");
		paymentPage.Enter_Expiry_Year("2026");
		paymentPage.Click_On_Pay_And_Confirm_Order();
		//Thread.sleep(2000);
		homepage.Click_On_Delete_Account();
	}

	@Test(testName = "Place Order: Login before Checkout", priority = 16)
	public void Place_Order_Login_before_Checkout() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		String Expected_page = "Automation Exercise";
		System.out.println(driver.getTitle());
		loginpage.Click_On_Signup_Loginbutton();
		loginpage.Enter_Email_Address("geetabhairat@12");
		loginpage.Enter_password("Geeta@23");
		loginpage.Click_On_Login();
		Actions a = new Actions(driver);
		//Thread.sleep(3000);
		a.scrollToElement(driver.findElement(By.xpath("//a[@data-product-id='4']"))).build().perform();
		driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
		WebElement element = driver.findElement(By.xpath("//a[@data-product-id='1']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		//Thread.sleep(3000);
		//Thread.sleep(5000);
		productdetailpage.Click_On_View_Cart();
		viewcartPage.Click_Processed_to_Checkout_Button();
		//Thread.sleep(2000);
		Assert.assertTrue(checkoutPage.Verify_Address_Details());
		Assert.assertTrue(checkoutPage.Verify_Review_YourOrder());
		checkoutPage.Enter_Description_In_Comment_Text_Area();
		checkoutPage.Click_Place_Order();
		//Thread.sleep(5000);
		paymentPage.Enter_name_on_card("geeta");
		paymentPage.Enter_Number("654654654");
		paymentPage.Enter_CVV("456");
		paymentPage.Enter_Expiry_month("11");
		paymentPage.Enter_Expiry_Year("2026");
		paymentPage.Click_On_Pay_And_Confirm_Order();
		Thread.sleep(2000);
		// homepage.Click_On_Delete_Account();
	}

	@Test(testName = "Place Order: Register before Checkout", priority = 17)
	public void Remove_Products_From_Cart() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		String Expected_page = "Automation Exercise";
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), Expected_page);
		//Thread.sleep(5000);
		Actions a = new Actions(driver);
		//Thread.sleep(3000);
		a.scrollToElement(driver.findElement(By.xpath("//a[@data-product-id='4']"))).build().perform();
		driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
		WebElement element = driver.findElement(By.xpath("//a[@data-product-id='1']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		//Thread.sleep(5000);
		productdetailpage.Click_On_View_Cart();
		viewcartPage.Click_On_Remove_Product_From_Cart();
		Assert.assertTrue(viewcartPage.Verify_Cart_Is_Empty());

	}

	@Test(testName = "View Category Products", priority = 18)
	public void View_Category_Products() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		Assert.assertTrue(homepage.Verify_Category_Avaialble());
		homepage.Click_On_Women_Link();
		homepage.Click_On_category_Option("Dress");
		Assert.assertTrue(homepage.Verify_Tet_Avaialble("Women - Dress Products"));
		homepage.Click_On_Men_Link();
		homepage.Click_On_category_Option("Tshirts");
		Assert.assertTrue(homepage.Verify_Tet_Avaialble("Men - Tshirts Products"));

	}

	@Test(testName = "View & Cart Brand Products", priority = 19)
	public void View_And_Cart_Brand_Products() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		homepage.Click_On_Product_Button();
		Assert.assertTrue(homepage.Verify_Tet_Avaialble("Brands"));
		Actions a = new Actions(driver);
		//Thread.sleep(3000);
		a.scrollToElement(driver.findElement(By.xpath("//a[@data-product-id='4']"))).build().perform();
		homepage.Click_On_Brand_Option("Polo");
		Assert.assertTrue(homepage.Verify_Tet_Avaialble("Brand - Polo Products"));
		homepage.Click_On_Brand_Option("Madame");
		Assert.assertTrue(homepage.Verify_Tet_Avaialble("Brand - Madame Products"));

	}

	@Test(testName = "Search Products and Verify Cart After Login", priority = 20)
	public void Search_Products_And_Verify_Cart_After_Login() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		homepage.Click_On_Product_Button();
		Assert.assertTrue(homepage.Verify_Tet_Avaialble("All Products"));
		searchProduct.Enter_Product_Name_In_Search_Input();
		searchProduct.Click_Search_Button();
		Assert.assertTrue(searchProduct.Verify_Searched_Products());
		Actions a = new Actions(driver);
		//Thread.sleep(3000);
		a.scrollToElement(driver.findElement(By.xpath("//a[@data-product-id='7']"))).build().perform();
		driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
		WebElement element = driver.findElement(By.xpath("//a[@data-product-id='1']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		//Thread.sleep(5000);
		productdetailpage.Click_On_View_Cart();
		Assert.assertTrue(viewcartPage.Verify_Product_Available_In_table());
		loginpage.Click_On_Signup_Loginbutton();
		loginpage.Enter_Email_Address("geetabhairat@12");
		loginpage.Enter_password("Geeta@23");
		loginpage.Click_On_Login();
		homepage.Click_On_Cart_Button();
		Assert.assertTrue(viewcartPage.Verify_Product_Available_In_table());
	}

	@Test(testName = "Add review on product", priority = 21)
	public void Add_Review_On_Product() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		homepage.Click_On_Product_Button();
		Assert.assertTrue(homepage.Verify_Tet_Avaialble("All Products"));
		homepage.Click_On_Product_Details_Link();
		Assert.assertTrue(productdetailpage.verify_Write_Your_Review());
		productdetailpage.enter_Name("abcd");
		productdetailpage.enter_Email("abcd@gmail.com");
		productdetailpage.enter_Review("good");
		productdetailpage.Click_On_Submit();
	}

	@Test(testName = "Add to cart from Recommended items", priority = 22)
	public void Add_To_Cart_From_Recommended_Items() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		
		Actions a = new Actions(driver);
		//Thread.sleep(3000);
		a.scrollToElement(driver.findElement(By.xpath("(//a[@href='#recommended-item-carousel'])[1]"))).build()
				.perform();
		try {
			// driver.findElement(By.xpath("(//a[@data-product-id='1'])[3]")).click();
			WebElement element = driver.findElement(By.xpath("(//a[@data-product-id='1'])[3]"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			// driver.findElement(By.xpath("(//a[@data-product-id='4'])[3]")).click();
			WebElement element = driver.findElement(By.xpath("(//a[@data-product-id='4'])[3]"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		}
		productdetailpage.Click_On_View_Cart();
		Assert.assertTrue(viewcartPage.Verify_Product_Available_In_table());
	}

	@Test(testName = "Verify address details in checkout page", priority = 23)
	public void Verify_Address_Details_In_Checkout_Page() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		loginpage.Click_On_Signup_Loginbutton();
		loginpage.Enter_name("geeta");
		loginpage.Enter_email("geetanichal@1");
		loginpage.Click_On_Signup();

		account_Information_Page.Enter_Title();
		account_Information_Page.Enter_password1("Geeta@23");
		account_Information_Page.Enter_date_of_Birth();
		account_Information_Page.Enter_Month_of_Birth();
		account_Information_Page.Enter_Year_of_Birth();
		account_Information_Page.Select_Checkbox_Sign_up_for_our_newsletter();
		Thread.sleep(1000);
		account_Information_Page.Select_Checkbox_Receive_special_offers_from_our_partners();
		account_Information_Page.Enter_Firstname("Geeta");
		account_Information_Page.Enter_Lastname("Bhairat");
		account_Information_Page.Enter_Company("Thinkmind");
		account_Information_Page.Enter_address("PUNE");
		account_Information_Page.Select_Country();
		account_Information_Page.Enter_State("MAHARASTRA");
		account_Information_Page.Enter_City("pune");
		account_Information_Page.Enter_Zipcode("411033");
		account_Information_Page.Enter_Mobilenumber("7378416678");
		account_Information_Page.Create_Account();
		Assert.assertTrue(accountcreatedpage.Verify_Account_Created());
		accountcreatedpage.Click_On_Continue();
		Actions a = new Actions(driver);
		//Thread.sleep(3000);
		a.scrollToElement(driver.findElement(By.xpath("//a[@data-product-id='4']"))).build().perform();
		driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
		WebElement element = driver.findElement(By.xpath("//a[@data-product-id='1']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// Thread.sleep(3000);
		//Thread.sleep(5000);
		productdetailpage.Click_On_View_Cart();
		viewcartPage.Click_Processed_to_Checkout_Button();
		Thread.sleep(2000);
		Assert.assertTrue(checkoutPage.Verify_Address_Details());
		Assert.assertTrue(checkoutPage.Verify_Review_YourOrder());
		Assert.assertTrue(checkoutPage.Verify_DELIVERY_Address_Details("pune MAHARASTRA"));
		Assert.assertTrue(checkoutPage.Verify_Billing_Address_Details("pune MAHARASTRA"));
		//Thread.sleep(2000);
		homepage.Click_On_Delete_Account();
	}

	@Test(testName = "Download Invoice after purchase order", priority = 24)
	public void Download_Invoice_After_Purchase_Order() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		String Expected_page = "Automation Exercise";
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), Expected_page);
		//Thread.sleep(5000);
		Actions a = new Actions(driver);
		//Thread.sleep(3000);
		a.scrollToElement(driver.findElement(By.xpath("//a[@data-product-id='4']"))).build().perform();
		driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
		WebElement element = driver.findElement(By.xpath("//a[@data-product-id='1']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		productdetailpage.Click_On_View_Cart();
		viewcartPage.Click_Processed_to_Checkout_Button();
		viewcartPage.Click_Register_Login_Button();
		loginpage.Enter_name("geeta");
		loginpage.Enter_email("geetanichal@123");
		loginpage.Click_On_Signup();

		account_Information_Page.Enter_Title();
		account_Information_Page.Enter_password1("Geeta@23");
		account_Information_Page.Enter_date_of_Birth();
		account_Information_Page.Enter_Month_of_Birth();
		account_Information_Page.Enter_Year_of_Birth();
		account_Information_Page.Select_Checkbox_Sign_up_for_our_newsletter();
		Thread.sleep(1000);
		account_Information_Page.Select_Checkbox_Receive_special_offers_from_our_partners();
		account_Information_Page.Enter_Firstname("Geeta");
		account_Information_Page.Enter_Lastname("Bhairat");
		account_Information_Page.Enter_Company("Thinkmind");
		account_Information_Page.Enter_address("PUNE");
		account_Information_Page.Select_Country();
		account_Information_Page.Enter_State("MAHARASTRA");
		account_Information_Page.Enter_City("pune");
		account_Information_Page.Enter_Zipcode("411033");
		account_Information_Page.Enter_Mobilenumber("7378416678");
		account_Information_Page.Create_Account();
		Assert.assertTrue(accountcreatedpage.Verify_Account_Created());
		accountcreatedpage.Click_On_Continue();
		// String Expected_Name = "geeta";
		//Thread.sleep(5000);
		homepage.Click_On_Cart_Button();
		viewcartPage.Click_Processed_to_Checkout_Button();
		//Thread.sleep(2000);
		Assert.assertTrue(checkoutPage.Verify_Address_Details());
		Assert.assertTrue(checkoutPage.Verify_Review_YourOrder());
		checkoutPage.Enter_Description_In_Comment_Text_Area();
		checkoutPage.Click_Place_Order();
		paymentPage.Enter_name_on_card("geeta");
		paymentPage.Enter_Number("654654654");
		paymentPage.Enter_CVV("456");
		paymentPage.Enter_Expiry_month("11");
		paymentPage.Enter_Expiry_Year("2026");
		paymentPage.Click_On_Pay_And_Confirm_Order();
		//Thread.sleep(2000);
		paymentPage.Click_On_Download_Invoice();
		homepage.Click_On_Delete_Account();
	}

	@Test(testName = "Verify Scroll Up using 'Arrow' button and Scroll Down functionality", priority = 25)
	public void Verify_Scroll_Up_Using_Arrow_Button_And_Scroll_Down_Functionality() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		Actions a = new Actions(driver);
		a.scrollToElement(driver.findElement(By.id("susbscribe_email"))).build().perform();
		Assert.assertTrue(homepage.Verify_Tet_Avaialble("Subscription"));
		homepage.Click_On_Move_To_Top_Button();

	}

	@Test(testName = "Verify Scroll Up without 'Arrow' button and Scroll Down functionality", priority = 26)
	public void Verify_Scroll_Up_Without_Arrow_Button_And_Scroll_Down_Functionality() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		Actions a = new Actions(driver);
		a.scrollToElement(driver.findElement(By.id("susbscribe_email"))).build().perform();
		Assert.assertTrue(homepage.Verify_Tet_Avaialble("Subscription"));
		a.scrollToElement(driver.findElement(By.xpath("//a[text()=' Home']"))).build().perform();

	}

}