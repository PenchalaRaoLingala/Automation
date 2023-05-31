package com.base;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeTest
	@Parameters("browser")
	protected void setUp(String browser) throws Exception {
		//Check if parameter passed as 'chrome'
		if(browser.equalsIgnoreCase("Chrome")){
			System.out.println("Setting up Chrome driver");
			System.setProperty("Webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}
		//Check if parameter passed as 'Edge'
		else if(browser.equalsIgnoreCase("Edge")){
			//set path to Edge.exe
			System.setProperty("webdriver.edge.driver","src\\test\\resources\\msedgedriver.exe");
			//create Edge instance
			driver = new EdgeDriver();
		}else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterTest
	protected void TearDown() {
		System.out.println("Method tear down");
		driver.quit();
	}

}
