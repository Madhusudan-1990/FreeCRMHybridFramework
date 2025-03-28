package com.qa.crm.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.crm.factory.DriverFactory;
import com.qa.crm.pages.FormPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.pages.PersonDetailsPage;
import com.qa.crm.pages.ResultsPage;

public class BaseTest 
{
	
	WebDriver driver;
	DriverFactory df;
	protected Properties prop;
	
	protected LoginPage loginPage;
	protected HomePage homePage;
	protected ResultsPage resultPage;
	protected PersonDetailsPage personDetailPage;
	protected FormPage formPage;
	
	@BeforeTest
	public void setup()
	{
		df = new DriverFactory();
		prop = df.initProp();
		
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
