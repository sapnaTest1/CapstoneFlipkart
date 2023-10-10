package com.qa.testscripts;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Cart {

	EdgeDriver driver;
	
	By cartButton = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[6]/div/div/a/span");
	
	By cartName = By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[1]/div/div/a[1]");
	
	public Cart(EdgeDriver driver) {
		this.driver = driver;
	}
	
	public void openShoppingCart() {
		driver.findElement(cartButton).click();
	}
	
	public String getCartName() {
		return driver.findElement(cartName).getText();
	}
}
