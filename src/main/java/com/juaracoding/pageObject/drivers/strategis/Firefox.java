package com.juaracoding.pageObject.drivers.strategis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategis  {

	public WebDriver setStrategis() {
		System.setProperty("webdriver, gecko.driver", "D:\\chromedriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
}
