package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crm.constants.AppConstants;
import com.qa.crm.utils.ElementUtil;

public class LoginPage 
{
	/*POM class always return something. Methods in POM class cannot be of void return type.
	 * POM class has private WebDriver with private by class members with public constructors.
	 */
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By userName = By.name("email");
	private By password = By.name("password");
	private By loginBtn = By.xpath("//div[text()='Login']");
	private By forgotPasswordLink = By.linkText("Forgot your password?");
	private By bellIconImage = By.cssSelector("div[class*='md']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getLoginPageTitle()
	{
		String pageTitle = eleUtil.waitForTitleContainsAndReturn(AppConstants.LOGIN_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Login Page Title : "+pageTitle);
		return pageTitle;
	}
	
	public String getCurrentUrl()
	{
		String pageUrl = eleUtil.waitForURLContainsAndReturn(AppConstants.LOGIN_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Login Page URL : "+pageUrl);
		return pageUrl;
	}
	
	public boolean isForgotPwdLinkExists()
	{
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}
	
	public boolean isBellIconImagePresent()
	{
		return  eleUtil.isElementDisplayed(bellIconImage);

	}
	
	public HomePage doLogin(String un,String pwd)
	{
//		eleUtil.doSendKeysWithPause(userName, un, AppConstants.DEFAULT_LONG_TIME_OUT);
		eleUtil.doSendKeys(userName, un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new HomePage(driver);
	}
	
	

}
