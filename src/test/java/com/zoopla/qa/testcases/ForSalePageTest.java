package com.zoopla.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zoopla.qa.base.TestBase;
import com.zoopla.qa.pages.ForSalePage;
import com.zoopla.qa.pages.HomePage;

public class ForSalePageTest extends TestBase{
	
	ForSalePage forSalePage;
	HomePage homepage;
	
	public ForSalePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setupForSalePage()
	{
		initialization();
		homepage =new HomePage();
		forSalePage=homepage.searchForSaleLocation(prop.getProperty("location"));
	}
	
	@Test(priority=1)
	public void getAllPropPriceReverseTest(){
		forSalePage.getAllPropPriceReverse();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
