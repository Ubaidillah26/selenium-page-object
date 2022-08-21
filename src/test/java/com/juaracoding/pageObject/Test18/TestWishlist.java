package com.juaracoding.pageObject.Test18;

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

import com.juara.coding.PageObject.PostTest18.SampleWishlist;
import com.juaracoding.pageObject.drivers.DriverSingleton;


	public class TestWishlist {

		public static WebDriver driver;
		private SampleWishlist sampleWishlist ;

		@BeforeClass
		public void setUp() {
			DriverSingleton.getInstance("Chrome");
			driver = DriverSingleton.getDriver();
			String url = "https://automationpractice.com/";
			driver.get(url);
		}

		@BeforeMethod
		public void pageObject() {
			sampleWishlist = new SampleWishlist();
		}
		
		@Test
		public void testWishlist1() {
			scroll(700);
			sampleWishlist.btnChart1();
			sampleWishlist.btnCloseChart1();
			sampleWishlist.btnChart2();
			sampleWishlist.btnCloserChart2();
			sampleWishlist.btnSearch();
		}

		@Test
		public void testWishlist() {
			sampleWishlist.txtSearch();
			driver.switchTo().alert().sendKeys("Blouse");
			delay(1);
			driver.switchTo().alert().accept();
			System.out.println();
			String txt = sampleWishlist.txtSearch();
			assertTrue(txt.contains("Blouse"));
			sampleWishlist.btnSearch();
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

