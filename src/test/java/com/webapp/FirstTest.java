package com.webapp;

import org.testng.annotations.Test;

import com.base.BaseTest;


public class FirstTest extends BaseTest{

	@Test
	public void firstTestMethod() {
		String baseURL ="https://demo.guru99.com/test/newtours/index.php";
		driver.get(baseURL);
	}


}
