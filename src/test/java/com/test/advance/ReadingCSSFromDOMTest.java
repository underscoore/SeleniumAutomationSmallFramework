package com.test.advance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;

public class ReadingCSSFromDOMTest extends BaseClass {
	String ActualTitle = "Swag Labs";

	@Test
	public void getTheProductTitleCSSProperties() {
		System.out.println(driver);
		driver.get("https://www.saucedemo.com/");
		WebElement username = driver.findElement(By.name("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));
		// Standard User
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		loginButton.click();

		WebElement firstProduct = driver
				.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div"));
		String getColor = firstProduct.getCssValue("color");
		String getFontSize = firstProduct.getCssValue("font-size");
		String getFontStyle = firstProduct.getCssValue("font-style");
		String getProductName = firstProduct.getText();

		System.out.println("Color - " + getColor);
		System.out.println("Font Size - " + getFontSize);
		System.out.println("Font Style - " + getFontStyle);
		System.out.println("Product Name - " + getProductName);

	}
}
