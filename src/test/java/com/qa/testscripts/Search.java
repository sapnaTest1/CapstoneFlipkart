package com.qa.testscripts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Search {

	EdgeDriver driver;
	
	By loginPopupCloseButton = By.xpath("/html/body/div[3]/div/span");
	By searchBox = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/header/div[1]/div[2]/form/div/div/input");
	By firstSearchResult = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div/div/img\r\n");
	
	public Search(EdgeDriver driver) {
		this.driver = driver;
	}
	
	public void searchProduct(String productName) {
		driver.findElement(searchBox).sendKeys(productName);	
		driver.findElement(searchBox).sendKeys(Keys.RETURN);
	}
	
	public void closeLoginPopup() {
		driver.findElement(loginPopupCloseButton).click();
	}
	
	public void openFirstSearchResult() {
		driver.findElement(firstSearchResult).click();
	}
	
}
