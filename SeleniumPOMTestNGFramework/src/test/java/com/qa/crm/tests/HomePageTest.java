package com.qa.crm.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.crm.base.BaseTest;
import com.qa.crm.constants.AppConstants;

public class HomePageTest extends BaseTest
{
	@BeforeClass
	public void homeSetup()
	{
		homePage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void homePageTitleTest()
	{
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle,AppConstants.HOME_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void isHomePageIconTest()
	{
		Assert.assertTrue(homePage.isHomePageIconExists());
	}
	
	@Test(priority = 3)
	public void isCalendarPageIconTest()
	{
		Assert.assertTrue(homePage.isCalendarIconExists());
	}
	
	@Test(priority = 4)
	public void isContactsPageIconTest()
	{
		Assert.assertTrue(homePage.isContactsIconExists());
	}
	
	@Test(priority = 5)
	public void homePageHeadersCountTest()
	{
		Assert.assertEquals(homePage.getTotalHomePageHeaderCount(),AppConstants.HOME_PAGE_HEADERS_COUNT);
	}
	
	@Test(priority = 6)
	public void homePageHeadersTest()
	{
		List<String> headersList = homePage.getHomePageHeaders();
		Assert.assertEquals(headersList,AppConstants.EXPECTED_HOME_HEADERS_LIST);
	}
	
	@Test(priority = 7)
	public void searchCountTest()
	{
		resultPage = homePage.doSearch("TOM");
		Assert.assertEquals(resultPage.getResultsSearchCount(),9);
	}
	@Test(priority = 8)
	public void returnBackToHomePageTest()
	{
		homePage = resultPage.returnBackToHomePage();
	}
	@Test(priority = 9)
	public void searchTest()
	{
		resultPage = homePage.doSearch("TOM");
		personDetailPage = resultPage.selectContact("TOM CRUISE"); 
		Assert.assertEquals(personDetailPage.getPersonHeader(), "TOM CRUISE");
		
	}
}
