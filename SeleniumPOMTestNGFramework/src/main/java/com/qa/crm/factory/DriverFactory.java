package com.qa.crm.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.crm.exceptions.BrowserException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{
	/**
	 * This method is used to init the driver on the basis of given browsername.
	 * @param browserName
	 * @return it returns driver
	 */
	WebDriver driver;
	Properties prop;
	public WebDriver initDriver(Properties prop)
	{
		String browserName = prop.getProperty("browser");
		System.out.println("Browser Name : "+browserName);
		switch(browserName.toLowerCase().trim())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
			
		default:
			System.out.println("Please pass on the right browser name !!!"+browserName);
			throw new BrowserException("INVALID BROWSER "+browserName);	

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	/**
	 * This method is used to initialize the property from the config file.
	 * @return
	 */
	public Properties initProp()
	{
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
}
