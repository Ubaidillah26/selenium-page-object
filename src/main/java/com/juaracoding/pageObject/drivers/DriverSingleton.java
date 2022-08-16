package com.juaracoding.pageObject.drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.juaracoding.pageObject.drivers.strategis.DriverStrategis;
import com.juaracoding.pageObject.drivers.strategis.DriverStrategisImplementer;

public class DriverSingleton {

	private static DriverSingleton instance = null;
	private static WebDriver driver;
	
	private DriverSingleton(String driver) {
		instantiate(driver);
	}
	
	public WebDriver instantiate(String strategis) {
		DriverStrategis driverStrategis = DriverStrategisImplementer.chooseStrategis(strategis);
		driver = driverStrategis.setStrategis();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public static DriverSingleton getInstance(String driver) {
		if( instance == null) {
			instance = new DriverSingleton(driver);
		}
		return instance;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
}
