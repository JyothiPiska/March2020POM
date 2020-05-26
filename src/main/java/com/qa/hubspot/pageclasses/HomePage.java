package com.qa.hubspot.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BaseClass;

public class HomePage extends BaseClass {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// OR -object repository

	By header = By.xpath("//i18n-string[text()= 'Dashboard Library']");
	By accountName = By.cssSelector("span.account-name");

	// HomePage actions

	public String getHomepageTitle() {
		return driver.getTitle();
	}

	public String getHeaderText() {
		if (driver.findElement(header).isDisplayed()) {
			return driver.findElement(header).getText();
		}
		return null;

	}

	public String getLoggedinUser() {
		if (driver.findElement(accountName).isDisplayed()) {
			return driver.findElement(accountName).getText();
		}
		return null;

	}

}
