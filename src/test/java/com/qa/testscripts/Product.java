package com.qa.testscripts;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Product {
	
	EdgeDriver driver;
	
	By addToCartButton = By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button");
	
	public Product(EdgeDriver driver) {
		this.driver = driver;
	}
	
	public void addToCart() {
		driver.findElement(addToCartButton).click();
	}
}
