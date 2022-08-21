package com.juara.coding.PageObject.PostTest18;


import java.util.List;

import javax.swing.MenuElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageObject.drivers.DriverSingleton;

	public class SampleWishlist {
		
		private WebDriver driver;

			public SampleWishlist() {
				this.driver = DriverSingleton.getDriver();
				PageFactory.initElements(driver, this);
			}
			//input[@id='search_query_top']
			@FindBy(xpath = "//input[@id='search_query_top']")
			private WebElement txtSearch;
			
			@FindBy(xpath = "//button[@name='submit_search']")
			private WebElement btnSearch;
			
			@FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered']//span[contains(text(),'Add to cart')]")
			private WebElement btnChart1;
			
			@FindBy(xpath = "//span[@title='Close window']")
			private WebElement btnCloseChart1;
			
			@FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-mobile-line hovered']//span[contains(text(),'Add to cart')]")
			private WebElement btnChart2;
			
			@FindBy(xpath = "//span[@title='Close window']")
			private WebElement btnCloseChart2;
			
			public String txtSearch() {
				return txtSearch.getText();
			}
			
			public void btnSearch() {
				btnSearch.click();
			}
			
			public void btnChart1() {
				btnChart1.click();
			}
			
			public void btnCloseChart1() {
				btnCloseChart1.click();
			}
			
			public void btnChart2() {
				btnChart2.click();
			}
			
			public void btnCloserChart2() {
				btnCloseChart2.click();
			}
			
//			public void uploadGambar() {
//				uploadFile.sendKeys("D:\\myAvatar.png");
//			}
//			
//			public void pilihMenuElement() {
//				menuElement.click();
//				listMenuElement.get(0).click();
//				System.out.println(listMenuElement.get(0).getText());
//			}
		}
