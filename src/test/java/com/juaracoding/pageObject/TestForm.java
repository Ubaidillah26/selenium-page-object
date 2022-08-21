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
	import com.juaracoding.pageObject.pages.Modal;
	import com.juaracoding.pageObject.pages.SampleAlert;
import com.juaracoding.pageObject.pages.SampleForm;

	public class TestForm {

		public static WebDriver driver;
		private SampleForm sampleForm ;

		@BeforeClass
		public void setUp() {
			DriverSingleton.getInstance("Chrome");
			driver = DriverSingleton.getDriver();
			String url = "https://demoqa.com/automation-practice-form\r\n";
			driver.get(url);
		}

		@BeforeMethod
		public void pageObject() {
			sampleForm = new SampleForm();
		}

		@Test
		public void testForm() {
			sampleForm.pilihGender(0);
			sampleForm.pilihGender(1);
			sampleForm.pilihGender(2);
			scroll(500);
			sampleForm.pilihHobi(0);
		 	sampleForm.pilihHobi(1);
			sampleForm.pilihHobi(2);
			sampleForm.uploadGambar();
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
