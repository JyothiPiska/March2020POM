package com.qa.hubspot.testPages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseClass;
import com.qa.hubspot.pageclasses.HomePage;
import com.qa.hubspot.pageclasses.LoginPage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest {
	WebDriver driver;

	BaseClass basePage;
	LoginPage loginPage;
	Properties prop;
	HomePage homePage;
	

	@BeforeTest
	public void setUp() {
		basePage = new BaseClass();
		prop= basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}
	@Test
	public void verifyHomePageTitle() {
		String title = homePage.getHomepageTitle();
		System.out.println("HomePage page title is: " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "Home page title is not matched...");
	}

	@Test
	public void verifyHomePageHeaderTest() {
		String title = homePage.getHeaderText();
		System.out.println("HomePage page title is: " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_HEADER_TITLE, "Home page header title is not matched...");
	}

	@Test
	public void verifyLoggedInUserTest() {
		String userName = homePage.getLoggedinUser();
		System.out.println("Logged in Username is: " + userName);
		Assert.assertEquals(userName, prop.getProperty("accoutName"), "Logged inusername is not matched...");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
