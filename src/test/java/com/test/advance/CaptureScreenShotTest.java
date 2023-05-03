package com.test.advance;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;

public class CaptureScreenShotTest extends BaseClass {

	@Test
	public void captureScreenshot() {
		String unique = UUID.randomUUID().toString();

		driver.get("https://www.saucedemo.com/");
		WebElement username = driver.findElement(By.name("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));
		// Standard User
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		loginButton.click();

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileHandler.copy(screenshot, new File("./target/" + unique + "SS-screenshot.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
