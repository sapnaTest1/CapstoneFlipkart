package com.qa.testscripts;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class FlipKartTestSuite {

	Search search;
	Product product;	
	Cart cart;
	
   EdgeDriver driver; //= new ChromeDriver();

	@BeforeSuite
	public void initializeDriver() {
		WebDriverManager.edgedriver().setup();
		//System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver = new EdgeDriver();
		driver.get ("https://www.flipkart.com/");
		driver.manage().window().maximize();
		search = new Search(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	

	@Test(priority=1)
	public void LoginPopupCloseTest() throws InterruptedException {
		
		search.closeLoginPopup();		
	}

	@Test(priority=2)
	public void ProductSearch() throws InterruptedException {
		
		search.searchProduct("Macbook air m2");
	}

	@Test(priority=3)
	public void FirstNameLabelTest() throws InterruptedException {
		
		search.openFirstSearchResult();		
		System.out.println("5");
	}

	@Test(priority=4)
	public void swithToProductTab() throws InterruptedException {
	

		String originalWindow = driver.getWindowHandle();

		//Loop through until we find a new window handle
		for (String windowHandle : driver.getWindowHandles()) {
			if(!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		product = new Product(driver);
		cart = new Cart(driver);

	}

	
	@Test(priority=5)
	public void AddToCartTest() throws InterruptedException {
		Thread.sleep(1000);
		product.addToCart();		
	}
	
	@Test(priority=6)
	public void CartButtonTest() throws InterruptedException {
		Thread.sleep(1000);
		cart.openShoppingCart();		
	}

	@Test(priority=7)
	public void CartAddedTest() throws InterruptedException {
		Thread.sleep(1000);
		assertEquals(cart.getCartName(), "Flipkart (1)","Item failed to be added to cart");
			}
	@AfterSuite 
	public void closeDriver()
	{
		driver.quit();
	}
}
    