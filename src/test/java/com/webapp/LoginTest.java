package com.webapp;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.base.ExcelReader;
import com.pages.LoginPage;


public class LoginTest extends BaseTest{
	
	@Test
	public void positiveLoginTest() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		
		ExcelReader excel = new ExcelReader();
		excel.setExcelFile("src//test//resources//Guru99_TestData.xlsx", "Sheet1");
		String uname = excel.getCellData("UserName", 1);
		String pass = excel.getCellData("Password", 1);
	
		loginpage.openURL();
		loginpage.enterCredentials(uname, pass);
		loginpage.clickSignIn();
		
		Thread.sleep(2000);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Login: Mercury Tours";
		Assert.assertTrue(expectedTitle.equalsIgnoreCase(expectedTitle), "page title is not correct");
		
	}

}
