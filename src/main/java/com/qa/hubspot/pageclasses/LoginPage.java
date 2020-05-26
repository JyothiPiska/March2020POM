package com.qa.hubspot.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BaseClass;

public class LoginPage extends BaseClass {

	private WebDriver driver;

	// 2. create const.. of page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// OR- object repository

	By username = By.id("username");
	By password = By.id("password");
	By login = By.id("loginBtn");
	By signUp = By.linkText("Sign up");

	// 3. page actions:

	public String doGetTitle() {
		return driver.getTitle();
	}

	public boolean verifySignup() {
		return driver.findElement(signUp).isDisplayed();
	}

    // doLogin method return the Homepage object ..it will call the HomePage constructor 
	public HomePage doLogin(String username, String pasword) {
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(pasword);
		driver.findElement(login).click();
		return new HomePage(driver); // creating Home page object here using page chaining

	}

}
