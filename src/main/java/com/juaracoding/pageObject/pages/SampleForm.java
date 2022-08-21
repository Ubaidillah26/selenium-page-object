package com.juaracoding.pageObject.pages;

import java.util.List;

import javax.swing.MenuElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageObject.drivers.DriverSingleton;

	public class SampleForm {
		
		private WebDriver driver;

		public SampleForm() {
			this.driver = DriverSingleton.getDriver();
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//label[contains(@for, 'gender-radio')]")
		private List <WebElement> listGender;
		
		@FindBy(xpath = "//label[contains(@for, 'hobbies-checkbox')]")
		private List <WebElement> listHobi;
		
		@FindBy(xpath = "//input[@id= 'uploadPicture']")
		private WebElement uploadFile;
		
		@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")
		private WebElement menuElement;
		
		@FindBy(xpath = "//div[@class='element-list collapse show'//li[contains (@id, 'item')]")
		private List <WebElement> listMenuElement;
		
		public void pilihGender(int pilih) {
			listGender.get(pilih).click();
			System.out.println(listGender.get(pilih).getText());
		}
		
		public void pilihHobi(int pilih) {
			listHobi.get(pilih).click();
			System.out.println(listHobi.get(pilih).getText());
		}
		
		public void uploadGambar() {
			uploadFile.sendKeys("D:\\myAvatar.png");
		}
		
		public void pilihMenuElement() {
			menuElement.click();
			listMenuElement.get(0).click();
			System.out.println(listMenuElement.get(0).getText());
		}
	}
