package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseClass {
	
	/**
	 * 
	 * @author Jyothi
	 *
	 */


		WebDriver driver;
		Properties prop;

		/**
		 * this method is used to initialize the WebDriver on the basis of browser
		 * 
		 * @param prop
		 * @return driver
		 */
		public WebDriver init_driver(Properties prop) {
			 String browsweName=prop.getProperty("browser");

			if (browsweName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jyothi\\Downloads\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browsweName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browsweName.equalsIgnoreCase("safari")) {
				//WebDriverManager.getInstance(SafariDriver.class).setup();
				driver = new SafariDriver();
			}

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			driver.get(prop.getProperty("url"));

			return driver;

		}

		/**
		 * this method is used to initialize the properties from config.proeprties
		 * file
		 * 
		 * @return prop
		 */
		public Properties init_prop() {
			prop = new Properties();
			try {
				FileInputStream ip = new FileInputStream("./src/main/java/com/qa/hubspot/config/config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return prop;

		}


	
	}

