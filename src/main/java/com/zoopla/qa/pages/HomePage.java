package com.zoopla.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(name="q")
	WebElement txtboxSearch;
	
	@FindBy(xpath="//button[@type='submit'][@id='search-submit']")
	WebElement btnSearch;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public ForSalePage searchForSaleLocation(String location)
	{
		txtboxSearch.sendKeys(location);
		btnSearch.click();
		
		return new ForSalePage();
		
	}

}
