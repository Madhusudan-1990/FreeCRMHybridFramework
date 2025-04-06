package com.qa.crm.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.crm.base.BaseTest;
import com.qa.crm.constants.AppConstants;
import com.qa.crm.listeners.AnnotationTransformer;
import com.qa.crm.listeners.ExtentReportListener;
@Listeners({AnnotationTransformer.class,ExtentReportListener.class})
public class LoginPageTest extends BaseTest
{
	@Test
	public void loginPageTitleTest()
	{
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle,AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void loginPageURLTest()
	{
		String actualUrl = loginPage.getCurrentUrl();
		Assert.assertTrue(actualUrl.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
	}
	
	@Test
	public void bellIconExist()
	{
		Assert.assertTrue(loginPage.isBellIconImagePresent());
	}
	
	@Test(priority = Integer.MAX_VALUE)
	public void loginTest()
	{
		homePage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertEquals(homePage.getHomePageTitle(),AppConstants.LOGIN_PAGE_TITLE);
	}
}
