package com.juaracoding.pageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageObject.drivers.DriverSingleton;
import com.juaracoding.pageObject.pages.SampleAlert;

public class TestAlert {

	public static WebDriver driver;
	private SampleAlert sampleAlert;

	@BeforeClass
	public void setUp() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://demoqa.com/alerts";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObject() {
		sampleAlert = new SampleAlert();
	}

	@Test
	public void testAlert() {
		sampleAlert.clickme();
//		driver.switchTo().alert().accept();
		String txtAlert = driver.switchTo().alert().getText();
		delay(1);
		driver.switchTo().alert().dismiss();
		System.out.println(sampleAlert.getTxtConfirmResult());
		System.out.println(txtAlert);
		String txt = sampleAlert.getTxtConfirmResult();
		assertTrue(txt.contains("Cancel"));
	}

	@Test
	public void testAlertTwo() {
		scroll(500);
		sampleAlert.clickMeTwo();
//		driver.switchTo().alert().accept();
		driver.switchTo().alert().sendKeys("Test");
		delay(1);
		driver.switchTo().alert().accept();
		System.out.println(sampleAlert.getTxtPromptResult());
		String txt = sampleAlert.getTxtPromptResult();
		assertTrue(txt.contains("Test"));
	}

	@AfterClass
	public void closeBrowser() {
		delay(3);
		driver.quit();
	}

	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static void scroll(int vertical) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+vertical+")");
	}
}
