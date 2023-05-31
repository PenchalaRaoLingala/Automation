package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.BasePageObject;

public class LoginPage extends BasePageObject<LoginPage>{
	
	String baseURL ="https://demo.guru99.com/test/newtours/index.php";
	
	By toursUsername = By.xpath("//input[@name='userName']");
    By toursPassword = By.xpath("//input[@name='password']");
    By toursLogin = By.xpath("//input[@name='submit']");


	public LoginPage(WebDriver driver) {
		super(driver);
	}
	 public void openURL() {
		 System.out.println("Launching the URL on the browser");
		 getURL(baseURL);
	 }
	 
	 public void enterCredentials(String username, String password) {
		 System.out.println("Entering the user credentials");
		 type(username, toursUsername);
		 type(password, toursPassword);
	 }
	 
	 public void clickSignIn() {
		 click(toursLogin);
	 }
	

}
