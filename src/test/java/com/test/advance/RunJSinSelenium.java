package com.test.advance;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;

public class RunJSinSelenium extends BaseClass {

	@Test
	public void runJsinSelenium() {

		driver.get("https://www.saucedemo.com/");
		WebElement username = driver.findElement(By.name("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));
		// Standard User
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		loginButton.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		String title = (String) js.executeScript("return document.title;");
		System.out.println(title);

		js.executeScript("window.scrollBy(0,200)");
	}
}
