package com.zoopla.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.qa.base.TestBase;
import com.zoopla.qa.pages.AgentsPage;
import com.zoopla.qa.pages.ForSalePage;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.PropertyDtlPage;

public class AgentsPageTest extends TestBase {

	HomePage homepage;
	ForSalePage forSalePage;
	PropertyDtlPage propertyDtlPage;
	AgentsPage agentsPage;

public AgentsPageTest(){
	super();
}

	@BeforeMethod
	public void setupAgentsPage(){
		initialization();
		homepage=new HomePage();
		forSalePage=homepage.searchForSaleLocation(prop.getProperty("location"));
		propertyDtlPage=forSalePage.getPropertyByPosition(Integer.parseInt(prop.getProperty("position")));	
	}
	
	@Test(priority=1)
	public void VerifyagentNameTest()
	{
		agentsPage=propertyDtlPage.clickOnAgentName();
		Assert.assertTrue(agentsPage.getAgentName().contains(propertyDtlPage.AgentName));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
