package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crm.constants.AppConstants;
import com.qa.crm.utils.ElementUtil;

public class ResultsPage 
{
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By searchHeader = By.xpath("//span[@class='selectable ']");
	private By results = By.cssSelector("tbody tr");
	
	public ResultsPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}
	
	public String getSearchHeader()
	{
		String searchHeaderValue = eleUtil.waitForElementVisible(searchHeader,AppConstants.DEFAULT_SHORT_TIME_OUT).getText(); 
		return searchHeaderValue;
	}
	
	public int getResultsSearchCount()
	{
		int resultCount = eleUtil.waitForElementsVisible(results,AppConstants.DEFAULT_SHORT_TIME_OUT).size();
		System.out.println("Search result count =======> "+resultCount);
		return resultCount;
	}
	
	public PersonDetailsPage selectContact(String contactName)
	{
		//Dynamic By Locators(Dynamic Contact Name)
		System.out.println("Selecting the Contact : "+contactName);
		eleUtil.doClick(By.linkText(contactName));
		return new PersonDetailsPage(driver);
	}
	
	public HomePage returnBackToHomePage()
	{
		eleUtil.navigateBack();
		return new HomePage(driver);
	}

}
