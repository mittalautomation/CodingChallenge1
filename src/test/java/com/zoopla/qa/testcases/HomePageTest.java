package com.zoopla.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zoopla.qa.base.TestBase;
import com.zoopla.qa.pages.ForSalePage;
import com.zoopla.qa.pages.HomePage;

public class HomePageTest extends TestBase {
	HomePage homepage;
	ForSalePage forSalePage;
	
	public HomePageTest()
	{
		super();// call Testbase class constructor
	}
	@BeforeMethod
	public void setupHomePage()
	{
		initialization();
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		Assert.assertEquals(driver.getTitle(), prop.getProperty("expectedTitle"));
	}
	
	@Test(priority=2)
	public void verifyForSalePageLocationTest()
	{		homepage=new HomePage();
		forSalePage=homepage.searchForSaleLocation(prop.getProperty("location"));
		Assert.assertTrue(forSalePage.verifyLocation(prop.getProperty("location")));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
