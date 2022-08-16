package com.juaracoding.pageObject.main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.juaracoding.pageObject.drivers.DriverSingleton;
import com.juaracoding.pageObject.pages.Login;
import com.juaracoding.pageObject.pages.LoginPage;
import com.juaracoding.pageObject.pages.Register;

public class MainApp {

	public static void main(String[] args) {

		DriverSingleton.getInstance("Chrome");
		WebDriver driver = DriverSingleton.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String url="https://shop.demoqa.com/my-account/";
		driver.get(url);
	
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		js.executeScript("arguments[0].scrollIntoView()", username);
		
		Login login = new Login();
		login.login("admin","admin1234");
		System.out.println("Login Gagal. Kamu Belum Bikin Akun!");
		
		Register Reg = new Register();
		Reg.register("Ubai","ubaidillah.jobs@gmail.com","ubai123");
		System.out.println("Kamu Berhasil Registrasi");
		
		delay(3);
//		driver.quit();
		
	}

	static void delay(int detik){
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
