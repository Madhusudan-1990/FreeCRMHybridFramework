package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	/*POM class always return something. Methods in POM class cannot be of void return type.
	 * POM class has private WebDriver with private by class members with public constructors.
	 */
	private WebDriver driver;
	
	private By userName = By.name("email");
	private By password = By.name("password");
	private By loginBtn = By.xpath("//div[text()='Login']");
	private By forgotPasswordLink = By.linkText("Forgot your password?");
	private By bellIconImage = By.cssSelector("div[class*='md']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getLoginPageTitle()
	{
		String pageTitle = driver.getTitle();
		System.out.println("Login Page Title : "+pageTitle);
		return pageTitle;
	}
	
	public String getCurrentUrl()
	{
		String pageUrl= driver.getCurrentUrl();
		System.out.println("Login Page URL : "+pageUrl);
		return pageUrl;
	}
	
	public boolean isForgotPwdLinkExists()
	{
		boolean flag = driver.findElement(forgotPasswordLink).isDisplayed();
		return flag;
	}
	
	public boolean isBellIconImagePresent()
	{
		boolean flag = driver.findElement(bellIconImage).isDisplayed();
		return flag;
	}
	
	public String doLogin(String un,String pwd)
	{
		driver.findElement(userName).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		String cogmentoTitle = driver.getTitle();
		return cogmentoTitle;
	}
	
	

}
