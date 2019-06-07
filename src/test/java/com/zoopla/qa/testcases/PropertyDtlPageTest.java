package com.zoopla.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.qa.base.TestBase;
import com.zoopla.qa.pages.ForSalePage;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.PropertyDtlPage;

public class PropertyDtlPageTest extends TestBase{
	
	HomePage homepage;
	ForSalePage forSalePage;
	PropertyDtlPage propertyDtlPage;
	
	public PropertyDtlPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setupPropertyDtlPage(){
		initialization();
		homepage=new HomePage();
		forSalePage=homepage.searchForSaleLocation(prop.getProperty("location"));
		propertyDtlPage=forSalePage.getPropertyByPosition(Integer.parseInt(prop.getProperty("position")));
	}
	
	@Test(priority=1)
	public void getAgentDetaillistTest(){
		propertyDtlPage.getAgentDetails();
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
}

}
