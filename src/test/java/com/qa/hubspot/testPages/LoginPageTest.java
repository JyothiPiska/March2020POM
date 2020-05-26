package com.qa.hubspot.testPages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseClass;
import com.qa.hubspot.pageclasses.LoginPage;
import com.qa.hubspot.utils.Constants;

public class LoginPageTest {

	WebDriver driver;

	BaseClass basePage;
	LoginPage loginPage;
	Properties prop;

	@BeforeTest
	public void setUp() {
		basePage = new BaseClass();
		prop= basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
	}

	@Test(priority = 2)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.doGetTitle();
		System.out.println("login page title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "login page title is not matched...");
	}

	@Test(priority = 1)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.verifySignup(), "sing up link is not displayed....");
	}

	@Test(priority = 3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
