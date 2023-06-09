package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T>  {

	protected WebDriver driver;
	protected WebDriverWait wait;

	protected BasePageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	protected void getURL(String url) {
		driver.get(url);
	}
	protected void type(String text, By element) {
		find(element).sendKeys(text);
	}
	
	protected void click(By element) {
		find(element).click();
	}

	private WebElement find(By element) {
		return driver.findElement(element);
	}
	
	protected void waitForVisibilityOf(By locator, Integer...timeOutInSeconds) {
		int attempts=0;
		while(attempts<2) {
			
		}
		
	}
	

}
